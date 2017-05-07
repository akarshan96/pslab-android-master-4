package com.viveksb007.pslab.applications;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.LayoutInflater;

import com.viveksb007.pslab.CustomSeekBar.FloatSeekBar;
import com.viveksb007.pslab.R;

/**
 * Created by akarshan on 4/10/17.
 */

public class ControlCustomAdapter1 extends BaseAdapter {

    private String[] ivwcontrols;
    private double[] start, end;
    private Context c;
    private static LayoutInflater inflater=null;

    public ControlCustomAdapter1(Context context, String[] list, double[] list1, double[] list2)
    {
        ivwcontrols = list;
        start = list1;
        end = list2;
        c = context;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return ivwcontrols.length;
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
        TextView tv,tv_start,tv_end;
        FloatSeekBar seekbar;
        EditText editText;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ControlCustomAdapter1.Holder holder=new ControlCustomAdapter1.Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.control_list_1, null);
        holder.tv=(TextView) rowView.findViewById(R.id.tv_name);
        holder.tv_start = (TextView) rowView.findViewById(R.id.tv_start);
        holder.tv_end = (TextView) rowView.findViewById(R.id.tv_end);
        holder.seekbar = (FloatSeekBar) rowView.findViewById(R.id.seekBar_value);
        holder.editText = (EditText) rowView.findViewById(R.id.editText_current_value);
        holder.tv.setText(ivwcontrols[position]);
        holder.tv_start.setText(start[position]+getUnit(ivwcontrols[position]));
        holder.tv_end.setText(end[position]+getUnit(ivwcontrols[position]));
        holder.seekbar.setters(start[position],end[position]);
        holder.editText.setText(holder.seekbar.getValue()+getUnit(ivwcontrols[position]));
        //OnTouchListners
        holder.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                holder.editText.setText(holder.seekbar.getValue()+getUnit(ivwcontrols[position]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rowView;

    }
    private String getUnit(String name)
    {
        if(name.equals("PCS"))
        {
            return "mA";
        }
        else if(name.contains("PV"))
        {
            return "V";
        }
        else
        {
            return "Hz";
        }
    }
}
