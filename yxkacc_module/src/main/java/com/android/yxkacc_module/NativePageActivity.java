package com.android.yxkacc_module;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;


public class NativePageActivity extends Activity {
    private Context context;
    private Button b;
    public static final int CODE_WINDOW = 0;

    private Handler mHandler = new Handler(Looper.myLooper()){
        public void handleMessage(@NonNull Message msg){
            Log.e("TIAOSHI###","000000000000000000");
            super.handleMessage(msg);
            if(msg.what == 0){
                String strData = (String) msg.obj;
                Share.qidong = "F";
                Share.isCancelled = true;
                Share.btn.setBackgroundResource(R.drawable.start);
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();
//        b = (Button) findViewById(R.id.start);
//        b.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//      判断是否开启无障碍服务
        boolean isStart = isAccessibilityServiceOn();
        String token = Share.token;
        System.out.println(token);
        // 申请悬浮窗权限
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(NativePageActivity.this)) {
                startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), CODE_WINDOW);
            }else{
                if(!isStart){
                    startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
                }else{
                    Intent intent = new Intent(NativePageActivity.this, MyAccessibilityService.class);
                    startService(intent);
                }
            }
        }
        // 关闭当前activity,这样只显示悬浮窗
        finish();
//            }
//        });

//        FrameLayout rootView = new FrameLayout(this);
//        TextView textView = new TextView(this);
//        textView.setTextColor(Color.BLACK);
//        textView.setTextSize(30);
//        textView.setText("点击我将返回 并携带参数返回");

        // 申请悬浮窗权限
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (!Settings.canDrawOverlays(this)) {
//                Toast.makeText(this, "aaaaaaaaaa", Toast.LENGTH_SHORT).show();
//                startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), CODE_WINDOW);
//            }else{
//                Intent intent = new Intent(this, XfcService.class);
//                startService(intent);
//
//            }
//        }

//        if (!Settings.canDrawOverlays(this)) {
//            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), REQUEST_CODE);
//        } else {
//            QueueUpFloatService.launchService(this, modeBean);
//        }





//        rootView.addView(textView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("respond", "我是原生页面");
//                setResult(TestModule.REQUEST_CODE, intent);
//                finish();
//            }
//        });
//        setContentView(rootView);
    }

    // 权限申请成功后的回调
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            // 不给权限就退出
//            case Permission.CODE_WINDOW:
//                if (resultCode != Activity.RESULT_OK) System.exit(0);
//                break;
//            default:
//                Toast.makeText(this, "未知权限回调: " + requestCode, Toast.LENGTH_SHORT).show();
//        }
//    }

    public Boolean isAccessibilityServiceOn(){
        try{
            String service = "com.android.yxk/com.android.yxkacc_module.MyAccessibilityService";
            int enabled = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED);
            TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(':');
            if (enabled == 1) {
                String settingValue = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
                if (settingValue != null) {
                    System.out.println(settingValue);
                    splitter.setString(settingValue);
                    while (splitter.hasNext()) {
                        String accessibilityService = splitter.next();
                        if (accessibilityService.equals(service)) {
                            return true;
                        }
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return false;
    }
}
