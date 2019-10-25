package com.quyunshuo.androidcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
@Route(path = "/app/AppMainActivity")
public class AppMainActivity extends AppCompatActivity {

    TextView mARouterTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mARouterTv = findViewById(R.id.arouter_tv);
        mARouterTv.setOnClickListener(v -> {
            ARouter.getInstance()
                    .build("/main_module/MainActivity")
                    .navigation();
        });
    }
}
