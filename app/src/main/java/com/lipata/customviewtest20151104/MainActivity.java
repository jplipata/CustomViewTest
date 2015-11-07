package com.lipata.customviewtest20151104;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //TODO Replace below `testData` with tests in the testing framework
    String[] testData = {"5 km/h S", "4 km/h SW", "6 km/h NW", "2 mph SW", "4 mph E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);

        myView.initialize(400, 800, testData[3] );
        setContentView(myView);

    }
}
