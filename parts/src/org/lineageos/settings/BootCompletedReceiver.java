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
import android.os.SystemProperties;
import android.util.Log;
import androidx.preference.PreferenceManager;
import org.lineageos.settings.dirac.DiracUtils;
import org.lineageos.settings.doze.DozeUtils;
import org.lineageos.settings.utils.FileUtils;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final boolean DEBUG = false;
    private static final String TAG = "XiaomiParts";
    private static final String DC_DIMMING_ENABLE_KEY = "dc_dimming_enable";
    private static final String DC_DIMMING_NODE = "/sys/class/mi_display/disp-DSI-0/disp_param";

    @Override
    public void onReceive(final Context context, Intent intent) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        if (DEBUG) Log.d(TAG, "Received boot completed intent");
        DozeUtils.checkDozeService(context);

        boolean dcDimmingEnabled = sharedPrefs.getBoolean(DC_DIMMING_ENABLE_KEY, false);
        String t = "feature name[feature id]: feature value\n" +
                        "                             dimming[00]: 0\n" +
                        "                                 hbm[01]: 0\n" +
                        "                             hbm_fod[02]: 0\n" +
                        "                     doze_brightness[03]: 0\n" +
                        "          fod_calibration_brightness[04]: 0\n" +
                        "                 fod_calibration_hbm[05]: 0\n" +
                        "                           flat_mode[06]: 0\n" +
                        "                                 crc[07]: 0\n" +
                        "                             dc_mode[08]: 1\n" +
                        "                           local_hbm[09]: 0\n" +
                        "                          sensor_lux[10]: 0\n" +
                        "                  low_brightness_fod[11]: 0\n" +
                        "                           fp_status[12]: 0\n" +
                        "                    nature_flat_mode[13]: 0\n" +
                        "                          spr_render[14]: 0\n" +
                        "                         brightnress[15]: 0\n" +
                        "                             lcd_hbm[16]: 0\n" +
                        "                                 gir[17]: 0\n" +
                        "                             Unknown[18]: 0\n" +
                        "                             Unknown[19]: 0\n" +
                        "                             Unknown[20]: 0";
        String f = "feature name[feature id]: feature value\n" +
                        "                             dimming[00]: 0\n" +
                        "                                 hbm[01]: 0\n" +
                        "                             hbm_fod[02]: 0\n" +
                        "                     doze_brightness[03]: 0\n" +
                        "          fod_calibration_brightness[04]: 0\n" +
                        "                 fod_calibration_hbm[05]: 0\n" +
                        "                           flat_mode[06]: 0\n" +
                        "                                 crc[07]: 0\n" +
                        "                             dc_mode[08]: 0\n" +
                        "                           local_hbm[09]: 0\n" +
                        "                          sensor_lux[10]: 0\n" +
                        "                  low_brightness_fod[11]: 0\n" +
                        "                           fp_status[12]: 0\n" +
                        "                    nature_flat_mode[13]: 0\n" +
                        "                          spr_render[14]: 0\n" +
                        "                         brightnress[15]: 0\n" +
                        "                             lcd_hbm[16]: 0\n" +
                        "                                 gir[17]: 0\n" +
                        "                             Unknown[18]: 0\n" +
                        "                             Unknown[19]: 0\n" +
                        "                             Unknown[20]: 0";
        FileUtils.rewriteFile(DC_DIMMING_NODE, dcDimmingEnabled ? t : f);
    }
}