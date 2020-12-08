package com.example.ktdslibrary

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.concurrent.Flow


class DsDataStore private constructor(){
    var dataStore:DataStore<Preferences>? = null
    companion object{
        var instance :DsDataStore? = null

        get() {
            if (field == null){
                field = DsDataStore()
            }
            return field
        }
    }

    fun get():DsDataStore {
        return instance!!
    }

    fun initDataStore(context: Context){
        dataStore = context.createDataStore(name = "user")
    }

    private suspend fun saveSuCookie(cookie:String){

        dataStore?.edit {
            it[COOKIE] = cookie
        }

    }

    fun saveCookie(cookie: String){
        MainScope().launch {
            saveSuCookie(cookie)
        }
    }


    private suspend fun getSuCookie():String{
        val cookie = dataStore?.data?.map {
            it[COOKIE]
        }
        return cookie?.first()?:""
    }

    fun getCookie(callback: DsCallback<String>){
        MainScope().launch {
            val cookie = getSuCookie()
            callback.getMsg(cookie)
        }
    }




}