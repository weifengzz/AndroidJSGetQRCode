package com.bdyx.founder.androidjs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /**
     * 本地使用相机调出二维码按钮
     */
    private Button btNativeQRcode = null;
    /**
     * 跳转web界面
     */
    private Button btJSQRcode = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dealView();
    }
    /**
     * 初始化视图
     */
    private void initView() {
        btNativeQRcode = (Button) findViewById(R.id.bt_native_qrcode);
        btJSQRcode = (Button) findViewById(R.id.bt_js_qrcode);
    }
    /**
     * 操作视图
     */
    private void dealView() {
        btJSQRcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QRCodeHtmlActivity.class);
                startActivity(intent);
            }
        });
        btNativeQRcode.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QRCodeSurfaceActivity.class);
                startActivity(intent);
            }
        });
    }

}
