package app.sharma.adhiyamanlogistics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity context;
    private Map<String, List<String>> ParentListItem;
    private List<String> Items;

    public CustomExpandableListAdapter(Activity context, List<String> items, Map<String, List<String>> ParentListItem) {
        this.context = context;
        this.ParentListItem = ParentListItem;
        Items = items;
    }

    //Parent
    @Override
    public int getGroupCount() {
        return Items.size();
    }

    @Override
    public Object getGroup(int i) {
        return Items.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String string = (String) getGroup(i);
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            view = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.groupName);
        textView.setText(string);
        return view;
    }

    //Child
    @Override
    public int getChildrenCount(int i) {
        return Objects.requireNonNull(ParentListItem.get(Items.get(i))).size();
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public Object getChild(int i, int i1) {
        return Objects.requireNonNull(ParentListItem.get(Items.get(i))).get(i1);
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childName = (String) getChild(i, i1);
        LayoutInflater inflater = context.getLayoutInflater();
        if (view == null){
            view = inflater.inflate(R.layout.list_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.listName);
        textView.setText(childName);
        return view;
    }

    //Selectables
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
