package com.example.recipes.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.recipes.R;
import com.google.android.gms.common.api.Api;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProfileFragment extends Fragment {

    //Объявление полей разметки
    private TextView tvEmail, tvFirstName, tvSecondName;
    private ImageView imageAvatar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        //Связь активити с разметкой
        tvEmail = root.findViewById(R.id.tv_email_profile);
        tvFirstName = root.findViewById(R.id.tv_fn_profile);
        tvSecondName = root.findViewById(R.id.tv_ln_profile);
        imageAvatar = root.findViewById(R.id.profile_image);

        new GetProfileTask().execute();

        return root;
    }


    //Получение информации о пользователе
    class GetProfileTask extends AsyncTask<Void,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            Log.d("myPosts", s);
            try {
                JSONObject reply = new JSONObject(s);
                JSONObject data = new JSONObject(reply.getJSONObject("data").toString());
                tvEmail.setText(data.getString("email"));
                tvFirstName.setText(data.getString("first_name"));
                tvSecondName.setText(data.getString("last_name"));
                Picasso.get().load(data.getString("avatar")).into(imageAvatar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://reqres.in/api/users/2").get().build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}