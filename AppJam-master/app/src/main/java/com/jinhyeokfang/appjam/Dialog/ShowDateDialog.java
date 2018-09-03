package com.jinhyeokfang.appjam.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jinhyeokfang.appjam.R;
import com.jinhyeokfang.appjam.Retrofit.Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDateDialog extends Dialog {
    private int year;
    private int month;
    private int date;

    public ShowDateDialog(@NonNull Context context, int year, int month, int date) {
        super(context);
        this.year = year;
        this.month = month + 1;
        this.date = date;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀 바 삭제
        setContentView(R.layout.dialog_showdate);
        Button closeButton = findViewById(R.id.showCloseButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        SharedPreferences prefs = getContext().getSharedPreferences("id", getContext().MODE_PRIVATE);
        String id = prefs.getString("id", "");

        final TextView titleTextView = findViewById(R.id.showTitleTextView);
        final TextView contentTextView = findViewById(R.id.showContentTitle);

        Client.retrofitService.loadDate(id, year, month, date).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.body().string());
                    titleTextView.setText(jsonObject.getString("title"));
                    contentTextView.setText(jsonObject.getString("content"));
                } catch (JSONException e) {
                    Toast.makeText(getContext().getApplicationContext(), "일정이 없습니다.", Toast.LENGTH_SHORT).show();
                    dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
