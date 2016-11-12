package com.twtstudio.jcy.newsfeed.api;

import com.twtstudio.jcy.newsfeed.model.Articles;
import com.twtstudio.jcy.newsfeed.model.Sources;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jcy on 16-11-4.
 *
 * @TwtStudio Mobile Develop Team
 */

public interface NewsApi {
    @GET("articles")
    Observable<Articles> getArticles(@Query("source") String source);

    @GET("sources")
    Observable<Sources> getSources(@Query("language") String language);

}
