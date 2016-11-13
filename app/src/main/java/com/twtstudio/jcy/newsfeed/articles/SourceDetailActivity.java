package com.twtstudio.jcy.newsfeed.articles;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.twtstudio.jcy.newsfeed.R;
import com.twtstudio.jcy.newsfeed.databinding.ActivityDetailBinding;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class SourceDetailActivity extends RxAppCompatActivity{

    public static final String SOURCE_ID_KEY = "id";
    private String mSourceId;
    private ActivityDetailBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        mSourceId = getIntent().getStringExtra(SOURCE_ID_KEY);
        mBinding.swipeRefresh.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN,Color.MAGENTA);
        mBinding.setViewModel(new DetailViewModel(this,mSourceId));
        Toolbar toolbar = mBinding.toolbar;
        setSupportActionBar(toolbar);

    }
}
