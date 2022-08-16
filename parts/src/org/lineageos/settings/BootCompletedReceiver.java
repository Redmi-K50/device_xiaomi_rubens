/*
 * Copyright (C) 2015 The CyanogenMod Project
 *               2017-2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.lineageos.settings.dirac.DiracUtils;
import org.lineageos.settings.chec.DozeUtils;

import vendor.xiaomi.hardware.touchfeature.V1_0.ITouchFeature;
import vendor.xiaomi.hardware.displayfeature.V1_0.IDisplayFeature;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final boolean DEBUG = false;
    private static final String TAG = "XiaomiParts";

    public static final String SHAREDD2TW = "sharadeD2TW";
    private ITouchFeature mTouchFeature;
    private IDisplayFeature mDisplayFeature;

    @Override
    public void onReceive(final Context context, Intent intent) {

        //Micro-Service to restore sata of dt2w/dcdimming on reboot
        SharedPreferences prefsDT2W = context.getSharedPreferences(SHAREDD2TW, Context.MODE_PRIVATE);
        SharedPreferences prefsDCDIMMING = context.getSharedPreferences(SHAREDDCDIMMING, Context.MODE_PRIVATE);

        try {

            //dt2w
            mTouchFeature = ITouchFeature.getService();
            mTouchFeature.setTouchMode(14,prefsDT2W.getInt(SHAREDD2TW, 1));
            
            //dcdimming
            mDisplayFeature = IDisplayFeature.getService();
            mTouchFeature.setFeature(0,20,prefsDT2W.getInt(SHAREDDCDIMMING, 1),255);
        } catch (Exception e) {
            // Do nothing
        }

        if (DEBUG) Log.d(TAG, "Received boot completed intent");
        DozeUtils.checkDozeService(context);
        DiracUtils.initialize(context);

    }
}