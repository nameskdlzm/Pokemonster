package com.mrhi2024.tpsearchplacebykakao.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitHelper {



    companion object{

        val gson:Gson = GsonBuilder().setLenient().create()

//        fun getRetrofitInstance(baseUrl:String): Retrofit{
//            val retrofit = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            return retrofit

        fun getRetrofitInstance(baseUrl:String): Retrofit{
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit
        }



    }

}