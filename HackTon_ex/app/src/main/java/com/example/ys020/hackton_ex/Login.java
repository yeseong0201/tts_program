package com.example.ys020.hackton_ex;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText idInput, passwordInput;
    CheckBox autoLogin;
    Boolean loginChecked;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idInput = findViewById(R.id.id_text);
        passwordInput = findViewById((R.id.password_text));
        autoLogin = findViewById(R.id.auto_log_btn);

        if (pref.getBoolean("autoLogin", false)) {
            idInput.setText(pref.getString("id", ""));
            passwordInput.setText(pref.getString("password", ""));
            autoLogin.setChecked(true);
        } else {
            String id = idInput.getText().toString();
            String password = passwordInput.getText().toString();
            Boolean validation = loginValidation(id, password);

            if (validation) {
                Toast.makeText(Login.this,"Login Success", Toast.LENGTH_SHORT).show();
                if (loginChecked) {
                    editor.putString("id", id);
                    editor.putString("pw", password);
                    editor.putBoolean("autoLogin", true);
                    editor.commit();
                }
            } else {
                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
        autoLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    loginChecked = true;
                } else {
                    loginChecked = false;
                    editor.clear();
                    editor.commit();
                }
            }
        });

    }

    private boolean loginValidation(String id, String password) {
        if (pref.getString("id", "").equals(id) && pref.getString("pw", "").equals(password)) {
            return true;
        } else if (pref.getString("id", "").equals(null)) {
            Toast.makeText(Login.this, "Please Sign in first", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return false;
        }

    }
}
