package com.poncegamez.legoapp_pt_alternova.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poncegamez.legoapp_pt_alternova.model.Product
import com.poncegamez.legoapp_pt_alternova.repository.LegosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel

class ListViewModel @Inject constructor(
    private val repository: LegosRepository,
    private val coroutineContext: CoroutineContext = Dispatchers.IO): ViewModel() {

    private var productState: MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()
    val onProductsState: LiveData<List<Product>> get() = productState

    fun getProductsFromServer(){
        viewModelScope.launch(coroutineContext) {
            productState.postValue(repository.getAllProducts())
        }
    }
}