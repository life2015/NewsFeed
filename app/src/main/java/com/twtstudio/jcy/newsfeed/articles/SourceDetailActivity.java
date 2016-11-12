package com.twtstudio.jcy.newsfeed.articles;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by jcy on 16-11-12.
 *
 * @TwtStudio Mobile Develop Team
 */

public class SourceDetailActivity extends RxAppCompatActivity{

    public static final String SOURCE_ID_KEY = "id";
    private String mSourceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSourceId = getIntent().getStringExtra(SOURCE_ID_KEY);
    }
}
