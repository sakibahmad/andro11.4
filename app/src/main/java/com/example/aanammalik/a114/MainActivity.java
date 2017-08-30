package com.example.aanammalik.a114;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StringBuffer details=new StringBuffer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.names= (TextView) findViewById(R.id.names);
        DBHandler handler=new DBHandler(this);

        //Deleting existing rows
        handler.deleteAllNames();

        // Inserting names
        handler.addNameVO(new NameVO(1,"X", "X"));
        handler.addNameVO(new NameVO(2,"Y", "Y"));
        handler.addNameVO(new NameVO(3,"Z", "Z"));
        handler.addNameVO(new NameVO(4,"W", "W"));

        // Reading all names
        List<NameVO> nameVOList = handler.getAllNameVO();

        for (NameVO name : nameVOList) {
            details.append("Id: "+name.getId()+" ,First Name: " + name.getFirstName() + " ,Last Name: " + name.getLastName()).append("\n");
        }
        names.setText(details.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
