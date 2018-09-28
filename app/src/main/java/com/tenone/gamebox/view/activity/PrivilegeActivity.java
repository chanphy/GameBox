/**
 * Project Name:GameBox
 * File Name:PrivilegeActivity.java
 * Package Name:com.tenone.gamebox.view.activity
 * Date:2017-4-13����3:26:22
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 */

package com.tenone.gamebox.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tenone.gamebox.R;
import com.tenone.gamebox.mode.mode.HttpType;
import com.tenone.gamebox.mode.view.PrivilegeView;
import com.tenone.gamebox.presenter.PrivilegePresenter;
import com.tenone.gamebox.view.base.BaseActivity;
import com.tenone.gamebox.view.custom.MyRefreshListView;
import com.tenone.gamebox.view.custom.RefreshLayout;
import com.tenone.gamebox.view.custom.TitleBarView;

/**
 * � ClassName:PrivilegeActivity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017-4-13 ����3:26:22 <br/>
 *
 * @author John Lie
 * @see
 * @since JDK 1.6
 */
public class PrivilegeActivity extends BaseActivity implements PrivilegeView {
    @ViewInject(R.id.id_title_bar)
    TitleBarView titleBarView;
    @ViewInject(R.id.id_privlege_listview)
    MyRefreshListView listView;
    @ViewInject(R.id.id_privlege_refresh)
    RefreshLayout refreshLayout;

    private PrivilegePresenter presenter;
    private int platform = 1;

    @Override
    protected void onCreate(@Nullable Bundle arg0) {
        super.onCreate( arg0 );
        setContentView( R.layout.activity_privilege );
        ViewUtils.inject( this );
        Intent intent = getIntent();
        if (intent.hasExtra( "platform" )) {
            platform = intent.getIntExtra( "platform", 1 );
        }
        presenter = new PrivilegePresenter( this, this, platform );
        presenter.initView();
        presenter.setAdapter();
        presenter.initListener();
        presenter.requestHttp( HttpType.REFRESH );
    }

    @Override
    public TitleBarView getTitleBarView() {
        return titleBarView;
    }

    @Override
    public MyRefreshListView getListView() {
        return listView;
    }

    @Override
    public RefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

}