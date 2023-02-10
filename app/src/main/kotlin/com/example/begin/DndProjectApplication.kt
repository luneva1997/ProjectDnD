package com.example.begin

import android.app.Application
import androidx.room.Room
import com.example.begin.data.db.DndProjectDatabase
import com.example.begin.domain.usecases.CreateAdventureUseCase
import com.example.begin.domain.usecases.CreateAdventureUseCaseImpl
import com.example.begin.domain.usecases.GetAdventuresUseCase
import com.example.begin.domain.usecases.GetAdventuresUseCaseImpl
import com.example.begin.presentation.adventures.create.CreateAdventureViewModel
import com.example.begin.presentation.adventures.list.AdventuresListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DndProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                dataModule(),
                domainModule(),
                presentationModule(),
            )
        }
        prepareDatabase()
    }

    private fun prepareDatabase(): DndProjectDatabase {
        return Room.databaseBuilder(
            applicationContext,
            DndProjectDatabase::class.java,
            "dnd-project-db"
        ).build()
    }

    private fun dataModule() = module {
        val database = prepareDatabase()
        single { database.adventuresDao() }
    }

    private fun domainModule() = module {
        single<GetAdventuresUseCase> { GetAdventuresUseCaseImpl(get()) }
        single<CreateAdventureUseCase> { CreateAdventureUseCaseImpl(get()) }
    }

    private fun presentationModule() = module {
        viewModel { AdventuresListViewModel(get()) }
        viewModel { CreateAdventureViewModel(get()) }
    }
}