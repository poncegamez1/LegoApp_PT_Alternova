package com.poncegamez.legoapp_pt_alternova.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poncegamez.legoapp_pt_alternova.model.DetailProduct
import com.poncegamez.legoapp_pt_alternova.repository.LegosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: LegosRepository,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private var detailState: MutableLiveData<DetailProduct> = MutableLiveData<DetailProduct>()
    val onDetailState: LiveData<DetailProduct> get() = detailState

    fun getDetailFromServer(productId: Int) {
        viewModelScope.launch(coroutineContext) {
            val response = repository.getProductDetail(productId)
            if(response.isPresent){
                detailState.postValue(response.get())
            } else {

            }
        }
    }
}