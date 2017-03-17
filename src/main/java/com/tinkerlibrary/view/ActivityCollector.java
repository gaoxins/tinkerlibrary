package com.tinkerlibrary.view;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoxin on 2017/3/3.
 *  Activity回收类♻️
 *
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    /***
     * @deprecated 添加Activity
     * @param activity
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /***
     * @deprecated 删除Activity
     * @param activity
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /***
     * @deprecated 删除所有activity
     */
    public static void finishAll(){
        for (Activity activity : activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
