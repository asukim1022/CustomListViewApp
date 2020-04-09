package com.asukim.customlistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 *@MainActivity
 *@brief listView생성, adapter생성, ArrayList제어, 데이터 저장/불러오기
 *@date 2016.02.18
 *@details
 */
public class MainActivity extends AppCompatActivity {

    ListView ListView;

    //listView의 데이터 저장하는 배열
    ArrayList<User> userList;

    //listView 관리하는 adapter
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = (ListView) findViewById(R.id.listView);

        //userList 초기화
        userList = new ArrayList<User>();

        /*
        adapter 생성후 layout이랑 배열 연결
        adapter : adapter 설정, MyListViewAdapter에 layout.item와 myList 연결
        */
        adapter = new CustomAdapter(getApplicationContext(), userList);
        ListView.setAdapter(adapter);

        //listView item 클릭시 이벤트
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //해당 클릭 position 출력
                Toast.makeText(getApplicationContext(), "Position : " + position, Toast.LENGTH_SHORT).show();
            }
        });

        loadData();
    }


    /** @brief loadData
     *  @date 2016-02-18
     *  @detail User에 데이터 입력후 list
     *  item 생성
     */
    public void loadData() {
        for (int i = 0; i <= 20; i++) {
            userList.add(new User("text" + i, R.mipmap.ic_launcher));
        }
    }
}


