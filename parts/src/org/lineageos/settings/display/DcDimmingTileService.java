/*
* Copyright (C) 2018 The OmniROM Project
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
*/
package org.lineageos.settings.display;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import androidx.preference.PreferenceManager;

import org.lineageos.settings.utils.FileUtils;

public class DcDimmingTileService extends TileService {

    private static final String DC_DIMMING_ENABLE_KEY = "dc_dimming_enable";
    private static final String DC_DIMMING_NODE = "/sys/class/mi_display/disp-DSI-0/disp_param";

    private void updateUI(boolean enabled) {
        final Tile tile = getQsTile();
        tile.setState(enabled ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        tile.updateTile();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        updateUI(sharedPrefs.getBoolean(DC_DIMMING_ENABLE_KEY, false));
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
    }

    @Override
    public void onClick() {
        super.onClick();
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        final boolean enabled = !(sharedPrefs.getBoolean(DC_DIMMING_ENABLE_KEY, false));
        FileUtils.rewriteFile(DC_DIMMING_NODE, enabled ? "feature name[feature id]: feature value\n" +
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
                        "                             Unknown[20]: 0" : "feature name[feature id]: feature value\n" +
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
                        "                             Unknown[20]: 0");
        sharedPrefs.edit().putBoolean(DC_DIMMING_ENABLE_KEY, enabled).commit();
        updateUI(enabled);
    }
}
