package com.example.navjot.callin_msgn;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class Menu extends ListActivity{
    String str[] = {"CallMessage","AlertBox","multi","mulselect"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.menu);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,str));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String select= str[position];
        try
        {
            Class class1 = Class.forName("com.example.navjot.callin_msgn." + select);
            Intent Intent2 = new Intent(Menu.this,class1);
            startActivity(Intent2);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
