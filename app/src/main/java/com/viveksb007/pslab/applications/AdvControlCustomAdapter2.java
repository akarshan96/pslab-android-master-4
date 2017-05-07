package com.viveksb007.pslab.applications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.viveksb007.pslab.R;

/**
 * Created by akarshan on 4/13/17.
 */

public class AdvControlCustomAdapter2 extends BaseAdapter {
    String channelList [];
    private static LayoutInflater inflater=null;
    AdvControlCustomAdapter2(Context context, String[] list)
    {
        channelList = list;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return channelList.length;
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
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        AdvControlCustomAdapter2.Holder holder=new AdvControlCustomAdapter2.Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.advcontrol_list_2, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView3);
        holder.tv.setText(channelList[position]);
        return rowView;
    }

}
