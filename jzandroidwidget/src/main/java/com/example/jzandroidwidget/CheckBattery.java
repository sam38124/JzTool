package com.example.jzandroidwidget;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class CheckBattery {

    public static Boolean CheckIsCharage(Activity activity){
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatusIntent = activity.registerReceiver(null, ifilter);
//如果设备正在充电，可以提取当前的充电状态和充电方式（无论是通过 USB 还是交流充电器），如下所示：

// Are we charging / charged?
        int status = batteryStatusIntent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

// How are we charging?
        int chargePlug = batteryStatusIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        return acCharge||usbCharge;
    }
}
