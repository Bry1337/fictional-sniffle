package bry1337.github.io.cartalog.base

import androidx.lifecycle.ViewModel
import bry1337.github.io.cartalog.injection.component.DaggerViewModelInjector
import bry1337.github.io.cartalog.injection.component.ViewModelInjector
import bry1337.github.io.cartalog.injection.module.NetworkModule

/**
 * Created by edwardbryan.abergas on 07/02/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this){

        }
    }
}