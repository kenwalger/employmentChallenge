package zyzzyxtech.com.trellochallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andreabaccega.widget.FormEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zyzzyxtech.com.trellochallenge.R;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = Solution.class.getSimpleName();
    
    @InjectView(R.id.go_button) Button mGoButton;
    
    @InjectView(R.id.hash_string) EditText mHashedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        Log.i(TAG, "App Name: " + getString(R.string.app_name));
        Log.i(TAG, "App Author: " + getString(R.string.app_author));
        
        mGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check for validation : numeric
                FormEditText hashTest = (FormEditText)findViewById(R.id.hash_string);
                
                if (hashTest.testValidity()) {
                    // End for check for validation
                    String hashedString = mHashedString.getText().toString();
                    startSolution(hashedString);
                }
            }
        });
    }

    private void startSolution(String hashedString) {
        Intent intent = new Intent(this, Solution.class);
        intent.putExtra("hashedString", hashedString);
        startActivity(intent);
    }
}
