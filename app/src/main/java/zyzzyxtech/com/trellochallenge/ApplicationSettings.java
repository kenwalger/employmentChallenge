package zyzzyxtech.com.trellochallenge;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import zyzzyxtech.com.trellochallenge.utils.StorageType;

/**
 * Created by Ken on 1/13/2015.
 */
public class ApplicationSettings {
    
    SharedPreferences mSharedPreferences;
    
    public ApplicationSettings(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);        
    }
    
    public String getStoragePreference() {
        return mSharedPreferences.getString("Storage", StorageType.INTERNAL);        
    }
    
    public void setSharedPreferences(String storageType) {
        mSharedPreferences.edit().putString("Storage", storageType).apply();
    }
}
