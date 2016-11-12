package com.twtstudio.jcy.newsfeed.sources;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.twtstudio.jcy.newsfeed.R;
import com.twtstudio.jcy.newsfeed.databinding.ActivityArticleBinding;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class ArticleActivity extends RxAppCompatActivity {

    private ActivityArticleBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_article);
        mBinding.setViewmodel(new NewsViewModel(this));
        Toolbar toolbar = mBinding.toolbar;
        setSupportActionBar(toolbar);
        mBinding.swipeRefresh.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN,Color.MAGENTA);
    }
}
