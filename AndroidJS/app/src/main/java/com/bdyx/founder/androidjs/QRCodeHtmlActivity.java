package com.bdyx.founder.androidjs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class QRCodeHtmlActivity extends Activity {
    /**
     * 网页
     */
    private WebView wvQRCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_qrcode);
        initView();
        setWebView();
    }

    private void initView() {
        wvQRCode = (WebView) findViewById(R.id.wv_qrcode);
    }

    /**
     * 设置网页
     */
    private void setWebView(){
        //允许JavaScript执行
        wvQRCode.getSettings().setJavaScriptEnabled(true);
        //向js传递对象
        wvQRCode.addJavascriptInterface(new ShowCamera(),"camera");
        //不会node的小伙伴可以保存到assets
        //wvQRCode.loadUrl("file:///android_asset/QRCode.html");
        //访问网页
        wvQRCode.loadUrl("http://192.168.253.1:3000/htmls/QRCode.html");
    }
    public final class ShowCamera {
        //Html调用此方法传递数据，注解一定要留着否则会出错
        @JavascriptInterface
        public void showCamera() {
            Intent intent = new Intent(QRCodeHtmlActivity.this, QRCodeSurfaceActivity.class);
            //调用打开相机的界面
            QRCodeHtmlActivity.this.startActivity(intent);
        }
    }
}
