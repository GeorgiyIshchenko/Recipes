package com.example.recipes.auth_fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipes.MainActivity;
import com.example.recipes.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthFragment extends Fragment {

    //Поля элементов разметки
    private EditText etUsername;
    private EditText etPassword;
    private Button btnEnter;
    private TextView tvRegLink;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        //Связь с активити с элементами разметки
        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        btnEnter = view.findViewById(R.id.btn_enter);
        tvRegLink = view.findViewById(R.id.tv_reg);

        etUsername.setText("eve.holt@reqres.in");
        etPassword.setText("cityslicka");

        //Обработка нажатий элементов
        tvRegLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.activity_start, new RegFragment()).addToBackStack(null).commit();
            }
        });
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AuthTask().execute();
            }
        });
        return view;
    }

    //Класс для регистрации юзера
    class User{

        public String email;
        public String password;

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    class AuthTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean) startActivity(new Intent(getActivity(), MainActivity.class));
            else Toast.makeText(getActivity(), "Авторизация неуспешна", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            String stringBody = String.valueOf(new Gson()
                    .toJson(new AuthFragment.User(etUsername.getText().toString(),
                            etPassword.getText().toString())));
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody requestBody = RequestBody.create(stringBody, mediaType);
            Log.d("myPosts", requestBody.toString());
            Request request = new Request.Builder().url("https://reqres.in/api/login")
                    .post(requestBody).build();
            try {
                Response response = client.newCall(request).execute();
                Log.d("myPosts", response.body().string());
                return response.isSuccessful();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}