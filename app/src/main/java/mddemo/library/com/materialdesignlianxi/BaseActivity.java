package mddemo.library.com.materialdesignlianxi;


import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;



/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月3日14:34:21
 * Description:关于转场动画的一次简单的练习
 */
public abstract class BaseActivity extends ActionBarActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutrresource());
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    //获取布局文件
    protected abstract int getLayoutrresource();
    //设置toolbar
    protected void setActionBarIcon(int iconRes) {
        toolbar.setNavigationIcon(iconRes);
    }
}
