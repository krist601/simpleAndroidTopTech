package com.example.simpleandroidtoptech.di.component

import com.example.simpleandroidtoptech.AppApplication
import com.example.simpleandroidtoptech.di.module.RepositoryModule
import com.example.simpleandroidtoptech.di.module.ViewModelsModule
import com.example.simpleandroidtoptech.viewModels.CharactersViewModel
import com.example.simpleandroidtoptech.views.characterList.CharactersFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ViewModelsModule::class
    ]
)
interface AppComponent {
    fun inject(application: AppApplication)
    fun inject(charactersFragment: CharactersFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}