package dev.yelinaung.apptest.di.koin

import dev.yelinaung.apptest.viewmodel.MyVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val networkModule = module {

}

val repoModule = module {

}

val vmModule = module {
    viewModel { MyVM() }
}