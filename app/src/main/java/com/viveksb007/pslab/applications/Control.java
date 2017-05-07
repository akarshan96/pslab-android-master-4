package com.viveksb007.pslab.applications;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.viveksb007.pslab.R;
import com.viveksb007.pslab.fragment.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static java.security.AccessController.getContext;

public class Control extends AppCompatActivity {

    String[] ivwcontrols = {"PCS","PV1","PV2","PV3","W1","W2"};
    String[] othercontrols = {"Resistance","Capacitance","Voltmeter","Low Frequency","High Frequency","Control Pulse"};
    double[] start = {0,-3.3,-5,-5,5,5};
    double[] end = {3.3,3.3,5,5,5000,5000};
    int [] spinnerVisibilty = {View.INVISIBLE,View.INVISIBLE,View.VISIBLE,View.VISIBLE,View.VISIBLE,View.VISIBLE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        ListView controlListView1 = (ListView) findViewById(R.id.listControl1);
        ListView controlListView2 = (ListView) findViewById(R.id.listControl2);
        RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) controlListView1.getLayoutParams();
        //ListView height changes according to the size of the window
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);
        int height = metrics.heightPixels;
        list.height = height/2;
        controlListView1.setLayoutParams(list);

        //list adatapters
        ControlCustomAdapter1 controlcustomapadter1 = new ControlCustomAdapter1(getApplicationContext(),ivwcontrols,start,end);
        ControlCustomAdapter2 controlcustomadapter2 = new ControlCustomAdapter2(getApplicationContext(),othercontrols,spinnerVisibilty);
        controlListView1.setAdapter(controlcustomapadter1);
        controlListView2.setAdapter(controlcustomadapter2);
    }
}
