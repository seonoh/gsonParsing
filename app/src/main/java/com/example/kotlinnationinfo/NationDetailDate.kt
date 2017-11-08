package com.example.kotlinnationinfo

/**
 * Created by 선오 on 2017-11-08.
 */
data class NationDetailDate ( val name:String,
                              val capital:String,
                              val location:String,
                              val volume:String,
                              val weather:String,
                              val language:String)

data class GsonDate(val data:ArrayList<NationDetailDate>)