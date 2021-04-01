package com.example.recipes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recipes.CategoriesAdapter;
import com.example.recipes.Category;
import com.example.recipes.R;
import com.example.recipes.Recipe;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    //Объявление объектов разметки
    ListView listView;

    //Объекты для создания списка
    ArrayList<Category> categories = new ArrayList<>();
    CategoriesAdapter categoriesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //Связь с разметкой
        listView = root.findViewById(R.id.lv_categories);

        //Создание элементов массива
        categories.add(new Category("Хлеб",
                "https://irinachekurina.ru/wp-content/uploads/2020/05/eg70vwjxyama4nr.jpg",
                new ArrayList<Recipe>()));

        categories.add(new Category("Круассаны",
                "https://img5.goodfon.ru/wallpaper/nbig/1/46/tarelka-kruassany-klubnika.jpg",
                new ArrayList<Recipe>()));

        categories.add(new Category("Пироги",
                "https://www.culture.ru/storage/images/ea26d195a606959615d5386995425515/6167397448c42b4dd8fc135c8e0574f4.jpeg",
                new ArrayList<Recipe>()));

        categories.add(new Category("Салаты",
                "https://static.tildacdn.com/tild3063-6535-4562-a534-653531666638/photo_3.jpg",
                new ArrayList<Recipe>()));

        //Создание адаптера списка
        categoriesAdapter = new CategoriesAdapter(getActivity(), categories);
        listView.setAdapter(categoriesAdapter);

        return root;
    }
}