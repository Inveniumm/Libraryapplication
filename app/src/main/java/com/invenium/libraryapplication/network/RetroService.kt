package com.invenium.libraryapplication.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("volumes")
    fun getBooklistFromApi(@Query("q") query: String): Observable<BookListModel>
}