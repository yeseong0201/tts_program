package com.example.ys020.listview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private Object setAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final Data[] items = {new Data("정보통신과","네트워크와 통신기술을 기초로 보안, 지능형 홈네트워크," +
                "Ubiqutious Computing 등 차세대 성장 동력 분야의 창의적 인재를 육성한다."),
                new Data("소프트웨어과","IT강국으로 이끌어갈 소프트웨어 개발 전문가 육성을 위하여 C++, JAVA, XML 등의 프로그래밍 언어를 바탕으로 " +
                "게임, 웹콘텐츠, 앱(APP), 프로그램을 개발할 수 있는 핵심적인 능력을 기른다."),
        new Data("테크노경영과","지식정보사회에 적합한 미래의 CEO로서 기업경영에 필요한 전문적인 능력을" +
                "함양하고 사이버공간을 활용한 기업 활동 능력을 기른다."),
        new Data("멀티미디어과","멀티미디어 전반에 대한 총체적인 이해력을 갖춘 컴퓨터그래픽, 디저털방송," +
                "멀티미디어 콘텐츠, 영상 편집 및 제작 등이 가능한 전문인력을 육성한다.")};
        ListAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return items.length;
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
                View v = LayoutInflater.from(mContext).inflate(R.layout.activity_list_view,parent);
                TextView big = v.findViewById(R.id.)
                return null;
            }
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
