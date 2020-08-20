package zheev.ru.notememory.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_row.view.*
import zheev.ru.notememory.R
import zheev.ru.notememory.data.Category

class CategoryAdapter(private val categories: List<Category>?): RecyclerView.Adapter<CategoryAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_row, parent, false)
        val ib = view.findViewById<ImageButton>(R.id.add_note)!!

        ib.setOnClickListener{
            val handler = Handlers()
            handler.note(parent.context)
        }
        return  ViewHolder(view)
    }

    override fun getItemCount() = categories!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories!![position]
        holder.name.text = category.name

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.name
    }

}
