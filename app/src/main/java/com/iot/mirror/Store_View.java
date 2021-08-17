package com.iot.mirror;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Store_View extends AppCompatActivity {

    // 상단 텍스트바 로그인
    private TextView tx_login_data = null;
    // 상단 툴바
    private Toolbar top_Toolbar = null;

    // 커스텀 내비 레이아웃
    private DrawerLayout drawer_Layout = null;
    private NavigationView navi_View = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mirror_store_view_t);

        top_Toolbar = findViewById(R.id.top_Toolbar);
        drawer_Layout = findViewById(R.id.drawer_Layout);
        navi_View = findViewById(R.id.navi_View);

        // 내비 기능
        Navi_Content();
    }

    // 액션바 눌렀을때 버튼 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawer_Layout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void Navi_Content() {

        // tx_login_data 로그인에서 데이터저장 필요 쉐어드프리

        setSupportActionBar(top_Toolbar);

        ActionBar actionBar = getSupportActionBar();

        // 액션바(최상단) 좌측 상단 버튼 활성화
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);

        // ActionBar.show() ; 앱바(App Bar) 보이기
        // ActionBar.hide() ; 앱바(App Bar) 숨기기

        // 기존 상단바 지우기
        actionBar.setDisplayShowTitleEnabled(false);

        // 내비 하단 라인 색상 지정
        navi_View.setBackgroundColor(Color.GRAY);

        // 내비 눌렀을때 동작
        navi_View.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menu_item) {
                // 메뉴 눌렀는지 기억하는 기능
                // menu_item.setChecked(true);

                drawer_Layout.closeDrawers();

                int menu_id = menu_item.getItemId();
                String menu_list = menu_item.getTitle().toString();

                // 메뉴 리스트 menu_id 받아서 사용
                if (menu_id == R.id.menu_home) {
                    // 확인용
                    Toast.makeText(Store_View.this, menu_list + ": 리스트1", Toast.LENGTH_SHORT).show();

                } else if (menu_id == R.id.menu_store) {

                    Toast.makeText(Store_View.this, menu_list + ": 리스트2", Toast.LENGTH_SHORT).show();

                } else if (menu_id == R.id.menu_support) {

                    Toast.makeText(Store_View.this, menu_list + ": 리스트3", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });
    }
}