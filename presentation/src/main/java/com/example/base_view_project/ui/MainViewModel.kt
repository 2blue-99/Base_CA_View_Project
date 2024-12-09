package com.example.base_view_project.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base_view_project.ui.base.BaseViewModel
import com.example.base_view_project.util.PopupContent
import com.example.base_view_project.util.event.BaseEvent
import com.example.base_view_project.util.event.resourceHandler
import com.example.domain.model.TestData
import com.example.domain.usecase.TestDaoUseCase
import com.example.domain.usecase.TestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: TestUseCase,
    private val daoUseCase: TestDaoUseCase
): BaseViewModel() {

    private var _testLiveData = MutableLiveData<TestData>()
    val testLiveData: LiveData<TestData> = _testLiveData

    init {
        modelScope.launch {
            daoUseCase.upsert(new())
            daoUseCase.upsert(new())
            daoUseCase.upsert(new())
            daoUseCase.upsert(new())

            useCase.test().resourceHandler(_eventFlow) {
                _testLiveData.value = it
            }

            daoUseCase.getAll().collect {
                Timber.d("room : $it")
            }
        }
    }

    fun new():TestData =
        TestData(
            id = 0,
            title = "test title",
            content = "test content",
            createdAt = "test createdAt",
            updatedAt = "test updatedAt",
            userId = 0
        )

    fun onClickLogout(){
        viewModelScope.launch {
            // 멈춰있다.
            // sharedState를 사용

            // 팝업창 띄어줌
            val isSuccess = awaitEvent(
                BaseEvent.ShowPopup(content = PopupContent.NETWORK_ERR)
            )
            // 멈춰있음
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

    private suspend fun requestAPIData(): String{
        delay(2000)
        return "Test"
    }
}