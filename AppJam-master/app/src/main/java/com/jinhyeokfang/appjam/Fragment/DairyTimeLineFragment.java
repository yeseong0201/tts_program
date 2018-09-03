package com.jinhyeokfang.appjam.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinhyeokfang.appjam.Adapter.DairyRecyclerViewAdapter;
import com.jinhyeokfang.appjam.Dialog.AddDairyDialog;
import com.jinhyeokfang.appjam.Model.Dairy;
import com.jinhyeokfang.appjam.R;
import com.jinhyeokfang.appjam.Retrofit.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DairyTimeLineFragment extends Fragment {
    private RecyclerView recyclerView;
    private DairyRecyclerViewAdapter recyclerViewAdapter;
    private FloatingActionButton addDairyFAB;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dairy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.dairyTimeLineRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewAdapter = new DairyRecyclerViewAdapter(new ArrayList<Dairy>());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);


        SharedPreferences prefs = getContext().getSharedPreferences("id", getContext().MODE_PRIVATE);
        String id = prefs.getString("id", "");
        Client.retrofitService.loadDairy(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JSONArray jsonArray = null;

                try {
                    jsonArray = jsonObject.getJSONArray("result");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject data = null;
                    try {
                        data = jsonArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        recyclerViewAdapter.addItem(recyclerViewAdapter.getItemCount(), new Dairy(data.getString("title"), data.getString("content"), data.getString("date")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        addDairyFAB = view.findViewById(R.id.addDairyFAB);
        addDairyFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDairyDialog addDairyDialog = new AddDairyDialog(getContext());
                addDairyDialog.show();
            }
        });
    }
}
