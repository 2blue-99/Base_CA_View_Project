package com.example.base_view_project.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.base_view_project.BR
import com.example.base_view_project.ui.MainViewModel
import com.example.base_view_project.util.event.BaseEvent
import timber.log.Timber


abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : AppCompatActivity() {

    protected abstract val viewModel: VM
    lateinit var binding: VB

    /**
     * onCreate() | Data Setting
     */
    abstract fun setData()
    /**
     * onCreate() | Observer Setting
     */
    abstract fun setObserver()
    /**
     * onCreate() | Listener Setting
     */
    abstract fun setListener()



    /**
     * Activity Lifecycle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate [${this::class.simpleName}]")
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.apply {
            binding.setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@BaseActivity
        }
        setData()
        setObserver()
        setListener()
    }

    override fun onRestart() {
        Timber.i("onRestart [${this::class.simpleName}]")
        super.onRestart()
    }

    override fun onStart() {
        Timber.i("onStart [${this::class.simpleName}]")
        super.onStart()
    }

    override fun onResume() {
        Timber.i("onResume [${this::class.simpleName}]")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("onPause [${this::class.simpleName}]")
        super.onPause()
    }

    override fun onStop() {
        Timber.i("onStop [${this::class.simpleName}]")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.i("onDestroy [${this::class.simpleName}]")
        super.onDestroy()
    }




    fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun showDialog(event: BaseEvent.ShowPopup){
        AlertDialog.Builder(this)
            .setTitle(event.content.name)
            .setPositiveButton("확인"){ dialog, which ->
                event.tryEmit(true)
            }
            .setNegativeButton("취소"){ dialog, which ->
                event.cancel()
            }
            .setOnDismissListener {
                event.cancel()
            }
            .show()
    }

    protected fun setLoading(state: Boolean){
        if(viewModel is MainViewModel){
            viewModel.isLoading.value = state
        }
    }
}