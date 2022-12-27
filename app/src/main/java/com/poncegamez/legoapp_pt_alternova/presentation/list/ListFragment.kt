package com.poncegamez.legoapp_pt_alternova.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.poncegamez.legoapp_pt_alternova.databinding.FragmentListBinding
import com.poncegamez.legoapp_pt_alternova.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var legoAdapter: ListLegoAdapter
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        addSubscriptions()
        setUpAdapter()
        setUpRecyclerView()
        return listBinding.root
    }

    private fun setUpAdapter() {
        legoAdapter = ListLegoAdapter(onItemClicked = { onLegoItemClicked(it) })
    }

    private fun setUpRecyclerView() {
        listBinding.legoListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = legoAdapter
        }
    }

    private fun addSubscriptions() {
        viewModel.onProductsState.observe(viewLifecycleOwner) { result ->
            if (result.isNotEmpty()) {
                legoAdapter.appendItems(result)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProductsFromServer()
    }

    private fun onLegoItemClicked(product: Product) {
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(
                productId = product.id
            )
        )

    }
}