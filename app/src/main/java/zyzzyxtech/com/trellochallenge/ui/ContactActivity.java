package zyzzyxtech.com.trellochallenge.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import zyzzyxtech.com.trellochallenge.R;

public class ContactActivity extends ActionBarActivity {
    
    /* TODO: Add pdf resume and pdf launcher */

    public static final String TAG = Solution.class.getSimpleName();
    public static final String googleDocsURL = "https://docs.google.com/gview?embedded=true&url=";
    public static final String pdfResumeSite = "http://www.kenwalger.com/assets/resume.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button OpenPDF = (Button)findViewById(R.id.pdf_button);
        OpenPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Open browser and display online version.
                    // Online version resides at http://www.kenwalger.com/assets/resume.pdf, displayed via Google Docs
                    showSite(pdfResumeSite);
            }
        });
    }
    
    public void showSite (String url) {
        Uri displayUri = Uri.parse(googleDocsURL + url);
        Intent launchBrowserIntent = new Intent();
        launchBrowserIntent.setAction(Intent.ACTION_VIEW);
        launchBrowserIntent.setComponent(new ComponentName ("com.android.browser",
                  "com.android.browser.BrowserActivity"));
        launchBrowserIntent.setData(displayUri);
        launchBrowserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(launchBrowserIntent);
    }

}