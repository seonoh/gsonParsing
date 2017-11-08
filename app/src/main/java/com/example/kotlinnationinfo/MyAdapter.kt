package com.example.kotlinnationinfo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_cell.view.*

/**
 * Created by 선오 on 2017-11-08.
 */
class MyAdapter(val context:Context):RecyclerView.Adapter<MyAdapter.NationViewHolder>() {

    var detailData : GsonDate? = null

    inner class NationViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun toBind(position: Int){
            when(detailData!!.data[position].name){
                "벨기에"->{
                    itemView.nation_img.setImageResource(R.drawable.a)
                }
                "아르헨티나"->{
                    itemView.nation_img.setImageResource(R.drawable.b)
                }
                "브라질"->{
                    itemView.nation_img.setImageResource(R.drawable.c)
                }
                "캐나다"->{
                    itemView.nation_img.setImageResource(R.drawable.d)
                }
                "중국"->{
                    itemView.nation_img.setImageResource(R.drawable.e)
                }

            }
            itemView.nationName_tv.setText(detailData!!.data[position].name)
        }



    }

    override fun onBindViewHolder(holder: NationViewHolder?, position: Int) {
        holder?.toBind(position)
        holder?.itemView?.setOnClickListener{
            Toast.makeText(context,"$position 번째 ${detailData!!.data[position].name} 클릭",Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NationViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_cell,parent,false)
        return NationViewHolder(view)
    }

    override fun getItemCount(): Int = detailData?.data?.size?:0
}