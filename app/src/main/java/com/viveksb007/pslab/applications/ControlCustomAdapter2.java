package com.viveksb007.pslab.applications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.viveksb007.pslab.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akarshan on 4/10/17.
 */

public class ControlCustomAdapter2 extends BaseAdapter {
    String[] othercontrols;
    int [] spinnerVisibilty;
    Context c;
    ArrayAdapter<String> analogChannelsAdapter, digitalChannelsAdapter;
    private static LayoutInflater inflater=null;

    public ControlCustomAdapter2(Context context, String[] list1, int[] list2){
        othercontrols = list1;
        spinnerVisibilty = list2;
        c = context;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       adapterInitialization(context);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return othercontrols.length;
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    private class Holder
    {
        TextView tv;
        Spinner spinner;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ControlCustomAdapter2.Holder holder=new ControlCustomAdapter2.Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.control_list_2, null);
        holder.tv = (TextView)rowView.findViewById(R.id.tv_name);
        holder.spinner = (Spinner)rowView.findViewById(R.id.spinner_channel);
        holder.tv.setText(othercontrols[position]);
        holder.spinner.setVisibility(spinnerVisibilty[position]);
        if(othercontrols[position].equals("Voltmeter"))
        {
            holder.spinner.setAdapter(analogChannelsAdapter);
        }
        else
        {
            holder.spinner.setAdapter(digitalChannelsAdapter);
        }
        return rowView;

    }
    private void adapterInitialization(Context context)
    {
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
        analogChannelsAdapter = new ArrayAdapter<String>(context, R.layout.a_layout_file, channels);
        digitalChannelsAdapter = new ArrayAdapter<String>(context, R.layout.a_layout_file, digitalchannels);
        // Drop down layout style - list view with radio button
        analogChannelsAdapter.setDropDownViewResource(R.layout.a_layout_file);
        digitalChannelsAdapter.setDropDownViewResource(R.layout.a_layout_file);
    }

}
