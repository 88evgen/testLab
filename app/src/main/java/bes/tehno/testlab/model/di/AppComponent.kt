package bes.tehno.testlab.model.di

import bes.tehno.testlab.ui.App
import bes.tehno.testlab.ui.fragment.cats.CatsViewModel
import bes.tehno.testlab.ui.fragment.dogs.DogsViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)

    fun runInject(viewModel: CatsViewModel)
    fun runInject(viewModel: DogsViewModel)

}