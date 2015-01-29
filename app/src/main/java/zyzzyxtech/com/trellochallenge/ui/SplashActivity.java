package zyzzyxtech.com.trellochallenge.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import zyzzyxtech.com.trellochallenge.ConstantValues;
import zyzzyxtech.com.trellochallenge.R;


public class SplashActivity extends ActionBarActivity {
    
    private Handler mHandler;
    
    private Runnable myRunnable;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Just create simple XML layout with i.e. a single ImageView or a custom layout
        setContentView(R.layout.activity_splash);
        mHandler = new Handler();
        myRunnable = new Runnable() {
            @Override
        public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                
            }
        };
    }
    
    @Override
    public void onBackPressed() {
        // Remove callback on back press
        if (mHandler != null && myRunnable !=null) {
            mHandler.removeCallbacks(myRunnable);
        }
        super.onBackPressed();
    }
    
    @Override
    protected void onResume() {
        // Attach and start callback with delay on resume
        if (mHandler != null && myRunnable != null) {
            mHandler.postDelayed(myRunnable, ConstantValues.SPLASH_TIME_OUT);
        }
        super.onResume();
    }
}
