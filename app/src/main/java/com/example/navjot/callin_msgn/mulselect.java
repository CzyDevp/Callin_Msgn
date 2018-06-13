package com.example.navjot.callin_msgn;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.ListView;
import android.content.Intent;

import  java.lang.String;
public class mulselect extends Activity {
    final CharSequence[] items = { "Red","Green","Yellow" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean[] _selections = new boolean[items.length];
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
        //Setting message manually and performing action on button click
        builder.setMultiChoiceItems (items,_selections, new DialogInterface.OnMultiChoiceClickListener( )
                {
                    public void onClick(DialogInterface dialog, int which,boolean ischecked) {

                                          }
                }
        );

        // add positive button here
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // getting listview from alert box
                ListView list = ((AlertDialog) dialog).getListView();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.getCount(); i++) {
                    boolean checked = list.isItemChecked(i);
                    // get checked list value
                    if (checked) {
                        if (sb.length() > 0)
                            sb.append(",");
                        sb.append(list.getItemAtPosition(i));
                    }
                }

                Toast.makeText(getApplicationContext(),"Selected Colors are  :"
                        +sb.toString(),Toast.LENGTH_SHORT).show();
            }
        });

// add negative button
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // cancel code here
                              }
                });
        AlertDialog alert1 =builder.create();
        alert1.show();
        alert1.setTitle("Select Multiple colors");
        alert1.setCancelable(false);
        alert1.show();
        setContentView(R.layout.menu);
    }

}
