package com.viveksb007.pslab.applications;
import com.viveksb007.pslab.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class AdvancedControl extends AppCompatActivity {

    int height, width;
    RelativeLayout relativeLayoutIVSources,parent,relativeLayoutVoltageSources;
    String[] ivcontrols = {"PCS","PV1","PV2","PV3"};
    String[] voltmeterchannels = {"CH1","CH2","CH3","CAP","SEN","AN8"};
    String[] waveformgenerators = {"W1","W2"};
    String[] pwm = {"SQR1","SQR2","SQR2","SQR4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_control);
        relativeLayoutIVSources = (RelativeLayout) findViewById(R.id.relative_layout_ivsources);
        relativeLayoutVoltageSources = (RelativeLayout) findViewById(R.id.relative_layout_voltage);
        parent = (RelativeLayout) findViewById(R.id.activity_advanced_control);
        ListView advcontrolListView1 = (ListView) findViewById(R.id.list_ivsource);
        ListView advcontrolListView2 = (ListView) findViewById(R.id.list_voltage);
        AdvControlCustomAdapter1 advControlCustomAdapter1 = new AdvControlCustomAdapter1(getApplicationContext(),ivcontrols);
        advcontrolListView1.setAdapter(advControlCustomAdapter1);
        AdvControlCustomAdapter2 advControlCustomAdapter2 = new AdvControlCustomAdapter2(getApplicationContext(),voltmeterchannels);
        advcontrolListView2.setAdapter(advControlCustomAdapter2);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        height = parent.getHeight();
        width = parent.getWidth();
        RelativeLayout.LayoutParams relativeLayoutIVSourcesLayoutParams = (RelativeLayout.LayoutParams) relativeLayoutIVSources.getLayoutParams();
        RelativeLayout.LayoutParams relativeLayoutVoltageSourcesParams = (RelativeLayout.LayoutParams) relativeLayoutVoltageSources.getLayoutParams();
        relativeLayoutIVSourcesLayoutParams.height=height/2;
        relativeLayoutIVSourcesLayoutParams.width=width/2;
        relativeLayoutVoltageSourcesParams.height=height/2;
        relativeLayoutVoltageSourcesParams.width=width/2;
        relativeLayoutIVSources.setLayoutParams(relativeLayoutIVSourcesLayoutParams);
        relativeLayoutVoltageSources.setLayoutParams(relativeLayoutVoltageSourcesParams);
    }
}
