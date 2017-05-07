package com.viveksb007.pslab.applications;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.viveksb007.pslab.R;

import java.util.ArrayList;
import java.util.List;

public class ControlTabActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_tab2);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner4);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner5);
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
        ArrayAdapter analogChannelsAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.a_layout_file, channels);
        ArrayAdapter digitalChannelsAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.a_layout_file, digitalchannels);
        // Drop down layout style - list view with radio button
        analogChannelsAdapter.setDropDownViewResource(R.layout.a_layout_file);
        digitalChannelsAdapter.setDropDownViewResource(R.layout.a_layout_file);

        spinner1.setAdapter(analogChannelsAdapter);
        spinner2.setAdapter(digitalChannelsAdapter);
        spinner3.setAdapter(digitalChannelsAdapter);

    }
}
