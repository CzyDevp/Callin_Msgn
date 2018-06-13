package com.example.navjot.callin_msgn;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallMessage extends Activity {
    int CALL_REQUEST_GRANTED =1;
    Button b1_call, b2_msg, b3_dial;
    EditText ed;
    String num;
    final Intent call = new Intent(Intent.ACTION_CALL);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_msg);
        b1_call = findViewById(R.id.buttonCall);
        b2_msg = findViewById(R.id.buttonmsg);
        b3_dial = findViewById(R.id.btndial);
        ed = findViewById(R.id.edt);
        int a = ed.getText().length();
        ed.setSelection(a);
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed.getText().length() > 0) {
                    ed.setText("");
                }
            }
        });
        b1_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = ed.getText().toString();
                if (num.length() > 0) {
                    // Intent call = new Intent(Intent.ACTION_CALL);
                    call.setData(Uri.parse("tel:" + num));
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        ActivityCompat.requestPermissions(CallMessage.this,
                                                           new String[]{Manifest.permission.CALL_PHONE},
                                                           CALL_REQUEST_GRANTED);
                        //return;
                    }
                    else {
                    startActivity(call);
                    }
                     }
                     }
                     });
         b3_dial.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                   Intent call1 = new Intent(Intent.ACTION_DIAL);
                   startActivity(call1);
                   }
                   });
         b2_msg.setOnClickListener(new View.OnClickListener()
         {
         @Override
         public void onClick(View v)
         {

             msg();
                  }
                  });
                  }
         @Override
         public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.call_msg, menu);
         return true;
                 }

         @Override
         public boolean onOptionsItemSelected(MenuItem item) {
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         int id = item.getItemId();
         if (id == R.id.action_settings) {
         return true;
                }
        return super.onOptionsItemSelected(item);
                }

    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on {@link #requestPermissions(String[], int)}.
     * <p>
     * <strong>Note:</strong> It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     * </p>
     *
     * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link PackageManager#PERMISSION_GRANTED}
     *                     or {@link PackageManager#PERMISSION_DENIED}. Never null.
     * @see #requestPermissions(String[], int)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CALL_REQUEST_GRANTED){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
               //startActivity(call);
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void msg(){
                    Intent intent=new Intent(getApplicationContext(),CallMessage.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                    String no ="5147921313";
                    String message = "Welcome In VenturePact";
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(no, null, message,null, null);
                        Toast.makeText(getApplicationContext(), "Message has been send Successfully", Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Message Sending Failed", Toast.LENGTH_LONG).show();
                    }
                    }
                }

