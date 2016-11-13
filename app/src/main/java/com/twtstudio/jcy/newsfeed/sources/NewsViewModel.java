package com.twtstudio.jcy.newsfeed.sources;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

import com.android.databinding.library.baseAdapters.BR;
import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.twtstudio.jcy.newsfeed.R;
import com.twtstudio.jcy.newsfeed.api.ApiClient;
import com.twtstudio.jcy.newsfeed.model.Sources;

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

public class NewsViewModel implements ViewModel {

    //context
    private ArticleActivity mActivity;

    //model
    private Sources mSources;

    private static final String TAG = "NewsViewModel";

    public final ObservableList<NewItemViewModel> itemViewModel = new ObservableArrayList<>();
    public final ItemViewSelector<NewItemViewModel> itemView = new BaseItemViewSelector<NewItemViewModel>() {
        @Override
        public void select(ItemView itemView, int position, NewItemViewModel item) {
            itemView.set(BR.viewmodel, R.layout.item_news);
        }
    };

    public final ViewStyle viewStyle = new ViewStyle();

    public static class ViewStyle {
        public final ObservableBoolean isRefreshing = new ObservableBoolean(true);
        public final ObservableBoolean progressRefreshing = new ObservableBoolean(true);
    }

    //command
    public final ReplyCommand onRefreshCommand = new ReplyCommand(this::loadSourceList);

    public NewsViewModel(ArticleActivity activity) {
        mActivity = activity;
        loadSourceList();
    }

    public void loadSourceList() {

        viewStyle.isRefreshing.set(true);


        Observable<Notification<Sources>> newsSources =
                ApiClient.getService().getSources("en")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(mActivity.bindToLifecycle())
                        .materialize().share();

        newsSources.filter(Notification::isOnNext)
                .map(sourcesNotification -> sourcesNotification.getValue())
                .filter(sources -> !sources.sources.isEmpty())
                .doOnNext(sources -> {
                    itemViewModel.clear();
                    mSources = sources;
                })
                .doAfterTerminate(() -> viewStyle.isRefreshing.set(false))
                .flatMap(sources -> Observable.from(sources.sources))
                .subscribe(sourcesBean -> itemViewModel.add(new NewItemViewModel(mActivity, sourcesBean)));

    }
}
