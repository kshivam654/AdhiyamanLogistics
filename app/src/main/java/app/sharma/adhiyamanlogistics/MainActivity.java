package app.sharma.adhiyamanlogistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ImageView backarraow;
    List<String> ChildList;
    Map<String, List<String>> ParentListItem;

    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("Computers");
        ParentList.add("Banking");
    }
    String[] computer = {"computer1", "computer1", "computer1"};
    String[] bank = {"bank1", "bank2", "bank3", "bank4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandable_listview);

        backarraow = findViewById(R.id.backarrow);

        backarraow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ParentListItem = new LinkedHashMap<>();
        for (String HoldItem: ParentList){
            if (HoldItem.equals("Computers")){
                loadChild(computer);
            }
            else if (HoldItem.equals("Banking")){
                loadChild(bank);
            }

            ParentListItem.put(HoldItem, ChildList);
        }

        final ExpandableListAdapter expandableListAdapter = new CustomExpandableListAdapter(this, ParentList, ParentListItem);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final String selected = (String) expandableListAdapter.getChild(i, i1);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("selected", selected);
                startActivity(intent);
                return true;
            }
        });

    }

    private void loadChild(String[] ParentElementName) {
        ChildList = new ArrayList<>();
        Collections.addAll(ChildList, ParentElementName);
    }
}