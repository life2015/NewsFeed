package com.twtstudio.jcy.newsfeed.sources;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;
import com.twtstudio.jcy.newsfeed.articles.SourceDetailActivity;
import com.twtstudio.jcy.newsfeed.model.Sources;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class NewItemViewModel implements ViewModel {
    //context
    private Context mContext;

    //model
    private Sources.SourcesBean mSourcesBeanourcesBean;

    //field to presenter
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();

    //command
    public ReplyCommand itemClickCommand = new ReplyCommand(()->{
        // TODO: 16-11-12 jump to detail
        Intent intent = new Intent(mContext, SourceDetailActivity.class);
        intent.putExtra(SourceDetailActivity.SOURCE_ID_KEY,mSourcesBeanourcesBean.id);
        mContext.startActivity(intent);
    });

    public NewItemViewModel(Context context, Sources.SourcesBean sourcesBeanourcesBean) {
        mContext = context;
        mSourcesBeanourcesBean = sourcesBeanourcesBean;
        name.set(sourcesBeanourcesBean.name);
        description.set(sourcesBeanourcesBean.description);
        imageUrl.set(sourcesBeanourcesBean.urlsToLogos.large);
    }
}
