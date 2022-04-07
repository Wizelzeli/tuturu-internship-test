package com.example.tuturuintershiptest.presentation.ui.catfacts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tuturuintershiptest.R
import com.example.tuturuintershiptest.databinding.RecyclerViewFactBinding
import com.example.tuturuintershiptest.domain.entities.Fact

class RecyclerViewAdapter(private val onItemClicked: (Fact) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    private var facts = ArrayList<Fact>()

    @SuppressLint("NotifyDataSetChanged")
    fun addFact(fact: Fact) {
        facts.add(fact)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearFacts() {
        facts.clear()
        notifyDataSetChanged()
    }

    class RecyclerViewHolder(item: View, onItemClicked: (Int) -> Unit): RecyclerView.ViewHolder(item) {
        init {
            itemView.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }
        private val binding = RecyclerViewFactBinding.bind(item)
        fun bind(fact: Fact) {
            binding.fact.text = fact.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_fact,
            parent,
            false
        )
        return RecyclerViewHolder(view) { onItemClicked(facts[it]) }
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(facts[position])
        holder.itemView.setOnClickListener { onItemClicked(facts[position]) }
    }

    override fun getItemCount(): Int {
        return facts.size
    }

}