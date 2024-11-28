package com.example.base_view_project.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.base_view_project.R
import com.example.base_view_project.ui.base.BaseViewModel
import com.example.base_view_project.util.PopupContent
import com.example.base_view_project.util.event.BaseEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: BaseViewModel() {

    fun onClickLogout(){
        viewModelScope.launch {
            val isSuccess = awaitEvent(
                BaseEvent.ShowPopup(content = PopupContent.NETWORK_ERR)
            )
            if(isSuccess == true){
                // TODO 로그아웃 로직 실행
                requestAPIData()
                emitEvent(
                    BaseEvent.ShowToast("로그아웃 완료")
                )
            }
        }
    }

    fun onClickToast(){
        viewModelScope.launch {
            emitEvent(BaseEvent.ShowToast("Test"))
        }
    }

    fun onClickBack(){
        viewModelScope.launch {
            val actionId = requestAPIData()
//            emitEvent(BaseEvent.MovePage(R.id.testestest))
        }
    }

    suspend fun requestAPIData(): String{
        delay(2000)
        return "Test"
    }
}