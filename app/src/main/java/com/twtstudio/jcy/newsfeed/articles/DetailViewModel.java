package com.twtstudio.jcy.newsfeed.articles;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.twtstudio.jcy.newsfeed.BR;
import com.twtstudio.jcy.newsfeed.R;
import com.twtstudio.jcy.newsfeed.api.ApiClient;
import com.twtstudio.jcy.newsfeed.model.Articles;

import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.Notification;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class DetailViewModel implements ViewModel{

    private SourceDetailActivity mActivity;

    private Articles mArticles;

    private String source;

    public final ObservableList<DetailItemViewModel> itemViewModel = new ObservableArrayList<>();
    public final ItemViewSelector<DetailItemViewModel> itemView = new BaseItemViewSelector<DetailItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, DetailItemViewModel item) {
            itemView.set(BR.viewmodel, R.layout.item_news_detail);
        }
    };

    public final ViewStyle viewStyle = new ViewStyle();

    public static class ViewStyle {
        public final ObservableBoolean isRefreshing = new ObservableBoolean(true);
        public final ObservableBoolean progressRefreshing = new ObservableBoolean(true);
    }

    public final ReplyCommand onRefreshCommand = new ReplyCommand(this::loadDetailList);

    public DetailViewModel(SourceDetailActivity activity, String source) {
        mActivity = activity;
        this.source = source;
        loadDetailList();
    }

    public void loadDetailList(){
        viewStyle.isRefreshing.set(true);

        Observable<Notification<Articles>> newsDetails = ApiClient.getService()
                .getArticles(source)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mActivity.bindToLifecycle())
                .materialize()
                .share();

        newsDetails.filter(Notification::isOnNext)
                .map(articlesNotification -> articlesNotification.getValue())
                .filter(articles -> !articles.articles.isEmpty())
                .doOnNext(articles -> mArticles = articles )
                .doAfterTerminate(() -> viewStyle.isRefreshing.set(false))
                .flatMap(articles -> Observable.from(articles.articles))
                .subscribe(articlesBean -> itemViewModel.add(new DetailItemViewModel(mActivity,articlesBean)));
    }
}
