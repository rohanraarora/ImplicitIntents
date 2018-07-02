package in.codingninjas.envision.implicitintents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void shareText(View view){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"abcd");
        startActivity(intent);


    }

    public void sendFeedback(View view){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);

        Uri uri = Uri.parse("mailto:rohan@codingninjas.in");
        intent.setData(uri);
        startActivity(intent);

    }

    public void aboutUs(View view){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("https://codingninjas.in");
        intent.setData(uri);
        startActivity(intent);

    }

    public void dial(View view){


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
           call("999999999");
        }else {
            String[] permissions = {Manifest.permission.CALL_PHONE};
            ActivityCompat.requestPermissions(this,permissions,1);
        }



    }

    public void call(String phone){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + phone);
        intent.setData(uri);
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            int callGrantResult = grantResults[0];
            if(callGrantResult == PackageManager.PERMISSION_GRANTED){
                call("997111111111");
            }
            else {
                Toast.makeText(this,"Grant permission",Toast.LENGTH_LONG).show();
            }
        }
    }
}
