package com.poncegamez.legoapp_pt_alternova.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poncegamez.legoapp_pt_alternova.databinding.CardViewLegoItemBinding
import com.poncegamez.legoapp_pt_alternova.model.Product
import com.squareup.picasso.Picasso

class ListLegoAdapter(private val onItemClicked: (Product) -> Unit) :
    RecyclerView.Adapter<ListLegoAdapter.LegoViewHolder>() {

    private val legoItemList: ArrayList<Product> = arrayListOf()

    class LegoViewHolder(private val binding: CardViewLegoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.idTextView.text = product.id.toString()
            binding.nameTextView.text = product.name
            binding.stockTextView.text = product.stock.toString()
            binding.unitPriceTextViewTextView.text = product.unit_price.toString()
            val picasso = Picasso.get()
            picasso.isLoggingEnabled = true
            picasso.load(product.image).into(binding.pictureImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegoViewHolder {
        val binding =
            CardViewLegoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LegoViewHolder, position: Int) {
        val products = legoItemList[position]
        holder.bind(products)
        holder.itemView.setOnClickListener {
            onItemClicked(products)
        }
    }

    override fun getItemCount(): Int {
        return legoItemList.size
    }

    fun appendItems(newItems: List<Product>) {
        legoItemList.clear()
        legoItemList.addAll(newItems)
        notifyDataSetChanged()
    }
}