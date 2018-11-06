package rankhep.com.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText inp;
    Button post, get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        inp = findViewById(R.id.inp);
        post = findViewById(R.id.post);
        get = findViewById(R.id.get);

        text.setText(new DataHelper(getApplicationContext()).getText());


        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkHelper.getInstance()
                        .POSTData(inp.getText().toString())
                        .enqueue(new Callback<Data>() {
                            @Override
                            public void onResponse(Call<Data> call, Response<Data> response) {
                                text.setText(response.body().getData());
                            }

                            @Override
                            public void onFailure(Call<Data> call, Throwable t) {
                                Log.e("Fail", t.getMessage());
                            }
                        });
            }
        });



        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkHelper.getInstance()
                        .GETData(inp.getText().toString())
                        .enqueue(new Callback<Data>() {
                            @Override
           d                 public void onResponse(Call<Data> call, Response<Data> response) {
                                text.setText(response.body().getData());
                                new DataHelper(getApplicationContext())
                                        .saveText(inp.getText().toString());
                            }

                            @Override
                            public void onFailure(Call<Data> call, Throwable t) {
                                Log.e("Fail", t.getMessage());
                            }
                        });
            }
        });

    }
}
