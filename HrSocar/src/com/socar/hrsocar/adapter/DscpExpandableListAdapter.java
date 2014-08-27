package com.socar.hrsocar.adapter;
import java.util.List;

import com.socar.hrsocar.R;
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;

public class DscpExpandableListAdapter extends BaseExpandableListAdapter implements ExpandableListAdapter  {
    public Context context;
    private LayoutInflater vi;
    private List<String[]> childList;
    private List<String> groupList;
    private static final int GROUP_ITEM_RESOURCE = R.layout.custom_expandable;
    private static final int CHILD_ITEM_RESOURCE = R.layout.expandandable_child;
    public DscpExpandableListAdapter(Context context, Activity activity, List<String[]> childValues, List<String> groupList) {
    	this.childList=childValues;
    	this.groupList=groupList;
        this.context = context;
        vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
	public String getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition)[childPosition];
    }

    @Override
	public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
	public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).length;
    }

    @Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;
        String child = getChild(groupPosition, childPosition);
        if (child != null) {
            v = vi.inflate(CHILD_ITEM_RESOURCE, null);
            ViewHolder holder = new ViewHolder(v);
            holder.text.setText(Html.fromHtml(child));
        }
        return v;
    }
    @Override
	public String getGroup(int groupPosition) {
        return "group-" + groupPosition;
    }
    @Override
	public int getGroupCount() {
        return childList.size();
    }
    @Override
	public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;
        String group = null;
        group=groupList.get(groupPosition);
        if (group != null) {
            v = vi.inflate(GROUP_ITEM_RESOURCE, null);
            ViewHolder holder = new ViewHolder(v);
            holder.text.setText(Html.fromHtml(group));
        }
        return v;
    }
    @Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    @Override
	public boolean hasStableIds() {
        return true;
    }
}
