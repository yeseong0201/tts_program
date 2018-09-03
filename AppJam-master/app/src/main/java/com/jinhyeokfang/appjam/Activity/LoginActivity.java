package com.jinhyeokfang.appjam.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jinhyeokfang.appjam.R;
import com.jinhyeokfang.appjam.Retrofit.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText idText;
    EditText pwText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView backgroundImageView = findViewById(R.id.loginBackgroundImageView);
        backgroundImageView.setImageBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.splashbackgroundimage));
        backgroundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageButton loginButton = findViewById(R.id.signimageButton);
        idText = findViewById(R.id.idInputEditText);
        pwText = findViewById(R.id.passwordInputEditText);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.retrofitService.logIn(idText.getText().toString(), pwText.getText().toString()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch(response.code()) {
                            case 200:
                                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                                SharedPreferences prefs = getSharedPreferences("id", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("id", idText.getText().toString());
                                editor.apply();
                                startActivity(loginIntent);
                                finish();
                                break;
                            case 405:
                                Toast.makeText(getApplicationContext(), "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show();
                                break;
                            case 500:
                                Toast.makeText(getApplicationContext(), "로그인 실패 : 서버 오류", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {

                    }
                });

            }
        });

        TextView signupTextView = findViewById(R.id.signUpText);
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signupIntent);
            }
        });
    }
}
