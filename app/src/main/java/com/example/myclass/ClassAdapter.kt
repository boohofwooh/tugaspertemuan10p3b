package com.example.myclass

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myclass.databinding.ItemClassBinding

typealias OnClickClass = (Class) -> Unit

class ClassAdapter(private val listClass: List<Class>, private val onClickClass: OnClickClass) :
    RecyclerView.Adapter<ClassAdapter.ItemClassViewHolder>() {
    inner class ItemClassViewHolder(private val binding:ItemClassBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(data : Class){
            with(binding){
                if (data.major == "Software Engineering"){
                    studentMajor.text = data.major
                    studentMajor.setTextColor(Color.BLUE)
                }
                else if (data.major == "Computer Science"){
                    studentMajor.text = data.major
                    studentMajor.setTextColor(Color.RED)
                }
                else if (data.major == "Information Technology"){
                    studentMajor.text = data.major
                    studentMajor.setTextColor(Color.MAGENTA)
                }
                else if (data.major == "Mechanical Engineering"){
                    studentMajor.text = data.major
                    studentMajor.setTextColor(Color.BLACK)
                }
                else{
                    studentMajor.text = data.major
                    studentMajor.setTextColor(Color.GREEN)
                }
                studentName.text = data.name
                val resID = root.context.resources.getIdentifier(
                    data.profile,
                    "drawable",
                    root.context.packageName
                )
                studentProfile.setImageResource(resID)

                itemView.setOnClickListener{
                    onClickClass(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemClassViewHolder {
        val binding = ItemClassBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemClassViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listClass.size
    }

    override fun onBindViewHolder(holder: ItemClassViewHolder, position: Int) {
        holder.bind(listClass[position])
    }
}