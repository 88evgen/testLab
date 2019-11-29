package bes.tehno.testlab.model.di

import android.content.Context
import bes.tehno.testlab.model.data.RestService
import bes.tehno.testlab.model.repository.AppRepository
import bes.tehno.testlab.model.repository.AppRepositoryImpl
import bes.tehno.testlab.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: App): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository {
        return appRepositoryImpl
    }

    @Singleton
    @Provides
    fun provideRestService(): RestService = RestService()

}