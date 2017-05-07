package com.viveksb007.pslab.applications;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.viveksb007.pslab.R;

import java.util.ArrayList;
import java.util.List;

public class Oscilloscope extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oscilloscope);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> ch1 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)});
        ch1.setColor(Color.parseColor("#3232ff"));
        graph.addSeries(ch1);
        LineGraphSeries<DataPoint> ch2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 3),
                new DataPoint(1, 4),
                new DataPoint(2, 5)});
        ch2.setColor(Color.parseColor("#00FF00"));
        graph.addSeries(ch2);
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Time (ms)");
        gridLabel.setVerticalAxisTitle("Volts");
        gridLabel.setGridColor(Color.parseColor("#FFFFFF"));
        gridLabel.setHorizontalAxisTitleColor(Color.parseColor("#FFFFFF"));
        gridLabel.setVerticalAxisTitleColor(Color.parseColor("#FFFFFF"));
        gridLabel.setTextSize(16);
        gridLabel.setHorizontalLabelsColor(Color.parseColor("#FFFFFF"));
        gridLabel.setVerticalLabelsColor(Color.parseColor("#FFFFFF"));
        // Spinner element
        Spinner spinner_range_1 = (Spinner) findViewById(R.id.spinner_range_1);
        Spinner spinner_range_2 = (Spinner) findViewById(R.id.spinner_range_2);
        Spinner spinner_channel = (Spinner) findViewById(R.id.spinner_channel);
        Spinner spinner_source_channel = (Spinner) findViewById(R.id.spinner_source_channel);
        Spinner spinner_fit = (Spinner) findViewById(R.id.spinner_fit);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner_channel_2 = (Spinner) findViewById(R.id.spinner_channel_2);
        Spinner spinner_channel_3 = (Spinner) findViewById(R.id.spinner_channel_3);

        // Spinner Drop down elements
        List<String> channels = new ArrayList<String>();
        channels.add("CH1");
        channels.add("CH2");
        channels.add("CH3");
        channels.add("MIC");

        List<String> range = new ArrayList<String>();
        range.add("+/-4V");
        range.add("+/-3.3V");

        List<String> fit = new ArrayList<String>();
        fit.add("Sin Fit");
        fit.add("Cosine Fit");

        List<String>  others = new ArrayList<String>();
        others.add("None");

        // Creating adapter for spinner
        ArrayAdapter<String> rangeAdapter = new ArrayAdapter<String>(this, R.layout.a_layout_file, range);
        ArrayAdapter<String> channelsAdapter = new ArrayAdapter<String>(this, R.layout.a_layout_file, channels);
        ArrayAdapter<String> fitAdapter = new ArrayAdapter<String>(this, R.layout.a_layout_file, fit);
        ArrayAdapter<String> othersAdapter = new ArrayAdapter<String>(this, R.layout.a_layout_file, others);

        // Drop down layout style - list view with radio button
        rangeAdapter.setDropDownViewResource(R.layout.a_layout_file);
        channelsAdapter.setDropDownViewResource(R.layout.a_layout_file);
        fitAdapter.setDropDownViewResource(R.layout.a_layout_file);
        othersAdapter.setDropDownViewResource(R.layout.a_layout_file);

        // attaching data adapter to spinner
        spinner_range_1.setAdapter(rangeAdapter);
        spinner_range_2.setAdapter(rangeAdapter);
        spinner_channel.setAdapter(channelsAdapter);
        spinner_channel_2.setAdapter(channelsAdapter);
        spinner_channel_3.setAdapter(channelsAdapter);
        spinner_source_channel.setAdapter(channelsAdapter);
        spinner.setAdapter(othersAdapter);
        spinner2.setAdapter(othersAdapter);
        spinner_fit.setAdapter(fitAdapter);
    }

}
