package com.gwestank.adaptermenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.gwestank.adaptermenu.R
import kotlinx.android.synthetic.main.view_list.view.*


class ViewAdapter(val context: Context, private var items: Array<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var backPressedListener: BackPressedListener? = null

    private val TOOLS_ICONS = arrayOf<Int>(
        R.drawable.ic_food,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContentViewHolder(LayoutInflater.from(context).inflate(R.layout.view_list, null))
    }

    override fun getItemCount(): Int {
        //Log.d("_SS", size.toString())
        //return TOOLS_ICONS.size
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //val item = TOOLS_ICONS!![position]
        val item = items!![position]

        // กำหนดรูปภาพ ให้ id = imgViewDevice
        holder.itemView.imgViewIcon.setImageResource(TOOLS_ICONS!![0])

        // กำหนด ตำแหน่งของ tag ให้ id = imgViewDevice
        holder.itemView.imgViewIcon.setTag(R.id.imgViewIcon, position)

        holder.itemView.lblText.text = item

        // กำหนด ตำแหน่งของ tag ให้ id = relative_container_device
        holder.itemView.relative_container_device.setTag(R.id.relative_container_device, position)
        // holder.itemView.setOnClickListener { backPressedListener!!.onItemClick(item) }
    }

    // สร้าง interface ให้ click หน้า Activity
    interface BackPressedListener {
        fun onItemClick(deviceId: String, deviceName: String, devicePhoto: String, deviceCallName: String)
    }

    fun setOnEventListener(listener: BackPressedListener) {
        this.backPressedListener = listener
    }


    class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Holds the TextView that will add each animal to

        var relativeLayoutContainer: RelativeLayout = view.relative_container_device


    }


}

