package com.twtstudio.jcy.newsfeed.articles;

import android.content.Context;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.twtstudio.jcy.newsfeed.model.Articles;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class DetailItemViewModel implements ViewModel{

    private Context mContext;

    public Articles.ArticlesBean mArticlesBean;

    public final ObservableField<String> author = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();
    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();

    public ReplyCommand itemClickCommand = new ReplyCommand(()->{

    });

    public DetailItemViewModel(Context context, Articles.ArticlesBean articlesBean) {
        mContext = context;
        mArticlesBean = articlesBean;
        author.set(articlesBean.author);
        title.set(articlesBean.title);
        description.set(articlesBean.description);
        imageUrl.set(articlesBean.urlToImage);
        url.set(articlesBean.url);
        time.set(articlesBean.publishedAt);
    }
}
