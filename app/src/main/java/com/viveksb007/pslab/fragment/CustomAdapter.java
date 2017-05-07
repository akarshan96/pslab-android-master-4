package com.viveksb007.pslab.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.viveksb007.pslab.R;
import com.viveksb007.pslab.applications.AdvancedControl;
import com.viveksb007.pslab.applications.Control;
import com.viveksb007.pslab.applications.Control2;
import com.viveksb007.pslab.applications.Oscilloscope;

/**
 * Created by akarshan on 4/9/17.
 */

public class CustomAdapter extends BaseAdapter {
    private static LayoutInflater inflater=null;
    private String [] applicationsList;
    private int [] imageList;
    Context c;
    public CustomAdapter(Context context, String[] list1, int[] list2) {
        applicationsList=list1;
        imageList = list2;
        c = context;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return applicationsList.length;
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
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.applications_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.application_tv);
        holder.img=(ImageView) rowView.findViewById(R.id.application_icon);
        holder.tv.setText(applicationsList[position]);
        holder.img.setImageResource(imageList[position]);
        rowView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(position == 0)
                {
                    Intent intent = new Intent(rowView.getContext(), Oscilloscope.class);
                    c.startActivity(intent);
                }
                else if(position == 1)
                {
                    Intent intent = new Intent(rowView.getContext(), Control2.class);
                    c.startActivity(intent);
                }
                else if(position == 2)
                {
                    Intent intent = new Intent(rowView.getContext(), AdvancedControl.class);
                    c.startActivity(intent);
                }
                return false;
            }
        });
        return rowView;
    }


}
