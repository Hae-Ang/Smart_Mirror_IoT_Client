package com.iot.mirror;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class Login_T extends AppCompatActivity {

    private EditText edt_user_id, edt_user_pw = null;
    private Button btn_login, btn_info = null;
    private ProgressBar loadingProgressBar = null;
    private MotionEvent motionEvent = null;
    private ConstraintLayout const_layout = null;
    private InputMethodManager inputMethodManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mirror_login_t);

        const_layout = findViewById(R.id.const_layout);

        // Const레이아웃이 키 이벤트 받는 컴포넌트가 여러개 동작시킬때 우선동작
        const_layout.setFocusable(false);

        edt_user_id = findViewById(R.id.edt_user_id);
        edt_user_pw = findViewById(R.id.edt_user_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_info = findViewById(R.id.btn_info);
        loadingProgressBar = findViewById(R.id.btn_loading);

        // 아이디 자판을 통한 액션
        edt_user_id.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView edt_user_id, int actionId, KeyEvent event) {
                String id = edt_user_id.getText().toString();

                // id 텍스트가 비어있는가?
                if (id.isEmpty()) {
                    edt_user_id.clearFocus();
                    edt_user_id.setFocusable(false);
                    edt_user_id.setFocusableInTouchMode(true);
                    edt_user_id.setFocusable(true);
                    btn_login.setEnabled(false);
                    return true;
                } else {
                    btn_login.setEnabled(true);
                }

                // 텍스트 내용이 비어있지않다면
                switch (actionId) {
                    // Search 버튼일경우
                    case EditorInfo.IME_ACTION_SEARCH:
                        break;
                    // Enter 버튼일경우
                    default:
                        return false;
                }

                // 내용 비우고 다시 이벤트 할수있게 선택
                edt_user_id.clearFocus();
                edt_user_id.setFocusable(false);
                edt_user_id.setText("");
                edt_user_id.setFocusableInTouchMode(true);
                edt_user_id.setFocusable(true);

                return true;
            }
        });

        // 비밀번호 자판을 통한 액션
        edt_user_pw.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView edt_user_pw, int actionId, KeyEvent event) {

                String pw = edt_user_pw.getText().toString();

                // pw가 비어있는가?
                if (pw.isEmpty()) {
                    edt_user_pw.clearFocus();
                    edt_user_pw.setFocusable(false);
                    edt_user_pw.setFocusableInTouchMode(true);
                    edt_user_pw.setFocusable(true);
                    btn_login.setEnabled(false);
                    return true;
                } else {
                    btn_login.setEnabled(true);
                }

                // 텍스트 내용이 비어있지않다면
                switch (actionId) {
                    // Search 버튼일경우
                    case EditorInfo.IME_ACTION_SEARCH:
                        break;

                    // Enter 버튼일경우
                    default:
                        return false;
                }
                // 내용 비우고 다시 이벤트 할수있게 선택
                edt_user_pw.clearFocus();
                edt_user_pw.setFocusable(false);
                edt_user_pw.setText("");
                edt_user_pw.setFocusableInTouchMode(true);
                edt_user_pw.setFocusable(true);

                return true;
            }
        });

        // 터치시의 동작
        const_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String id = edt_user_id.getText().toString();
                String pw = edt_user_pw.getText().toString();

                // 손가락 터치 클래스 인스턴스
                // hideSoftInputFromWindow -> 자판 숨기기(입력대상,플래그)
                inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(const_layout.getWindowToken(), 0);

                // id, pw가 비어있으면
                if (id.isEmpty() == true && pw.isEmpty() == true) {
                    btn_login.setEnabled(false);
                } else if (id.isEmpty() == false || pw.isEmpty() == false) {
                    // id 또는 pw가 채워있으면
                    btn_login.setEnabled(true);
                }

                return false;
            }
        });

        // 로그인 버튼 누를 때의 액션
        btn_login.setOnClickListener(v -> {

            // 여기에 sql과 인탠트를 통한 액션 넣으면 완료

            loadingProgressBar.setVisibility(View.VISIBLE);
            updateUiWithUser();

            Intent intent = new Intent(Login_T.this, Main_T.class);
            
            // sql 사용자 이름 데이터 집어 넣기
            intent.putExtra("user_name", "사용자 이름");
            
            startActivity(intent);

            finish();
        });

        btn_info.setOnClickListener(v -> {
            // 회원가입 레이아웃 미구현

//            Intent intent = new Intent(Login_T.this, ??);
//            startActivity(intent);
        });
    }

    // 확인 임시용
    private void updateUiWithUser() {
        String welcome = "성공했습니다.";

        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

}