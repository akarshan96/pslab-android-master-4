package com.viveksb007.pslab.applications;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TabHost;

import com.viveksb007.pslab.R;

import java.util.ArrayList;
import java.util.List;

public class Control2 extends TabActivity {
    TabHost tabHostControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control2);
        tabHostControl = (TabHost)findViewById(android.R.id.tabhost);
        tabHostControl.setup(this.getLocalActivityManager());

        TabHost.TabSpec tabSpecControl = tabHostControl.newTabSpec("Tab 1");
        TabHost.TabSpec tabSpecRead = tabHostControl.newTabSpec("Tab 2");

        tabSpecControl.setIndicator("Control");
        tabSpecRead.setIndicator("Read");


        tabSpecControl.setContent(new Intent(this,ControlTabActivity1.class));
        tabSpecRead.setContent(new Intent(this,ControlTabActivity2.class));

        tabHostControl.addTab(tabSpecControl);
        tabHostControl.addTab(tabSpecRead);

        // Spinner Drop down elements
        List<String> channels = new ArrayList<String>();
        channels.add("CH1");
        channels.add("CH2");
        channels.add("CH3");
        channels.add("MIC");
        List<String> digitalchannels = new ArrayList<String>();
        digitalchannels.add("ID1");
        digitalchannels.add("ID2");
        digitalchannels.add("ID3");
        digitalchannels.add("ID4");
        // Creating adapter for spinner
        ArrayAdapter<String> analogChannelsAdapter, digitalChannelsAdapter;
        analogChannelsAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.a_layout_file, channels);
        digitalChannelsAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.a_layout_file, digitalchannels);
        // Drop down layout style - list view with radio button
        analogChannelsAdapter.setDropDownViewResource(R.layout.a_layout_file);
        digitalChannelsAdapter.setDropDownViewResource(R.layout.a_layout_file);

    }

}
