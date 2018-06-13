package com.example.navjot.callin_msgn;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import  java.lang.String;

public class AlertBox extends Activity {
    final String items[] = {"Blue","Green","Orange"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
        //Setting message manually and performing action on button click
        builder.setItems(items,new DialogInterface.OnClickListener( )
        {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                          String m= items[which];
                            Toast.makeText(getApplicationContext(),"You have selected "+m,Toast.LENGTH_LONG ).show();
            }
        }
        );
      //setMessage("Do you want to close this application ?")
    /*  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Intent ne = new Intent(AlertBox.this, Menu.class);
                        startActivity(ne);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                                              dialog.cancel();
                                      }
                });*/

        //Creating dialog box
        AlertDialog alert = builder.create();

        //Setting the title manually
        alert.setTitle("Select Colors");
        alert.setCancelable(false);
               alert.show();
        setContentView(R.layout.menu);
    }

}
