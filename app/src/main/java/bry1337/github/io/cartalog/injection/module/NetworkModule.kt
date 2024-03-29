package bry1337.github.io.cartalog.injection.module

import bry1337.github.io.cartalog.BuildConfig
import bry1337.github.io.cartalog.network.CartalogApi
import bry1337.github.io.cartalog.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by edwardbryan.abergas on 07/02/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideCartalogApi(retrofit: Retrofit): CartalogApi {
        return retrofit.create(CartalogApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClientBuilder())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).build()
    }

    private fun getHttpClientBuilder(): OkHttpClient {
        val client = OkHttpClient().newBuilder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)
        }
        client.readTimeout(60, TimeUnit.SECONDS)
        client.connectTimeout(60, TimeUnit.SECONDS)
        return client.build()
    }
}