package zyzzyxtech.com.employmentchallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zyzzyxtech.com.employmentchallenge.Challenge;
import zyzzyxtech.com.employmentchallenge.R;


public class Solution extends ActionBarActivity {
    
    /* TODO: Add Error handling for string conversion */

    public static final String TAG = Solution.class.getSimpleName();
    
    private String mDeHashed;
    private String mHashedString;
    private long mHashedLong;
    
    @InjectView(R.id.hash_answer) TextView mHashAnswer;
    @InjectView(R.id.contact_button) Button mContactButton;
    @InjectView(R.id.background_android) ImageView mBackgroundAndroid;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        ButterKnife.inject(this);
        
        Log.i(TAG, getString(R.string.creative_commons_attribution));
        
        Intent intent = getIntent();
        mHashedString = intent.getStringExtra("hashedString");
        if ( mHashedString.isEmpty()) {
            mHashedLong = 491602768L;
        } else {
            try {
                mHashedLong = Long.valueOf(mHashedString, 10);
            } catch(InputMismatchException e) {
                Toast.makeText(Solution.this, "Error converting string", Toast.LENGTH_LONG).show();
                mHashedLong = 491602768L;
            } catch(NumberFormatException e) {
                Toast.makeText(Solution.this, "Invalid 'Long' number", Toast.LENGTH_LONG).show();
                mHashedLong = 491602768L;
            }
            
        }

        String deHashed = "";

        deHashed = Challenge.deHash(mHashedLong, deHashed);
        mDeHashed = deHashed;

        Log.i(TAG, "Dehashed value: " + mDeHashed);
        
        mHashAnswer = (TextView)findViewById(R.id.hash_answer);
        mHashAnswer.setText(mDeHashed);
        
        mContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solution.this, ContactActivity.class);
                startActivity(intent);
            }
        });
        
        mBackgroundAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Solution.this, getString(R.string.creative_commons_attribution), Toast.LENGTH_LONG).show();
            }

        });

    }

}
