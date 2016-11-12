package com.twtstudio.jcy.newsfeed.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jcy on 16-11-4.
 *
 * @TwtStudio Mobile Develop Team
 */

public class ApiClient {

    private Retrofit mRetrofit;

    private NewsApi mService;

    private static final String apiKey = "5a3f3eedf40e4ca5a57902091aa87066";

    public ApiClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(sInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = mRetrofit.create(NewsApi.class);

    }

    private static Interceptor sInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request originRequest = chain.request();

            HttpUrl url = originRequest.url()
                    .newBuilder()
                    .addQueryParameter("apikey",apiKey)
                    .build();

            Request request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build();

            return chain.proceed(request);
        }
    };

    private static class SingletonHolder{
        private static final ApiClient INSTANCE = new ApiClient();
    }

    public static ApiClient getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static NewsApi getService(){
        return SingletonHolder.INSTANCE.mService;
    }

    public Subscription getSouces(Subscriber subscriber){
        Subscription subscription = mService.getSources("en")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        return subscription;
    }

    public Subscription getArticles(String source,Subscriber subscriber){
        Subscription subscription = mService.getArticles(source,"top")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        return subscription;
    }
}
