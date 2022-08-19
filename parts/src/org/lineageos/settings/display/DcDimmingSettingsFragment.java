/*
 * Copyright (C) 2018 The LineageOS Project
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

package org.lineageos.settings.display;

import android.os.Bundle;
import android.content.Context;
import androidx.preference.Preference;
import android.content.SharedPreferences;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;
import android.provider.Settings;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

import vendor.xiaomi.hardware.displayfeature.V1_0.IDisplayFeature;

public class DcDimmingSettingsFragment extends PreferenceFragment implements
        OnPreferenceChangeListener {

    private static final String DCDIMMING_ENABLE_KEY = "dcdimming_enable";
    public static final String SHAREDDCDIMMING = "sharadeDCDimming";

    private SwitchPreference mDCDimmingPreference;
    private IDisplayFeature mDisplayFeature;


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
      addPreferencesFromResource(R.xml.dcdimming_settings);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
       try {
            mDisplayFeature = IDisplayFeature.getService();
        } catch (Exception e) {
            // Do nothing
        }
        mDCDimmingPreference = (SwitchPreference) findPreference(DCDIMMING_ENABLE_KEY);
        mDCDimmingPreference.setEnabled(true);
        mDCDimmingPreference.setOnPreferenceChangeListener(this);
        enableDCDimming(1);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (DCDIMMING_ENABLE_KEY.equals(preference.getKey())) {
            enableDCDimming((Boolean) newValue ? 1 : 0);
        }
        return true;
    }

    private void enableDCDimming(int enable) {
        if (mDisplayFeature == null) return;
        try {
            mDisplayFeature.setFeature(0,20,enable,255);
            SharedPreferences preferences = getActivity().getSharedPreferences(SHAREDDCDIMMING,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(SHAREDDCDIMMING, enable);
            editor.commit();
            }catch (Exception e) {
            // Do nothing
        }
    }
}