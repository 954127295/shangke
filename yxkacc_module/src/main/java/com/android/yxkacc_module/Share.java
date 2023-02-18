package com.android.yxkacc_module;

import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Share {
    public static String qidong = "F";
    public static String token = "";
    public static int cid = 0;
    public static String userInfo = "";
    public static String taskInfo = "";
    public static String userPhone = "";
    public static Boolean isCancelled = true;
    public static Button btn = null;
    public static Boolean checkClass = false;
    public static Boolean checkText = false;
    public static Boolean checkId = false;
    public static Boolean checkDes = false;
    public static int addcount = 0;
    public static int startcount = 0;
    public static List<AccessibilityNodeInfo> AccClsList = new ArrayList<AccessibilityNodeInfo>();
    public static List<AccessibilityNodeInfo> AccTextList = new ArrayList<AccessibilityNodeInfo>();
    public static List<AccessibilityNodeInfo> AccIdList = new ArrayList<AccessibilityNodeInfo>();
    public static List<AccessibilityNodeInfo> AccDesList = new ArrayList<AccessibilityNodeInfo>();
}
