package com.example.kotlinnationinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson:Gson = GsonBuilder().create()
        val inputStream: InputStream =assets.open("nation_data.json")
        val reader:InputStreamReader = InputStreamReader(inputStream)
        val detailData = gson.fromJson(reader,GsonDate::class.java)

        Toast.makeText(this,"0번째 name : " +detailData.data[0].name,Toast.LENGTH_LONG).show()
        for(data in detailData.data){
            Log.e("TAG",data.name)
        }
        var adapter = MyAdapter(this)
        adapter.detailData = detailData
        nationList_rv.layoutManager = LinearLayoutManager(this)
        nationList_rv.adapter = adapter

    }
}
