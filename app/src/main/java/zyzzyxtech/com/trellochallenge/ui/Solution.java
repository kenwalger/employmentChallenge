package zyzzyxtech.com.trellochallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zyzzyxtech.com.trellochallenge.Challenge;
import zyzzyxtech.com.trellochallenge.R;


public class Solution extends ActionBarActivity {
    
    /* TODO: Add Error handling for string conversion */

    public static final String TAG = Solution.class.getSimpleName();
    
    private String mDeHashed;
    private String mHashedString;
    private long mHashedLong;
    
    @InjectView(R.id.hash_answer) TextView mHashAnswer;
    @InjectView(R.id.contact_button) Button mContactButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        ButterKnife.inject(this);

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

    }

}
