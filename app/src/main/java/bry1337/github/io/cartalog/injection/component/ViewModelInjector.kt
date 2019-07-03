package bry1337.github.io.cartalog.injection.component

import bry1337.github.io.cartalog.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by edwardbryan.abergas on 07/02/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}