package com.example.harj3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Model> {

    Context mContext;
     List<Model> modelList = new ArrayList<>();

    public MyAdapter(Context context,  ArrayList<Model> list) {
        super(context, 0 , list);
        mContext = context;
        modelList = list;
    }
    @Override

    public View getView(final int position, View convertView, ViewGroup parent){

        convertView = null;
        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.date, null);
            TextView tvDate = convertView.findViewById(R.id.tvDate);
            ImageView imgDel = convertView.findViewById(R.id.imgDel);

            DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
            String date = df.format(Calendar.getInstance().getTime());
            Model m = modelList.get(position);
            tvDate.setText(m.date);

            imgDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    modelList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
        return convertView;
    }



}
