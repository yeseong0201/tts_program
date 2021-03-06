package com.jinhyeokfang.appjam.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jinhyeokfang.appjam.Activity.LoginActivity;
import com.jinhyeokfang.appjam.Activity.MainActivity;
import com.jinhyeokfang.appjam.R;
import com.jinhyeokfang.appjam.Retrofit.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDairyDialog extends Dialog {
    private Button positiveButton;
    private Button negativeButton;


    public AddDairyDialog(@NonNull Context context) {
        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_adddairy);

        final EditText titleEditText = findViewById(R.id.titleInputEditText);
        final EditText contentEditText = findViewById(R.id.contentInputEditText);

        positiveButton = findViewById(R.id.diaryPositiveButton);
        negativeButton = findViewById(R.id.diaryNegativeButton);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getContext().getSharedPreferences("id", getContext().MODE_PRIVATE);
                String id = prefs.getString("id", "");
                Client.retrofitService.addDairy(id, titleEditText.getText().toString(), contentEditText.getText().toString()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch(response.code()) {
                            case 200:
                                break;
                            case 405:
                            case 500:
                                Toast.makeText(getContext().getApplicationContext(), "서버 오류", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                dismiss();
            }
        });

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


}
