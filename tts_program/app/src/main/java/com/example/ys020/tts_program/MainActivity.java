package com.example.ys020.tts_program;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Locale;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.speech.tts.TextToSpeech.ERROR;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech tts;
    private EditText editText;
    private Button button01,button02,button03,button04,button05;
    public  MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        button01 = (Button)findViewById(R.id.button01);
        button02 = (Button)findViewById(R.id.button02);
        button03 = (Button)findViewById(R.id.button03);
        button04 = (Button)findViewById(R.id.button04);
        button05 = (Button)findViewById(R.id.button05);

        //TTS를 생성하고 OnlnitListener로 초기화
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR){
                    // select language
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(2.0f); // 음성 톤을 두배로 올려줌.
                tts.setSpeechRate(1.0f); // 읽는 속도는 기본으로 설정
                // editText에 있는 문장을 읽음.
                tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(0.5f); // 음성 톤을 0.5배로 내려줌
                tts.setSpeechRate(1.0f); // 읽는 속도는 기본
                tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(2.0f);
                tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(0.5f);
                tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // tts 객체가 남아있으면 실행을 중지하고 메모리에서 제거함.
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
}
