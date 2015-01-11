package zyzzyxtech.com.trellochallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        mGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hashedString = mHashedString.getText().toString();
                startSolution(hashedString);
            }
        });
    }

    private void startSolution(String hashedString) {
        Intent intent = new Intent(this, Solution.class);
        intent.putExtra("hashedString", hashedString);
        startActivity(intent);
    }
}
