package com.invenium.libraryapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.invenium.libraryapplication.network.BookListModel
import com.invenium.libraryapplication.network.RetroInstance
import com.invenium.libraryapplication.network.RetroService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel: ViewModel() {

    lateinit var bookList: MutableLiveData<BookListModel>
    init {
        bookList = MutableLiveData()
    }

    fun getBookListObserver(): MutableLiveData<BookListModel>{
        return bookList
    }

    fun makeApiCall(query: String){
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroInstance.getBooklistFromApi(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun getBookListObserverRx(): Observer<BookListModel>{
        return object : Observer<BookListModel>{}
    }
}