package com.example.coinpaprika.di.component

import androidx.lifecycle.SavedStateHandle
import com.example.coinpaprika.di.NetworkModule
import com.example.coinpaprika.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

//    @Component.Factory
//    interface Factory {
//        fun create(handle: SavedStateHandle): ApplicationComponent
//    }
}