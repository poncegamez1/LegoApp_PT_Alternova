package com.poncegamez.legoapp_pt_alternova.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.poncegamez.legoapp_pt_alternova.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        addSubscriptions()
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetailFromServer(args.productId)
    }

    private fun addSubscriptions(){
        viewModel.onDetailState.observe(viewLifecycleOwner){ detailProduct ->
            detailBinding.nameTextView.text = detailProduct.name
            detailBinding.editStockTextView.text = detailProduct.stock.toString()
            detailBinding.editUnitPriceTextView.text = detailProduct.unitPrice.toString()
            detailBinding.editDescriptionTextView.text = detailProduct.description
            Picasso.get().load(detailProduct.image).into(detailBinding.pictureImageView)

        }
    }
}