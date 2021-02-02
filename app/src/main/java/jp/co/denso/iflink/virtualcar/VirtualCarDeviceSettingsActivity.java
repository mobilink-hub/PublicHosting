package jp.co.denso.iflink.virtualcar;


import android.content.Intent;

import androidx.annotation.NonNull;

import jp.co.toshiba.iflink.ui.BaseSettingsActivity;

public class VirtualCarDeviceSettingsActivity extends BaseSettingsActivity {
    /**
     * Preferences名.
     */
    public static final String PREFERENCE_NAME
            = "jp.co.denso.iflink.virtualcar";

    @Override
    protected final int getPreferencesResId() {
        return R.xml.pref_virtualcardevice;
    }

    @NonNull
    @Override
    protected final String getPreferencesName() {
        return PREFERENCE_NAME;
    }

    @Override
    protected final Intent getIntentForService() {
        Intent intent = new Intent(
                getApplicationContext(),
                VirtualCarIms.class);
        intent.setPackage(getClass().getPackage().getName());
        return intent;
    }
}
