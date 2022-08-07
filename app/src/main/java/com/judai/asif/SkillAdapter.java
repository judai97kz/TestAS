package com.judai.asif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SkillAdapter extends BaseAdapter {
    private Context context;
    private List<Skills> skilllist;
    private int layout;

    public SkillAdapter(Context context, List<Skills> skilllist, int layout) {
        this.context = context;
        this.skilllist = skilllist;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return skilllist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView txskill = (TextView) view.findViewById(R.id.tsk);
        ImageView imgsk =(ImageView) view.findViewById(R.id.isk);

        Skills skills = skilllist.get(i);
        txskill.setText(skills.getSkill());
        imgsk.setImageBitmap(skills.getImgsk());
        return view;
    }
}
