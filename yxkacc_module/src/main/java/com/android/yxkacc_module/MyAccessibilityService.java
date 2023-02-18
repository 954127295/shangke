package com.android.yxkacc_module;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MyAccessibilityService extends AccessibilityService {
    private Thread thread;

    private Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                Toast.makeText(MyAccessibilityService.this,"任务结束", Toast.LENGTH_SHORT).show();
                stopAcc();
            }else if(msg.what == 2){
                Toast.makeText(MyAccessibilityService.this,"等待回到主页面", Toast.LENGTH_SHORT).show();
            }else if(msg.what == 3){
                Toast.makeText(MyAccessibilityService.this,"已操作"+Share.addcount+"条", Toast.LENGTH_SHORT).show();
            }else if(msg.what == 4){
                Toast.makeText(MyAccessibilityService.this,"请进入群聊天页面", Toast.LENGTH_SHORT).show();
            }else if(msg.what == 5){
                Toast.makeText(MyAccessibilityService.this,"请读取好友请求然后返回此页", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo info = event.getSource();
        getAccTexti("aa",info);
//        Log.e("eieieiieieiei：", String.valueOf(info));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getAccTexti(String text, AccessibilityNodeInfo node){
        try{
            for(int i = 0;i < node.getChildCount();i++){
                AccessibilityNodeInfo nodeInfo = node.getChild(i);
                String nodeText = "";
                try{
                    nodeText = nodeInfo.getText().toString();
                } catch (Exception e){
//                    e.printStackTrace();
                }
                Log.e("pppppppppppppppp：", String.valueOf(nodeText));
                if(text.equals(nodeText)){
                    Share.checkText = true;
                    Share.AccTextList.add(nodeInfo);
                }else{
                    getAccTexti(text,nodeInfo);
                }
            }
        } catch (Exception e){
//            e.printStackTrace();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onServiceConnected(){
        super.onServiceConnected();
        showFloatingWindow();
    }

    //根据自动加人输入栏开始
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void infoSendInformation(int sendbiaoqiannum,int sendusernum,String sendType,String ibeizhu,int isfirst) {
        if(!Share.isCancelled){
            while(true){
                if(!hasText("通讯录")){
                    mysleep(1);
                }else{
                    break;
                }
            }
            List<AccessibilityNodeInfo> AccTextList = getTextList("通讯录");
            clickTo(AccTextList.get(0),1);

            while(true){
                if(hasText("新的朋友") && hasText("仅聊天的朋友") && hasText("标签")){
                    break;
                }else{
                    if(hasText("朋友推荐")){
                        Message message = new Message();
                        message.what = 5;
                        mHandler.sendMessage(message);
                    }
                    mysleep(1);
                }
            }

            List<AccessibilityWindowInfo> AccsTextList = getWindows();


//
//            AccessibilityNodeInfo root = getRootInActiveWindow();
//            Log.e("sssssssssssssss###", String.valueOf(root));
//            if(!Share.isCancelled){
//                List<AccessibilityNodeInfo> AccsTextList = getTextList("标签");
//                clickTo(AccsTextList.get(0),1);
//                while(true){
//                    if(hasText("通讯录标签") && hasText("新建") && hasText("管理")){
//                        break;
//                    }else{
//                        mysleep(1);
//                    }
//                }
//                if(sendType.equals("1")){
//                    List<AccessibilityNodeInfo> AccBiaoqians = getIdList("com.tencent.mm:id/fgx");
//                    int listlcount = AccBiaoqians.toArray().length;
//
//
//                    if(!Share.isCancelled){
//                        AccessibilityNodeInfo needinfo = AccBiaoqians.get(sendbiaoqiannum);
//                        String biaoqianName = needinfo.getText().toString();
//                        clickTo(needinfo,1);
//                        while(true){
//                            if(hasText("标签名字") && hasText("编辑标签")){
//                                break;
//                            }else{
//                                mysleep(1);
//                            }
//                        }
//                        if(sendusernum > 0 && isfirst == 1){
////                            for(int sn=0;sn<sendusernum;sn++){
//                            int sn = 0;
//                            int sni = 0;
//                            while (sn < sendusernum) {
//                                List<AccessibilityNodeInfo> AccUsers = getIdList("com.tencent.mm:id/iw8");
//                                int userscount = AccUsers.toArray().length;
//                                List<AccessibilityNodeInfo> AccUsersName = getIdList("com.tencent.mm:id/iw8");
//                                AccessibilityNodeInfo userNameInfo = AccUsersName.get(sni);
//                                String sendUserName = userNameInfo.getText().toString();
//                                String checkUserName = biaoqianName + '-' + sendUserName;//需要检测的用户：标签名+用户名
//                                String clastUser = "";
//                                if (sni == 0) {
//                                    clastUser = "";
//                                } else {
//                                    AccessibilityNodeInfo nodeInfoLast = AccUsersName.get(sni - 1);
//                                    clastUser = String.valueOf(nodeInfoLast.getText());
//                                }
//                                String clastUserName = biaoqianName + '-' + clastUser;//上一个需要检测的用户：标签名+用户名
//
//                                String cuser = checkSendUser(Share.token, checkUserName, clastUserName);
//                                HashMap amap = JSON.parseObject(cuser, HashMap.class);
//                                String resultCode = (String) amap.get("code");
//                                sni++;
//                                if ("0".equals(resultCode)) {
//                                    sn++;
//                                }
//                                if (sn >= userscount) {
//                                    sni = 0;
//                                    int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
//                                    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
//                                    swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, 300, 1200);
//                                    mysleep(2);
//                                }
//                            }
//
////                            }
//                        }
//                        infoSendUserInformation(0,sendusernum,sendType,ibeizhu,biaoqianName);
//                    }
//                }else if(sendType.equals("2")){
//                    //
//                    Log.e("当前状态：", "部分好友");
//                }else{
//                    Log.e("当前状态：", "屏蔽部分好友");
//                }
//            }
        }
    }

    //apis停止任务
    private void stopAcc(){
        Share.qidong = "F";
        Share.isCancelled = true;
        Share.btn.setBackgroundResource(R.drawable.start);
        thread.interrupt();
    }

    //apis根据class判断元素是否存在
    @RequiresApi(api = Build.VERSION_CODES.N)
    private Boolean hasClass(String cls){
        Share.checkClass = false;
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccClass(cls,root);
        return Share.checkClass;
    }

    //apis根据text判断元素是否存在
    @RequiresApi(api = Build.VERSION_CODES.N)
    private Boolean hasText(String text){
        Share.checkText = false;
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccText(text,root);
        return Share.checkText;
    }

    //apis根据text判断元素是否存在
    @RequiresApi(api = Build.VERSION_CODES.N)
    private Boolean hasId(String Id){
        Share.checkId = false;
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccId(Id,root);
        return Share.checkId;
    }

    //apis根据des判断元素是否存在
    @RequiresApi(api = Build.VERSION_CODES.N)
    private Boolean hasDes(String des){
        Share.checkDes = false;
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccDes(des,root);
        return Share.checkDes;
    }

    //apis根据Id获取列表
    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<AccessibilityNodeInfo> getIdList(String ids){
        Share.AccIdList = new ArrayList<AccessibilityNodeInfo>();
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccId(ids,root);
        return Share.AccIdList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getAccId(String ids, AccessibilityNodeInfo node){
        try{
            for(int i = 0;i < node.getChildCount();i++){
                AccessibilityNodeInfo nodeInfo = node.getChild(i);
                String nodeIds = "";
                try{
                    nodeIds = nodeInfo.getViewIdResourceName().toString();
                } catch (Exception e){
//                    e.printStackTrace();
                }
                if(ids.equals(nodeIds)){
                    Share.checkId = true;
                    Share.AccIdList.add(nodeInfo);
                }else{
                    getAccId(ids,nodeInfo);
                }
            }
        } catch (Exception e){
//            e.printStackTrace();
        }
    }

    //apis根据描述获取列表
    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<AccessibilityNodeInfo> getDesList(String des){
        Share.AccDesList = new ArrayList<AccessibilityNodeInfo>();
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccDes(des,root);
        return Share.AccDesList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getAccDes(String des, AccessibilityNodeInfo node){
        try{
            for(int i = 0;i < node.getChildCount();i++){
                AccessibilityNodeInfo nodeInfo = node.getChild(i);
                String nodeDes = "";
                try{
                    nodeDes = nodeInfo.getContentDescription().toString();
                } catch (Exception e){
//                    e.printStackTrace();
                }
                if(des.equals(nodeDes)){
                    Share.checkDes = true;
                    Share.AccDesList.add(nodeInfo);
                }else{
                    getAccDes(des,nodeInfo);
                }
            }
        } catch (Exception e){
//            e.printStackTrace();
        }
    }

    //apis根据class样式获取列表
    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<AccessibilityNodeInfo> getClassList(String cls){
        Share.AccClsList = new ArrayList<AccessibilityNodeInfo>();
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccClass(cls,root);
        return Share.AccClsList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getAccClass(String cls, AccessibilityNodeInfo node){
        try{
            for(int i = 0;i < node.getChildCount();i++){
                AccessibilityNodeInfo nodeInfo = node.getChild(i);
                String nodeCls = "";
                try{
                    nodeCls = nodeInfo.getClassName().toString();
                } catch (Exception e){
//                    e.printStackTrace();
                }
                if(cls.equals(nodeCls)){
                    Share.checkClass = true;
                    Share.AccClsList.add(nodeInfo);
                }else{
                    getAccClass(cls,nodeInfo);
                }
            }
        } catch (Exception e){
//            e.printStackTrace();
        }
    }

    //apis根据Text内容获取列表
    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<AccessibilityNodeInfo> getTextList(String text){
        Share.AccTextList = new ArrayList<AccessibilityNodeInfo>();
        AccessibilityNodeInfo root = getRootInActiveWindow();
        getAccText(text,root);
        return Share.AccTextList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getAccText(String text, AccessibilityNodeInfo node){
        try{
            for(int i = 0;i < node.getChildCount();i++){
                AccessibilityNodeInfo nodeInfo = node.getChild(i);
                String nodeText = "";
                try{
                    nodeText = nodeInfo.getText().toString();
                } catch (Exception e){
//                    e.printStackTrace();
                }
                if(text.equals(nodeText)){
                    Share.checkText = true;
                    Share.AccTextList.add(nodeInfo);
                }else{
                    getAccText(text,nodeInfo);
                }
            }
        } catch (Exception e){
//            e.printStackTrace();
        }
    }

    //apis根据元素输入内容
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void sayInput(AccessibilityNodeInfo inputInfo,String content,int s){
        Bundle arguments = new Bundle();
        arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, content);
        inputInfo.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
        mysleep(s);
    }

    //apis根据元素点击内容
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void clickTo(AccessibilityNodeInfo inputInfo,int s){
        Rect rect = new Rect();
        inputInfo.getBoundsInScreen(rect);
        int x=(rect.left+rect.right)/2;
        int y = (rect.top + rect.bottom) / 2;
        clickPoint(x,y,300);
        mysleep(s);
    }

    //apis点击事件
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void clickPoint(float x1,float y1,long duration){ Path path=new Path();
        path.moveTo(x1,y1);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        GestureDescription gestureDescription = builder.addStroke(new GestureDescription.StrokeDescription(path,0,duration)).build();
        boolean b = dispatchGesture(gestureDescription,new GestureResultCallback() {
            @Override
            public void onCompleted(GestureDescription gestureDescription) {
                super.onCompleted(gestureDescription);
                Log.e("TIAOSHI###","点击结束 ..."+gestureDescription.getStrokeCount()); }
            @Override
            public void onCancelled(GestureDescription gestureDescription) {
                super.onCancelled(gestureDescription);
                Log.e("TIAOSHI###","点击取消");
            }
        },null);
    }

    //apis返回上一页
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void back(){
        performGlobalAction(GLOBAL_ACTION_BACK);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void swipe(float x1,float y1,float x2,float y2,long duration){
        Path path=new Path();
        path.moveTo(x1,y1);
        path.lineTo(x2,y2);
        Log.e("TIAOSHI###","MyAccessibilityService 中滑动 swipe()方 法滑动点,reset：（"+x1+","+y1+"),("+x2+","+y2+")"+"滑动的时长是 :"+duration);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        GestureDescription gestureDescription = builder.addStroke(new GestureDescription.StrokeDescription(path,0,duration)).build();
        boolean b = dispatchGesture(gestureDescription,new GestureResultCallback() {
            @Override public void onCompleted(GestureDescription gestureDescription) {
                super.onCompleted(gestureDescription);
                Log.e("TIAOSHI###","滑动结束 ..."+gestureDescription.getStrokeCount()); }
            @Override public void onCancelled(GestureDescription gestureDescription) {
                super.onCancelled(gestureDescription);
                Log.e("TIAOSHI###","滑动取消");
            }
        },null);
    }



    public void mysleep(int m){
        try{
            Thread.sleep(m*1000);
        }catch(InterruptedException e){
//            e.printStackTrace();
        }
    }

    @Override
    public void onInterrupt() {
        Log.e("TIAOSHI###","bbbbbb");
    }

    @Override
    public void onDestroy() {
        Log.e("TIAOSHI###","线程销毁了");
        super.onDestroy();
    }

    public void startApplication(Context ctx, String pkName){
        PackageManager packageManager = ctx.getPackageManager();
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pkName);
        List<ResolveInfo> apps = packageManager.queryIntentActivities(resolveIntent, 0);
        ResolveInfo ri = apps.iterator().next();
        if (ri != null ) {
            String packageName = ri.activityInfo.packageName;
            String className = ri.activityInfo.name;
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName cn = new ComponentName(packageName, className);
            intent.setComponent(cn);
            ctx.startActivity(intent);
        }
    }

    //apis悬浮窗
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showFloatingWindow() {
        Share.btn = new Button(this);
        //Share.btn.setText("开始");
        Share.btn.getBackground().setAlpha(0);
        Share.btn.setBackgroundResource(R.drawable.start);
        // 获取WindowManager
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        // 创建布局参数
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        /** 设置参数 */
        params.type = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ?
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY :
                WindowManager.LayoutParams.TYPE_PHONE;
        params.format = PixelFormat.RGBA_8888;
        // 设置窗⼝的⾏为准则
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        //设置透明度
        params.alpha = 1.0f;
        //设置内部视图对齐⽅式，这边位置为左边靠上
        params.gravity = Gravity.LEFT | Gravity.CENTER;
        //窗⼝的左上⾓坐标
        params.x = 0;
        params.y = 0;
        //设置窗⼝的宽⾼,这⾥为⾃动
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = 86;
        params.height = 86;
        // 添加进WindowManager
        wm.addView(Share.btn, params);
        Share.btn.setOnTouchListener(new View.OnTouchListener() {
            private WindowManager.LayoutParams updatedParameters = params;
            int x,y;
            float touchedX,touchedY;
            @SuppressLint("ClickableViewAccessibility")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x = updatedParameters.x;
                        y = updatedParameters.y;
                        touchedX = event.getRawX();
                        touchedY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (event.getRawX() - touchedX > 5 || event.getRawY() - touchedY > 5) {
                            updatedParameters.x = (int) (x + (event.getRawX() - touchedX));
                            updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
                            wm.updateViewLayout(Share.btn,updatedParameters);
                        }
                        break;
                    case MotionEvent.ACTION_UP: // 相差不到5则代表点击
                        if (event.getRawX() - touchedX < 5 && event.getRawY() - touchedY < 5) {
                            if("F".equals(Share.qidong)){
                                switch(Share.cid){
                                    case 22:
//                                        这里是附近加人
//                                        xxxxx();
//                                        break;
                                    case 7:
//                                        这里是消息群发
//                                        xxxxx();
                                        break;
//                                    .....//往下依次类推
                                }
                            }else{
                                stopAcc();
                            }
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
