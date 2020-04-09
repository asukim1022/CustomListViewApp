package com.asukim.customlistview;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *@CustomAdapter
 *@brief MainActivity에있는 listView을 관리, listView에 ListData에서 저장한 데이터 출력하기
 *@date 2016.02.18
 */
public class CustomAdapter extends BaseAdapter {

    /*
    adapter는 adapter인터페이스를 구현하는 클래스의 인스턴스이다.
    여기서는 ArrayAdapter<ListData>의 인스턴스를 사용할 것이다.
    ListData 타입의 객체를 저장하는 배열에 저장된 데이터를 처리
    ArrayAdapter<ListData>는 BaseAdapter 클래스로부터 상속받는다.
    화면에 보여줄 뷰 객체를 listView가 필요로 할 때는 자신의 어댑터와 소통한다.
    */

    Context context;
    ArrayList<User> userList;


    /*
    context : 두번째 인자인 viewId의 사용에 필요한 context 객체이다.
    viewId : 뷰 객체를 생성하기 위해 ArrayAdapter가 사용할 레이아웃을 나타낸다.
    listDataArrayList : 객체들이 저장된 데이터
    */
    public CustomAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }


    /*
     listView는 어댑터의 getCount() 메서드를 호출하여 배열에 저장된 객체가 몇개가 있는지 요청한다.
     */
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /** @brief getView
     *  @param  position : listView가 찾을 리스트 항목의 위치
     *  @dtails getView의 구현 코드 내부에서 어댑터는 배열의 올바른 항목에 대한 뷰객체를 생성하고 그 뷰 객체를 listView에 반환한다.
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = null;

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            //listView의 item을 출력할 layout 설정
            convertView = mInflater.inflate(R.layout.list_items, null);
            TextView nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
            Button removeBtn = (Button) convertView.findViewById(R.id.removeBtn);
            ImageView icon = (ImageView) convertView.findViewById(R.id.icon);

            //출력할 ListData의 position값 설정
            User m = userList.get(position);

            nameTxt.setText(m.getName());
            icon.setImageResource(m.getIcon());

            removeBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    userList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
        return convertView;
    }
}
