package zheev.ru.notememory.ui.category

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.category_row.*
import kotlinx.android.synthetic.main.fragment_category.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zheev.ru.notememory.MainActivity
import zheev.ru.notememory.R
import zheev.ru.notememory.data.Category
import zheev.ru.notememory.helper.ApiService
import zheev.ru.notememory.helper.CategoryAdapter
import zheev.ru.notememory.helper.Handlers

class CategoryFragment : Fragment() {
    

    private lateinit var categoryViewModel: CategoryViewModel

//    private val recyclerView: RecyclerView? = null;

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        categoryViewModel =
                ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_category, container, false)

        val retrofit =  Retrofit.Builder()
            .baseUrl("http://notes.zheev.ru/categories/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllCategories().enqueue(object: Callback<List<Category>>{
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {

                showData(response.body())

            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                d("zheev","onFailure")
            }
        })

        return root
    }

    private fun showData(categories: List<Category>?) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.getContext())
            adapter = CategoryAdapter(categories)
        }
    }
}