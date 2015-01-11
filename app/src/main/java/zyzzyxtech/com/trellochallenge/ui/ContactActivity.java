package zyzzyxtech.com.trellochallenge.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import zyzzyxtech.com.trellochallenge.R;

public class ContactActivity extends ActionBarActivity {
    
    /* TODO: Add pdf resume and pdf launcher */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        
        Button OpenPDF = (Button)findViewById(R.id.pdf_button);
        OpenPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File pdfFile = new File(""); // link to local copy of pdf resume
                if(pdfFile.exists()) {
                    Uri path = Uri.fromFile(pdfFile);
                    Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                    pdfIntent.setDataAndType(path, ""); // file name for pdf file
                    pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    
                    try {
                        startActivity(pdfIntent);
                    } catch(ActivityNotFoundException e) {
                        Toast.makeText(ContactActivity.this, "No Application available to view PDF", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}