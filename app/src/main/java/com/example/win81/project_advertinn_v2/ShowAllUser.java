package com.example.win81.project_advertinn_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.win81.project_advertinn_v2.dao.UserController;
import com.example.win81.project_advertinn_v2.dto.User;

import java.util.ArrayList;

public class ShowAllUser extends AppCompatActivity {

    ListView listView;
    ArrayList<User> elist;
    ArrayAdapter<User> adapter;
    UserController econ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        listView=(ListView)findViewById(R.id.list1);
        econ=new UserController(this);
        elist=new ArrayList<>();
        elist= econ.showAllUser();
        adapter=new ArrayAdapter<User>(this,android.R.
                layout.simple_list_item_single_choice,elist);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
