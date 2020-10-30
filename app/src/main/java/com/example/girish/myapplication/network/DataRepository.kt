package com.example.girish.myapplication.network

import com.example.girish.myapplication.model.BasicRequest
import com.example.girish.myapplication.model.BasicResponse
import com.example.girish.myapplication.model.NetworkCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {

    private val apiInterface: APIInterface = RetrofitBuilder.instance!!.create(APIInterface::class.java)

    var customBaseUrl: String = ""


    fun getResult(basicRequest: BasicRequest, networkCallback: NetworkCallback<BasicResponse>) {

        val customAPIInterface = RetrofitBuilder.getInstance(customBaseUrl)
                .create(APIInterface::class.java)

        var basicResponse: BasicResponse? = null
        val call = customAPIInterface.getResult(basicRequest)
        call.enqueue(object : Callback<BasicResponse> {
            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                networkCallback.onFailure(t,1)
                var i = 0
            }

            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                basicResponse = response.body()
                networkCallback.onSuccess(response)
                var t = 0
            }

        })
    }

}

