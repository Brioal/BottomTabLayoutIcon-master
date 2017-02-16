package com.brioal.bottomtablayouticon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.brioal.bottomtab.BottomTabLayout;
import com.brioal.bottomtab.OnTabSelectedListener;
import com.brioal.bottomtab.TabEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<TabEntity> mList;
    private BottomTabLayout mLayout;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (BottomTabLayout) findViewById(R.id.main_bottomTab);
        mList = new ArrayList<>();
        mList.add(new TabEntity("按钮1", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mList.add(new TabEntity("按钮2", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mList.add(new TabEntity("按钮3", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mList.add(new TabEntity("按钮4", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mLayout.setTextColorNormal(Color.RED);
        mLayout.setTextColorSelected(Color.BLUE);
        mLayout.setList(mList);
        mLayout.setListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int position) {
                if (mToast == null) {
                    mToast = Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_LONG);
                } else {
                    mToast.setText(position + "");
                }
                mToast.show();
            }
        });
    }
}
