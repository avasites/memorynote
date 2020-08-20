package zheev.ru.notememory.helper

import retrofit2.Call
import retrofit2.http.GET
import zheev.ru.notememory.data.Category

interface ApiService {

    @GET("/categories")

    fun fetchAllCategories(): Call<List<Category>>

}