package in.codingninjas.envision.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        TextView textView = findViewById(R.id.textview);
        Intent intent = getIntent();
        String action = intent.getAction();

        if(action == Intent.ACTION_VIEW){
            Uri data = intent.getData();
            String url = data.toString();
            textView.setText(url);
        }else if(action == Intent.ACTION_SEND){
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(text);
        }


    }
}
