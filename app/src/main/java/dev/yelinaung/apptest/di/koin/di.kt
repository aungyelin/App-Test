package dev.yelinaung.apptest.di.koin

import dev.yelinaung.apptest.api.model.Api
import dev.yelinaung.apptest.viewmodel.MyVM
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

}

val networkModule = module {
    single(named("headerInterceptor")) { Api.getHeaderInterceptor() }
    single(named("loggingInterceptor")) { Api.getLoggingInterceptor() }
    single {
        Api.createOkHttpClient(
            get(named("headerInterceptor")),
            get(named("loggingInterceptor"))
        )
    }
    single { Api.createApiService(get()) }
}

val repoModule = module {

}

val vmModule = module {
    viewModel { MyVM(get()) }
}