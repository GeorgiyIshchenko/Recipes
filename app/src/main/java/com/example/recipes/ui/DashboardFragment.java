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

import com.example.recipes.R;
import com.example.recipes.Recipe;
import com.example.recipes.RecipeVideoAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private ListView listView;
    private RecipeVideoAdapter recipeVideoAdapter;
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        listView = root.findViewById(R.id.lv_recipe);

        recipes.add(new Recipe("Осетинский пирог",
                "Осетинские пироги очень вкусные", null,
                "https://r7---sn-uvu-c33ez.googlevideo.com/videoplayback?expire=1616530437&ei=pfdZYMqnBJPF7ATu8qeQCg&ip=118.174.209.176&id=o-AMkDqUhWgjYA0a_sUMiHEHfFuROtb8OHXcrk8WoLTKrn&itag=22&source=youtube&requiressl=yes&mh=Xd&mm=31%2C26&mn=sn-uvu-c33ez%2Csn-npoe7ney&ms=au%2Conr&mv=m&mvi=7&pl=24&initcwndbps=785000&vprv=1&mime=video%2Fmp4&ns=rF6u3cmYFS2MfrQJaKNl2NMF&cnr=14&ratebypass=yes&dur=370.869&lmt=1496755189719903&mt=1616508524&fvip=1&fexp=24001374%2C24007246&c=WEB&n=qid1RHhjGDy7DA5bXR&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgJ43BTE-E86nuhP4UFH9ZAOesIgnei586X5Vl24jcdacCIQCsZ5mtAej9eEjmoojPAFrWFK54Y5y1QRT_xmH4UUHDLw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRgIhAM7LQc74QOJISVrnve3ELYEyZtJux_WSS7X9ECEbKaZ5AiEAraziGbs1HMCt54uWwuTpUmT9GGPnYHl0EBZKb-zIApI%3D&title=%D0%9E%D1%81%D0%B5%D1%82%D0%B8%D0%BD%D1%81%D0%BA%D0%B8%D0%B9%20%D0%BF%D0%B8%D1%80%D0%BE%D0%B3%20%D1%81%20%D0%BC%D1%8F%D1%81%D0%BE%D0%BC%2FOssetian%20meat%20pie"));

        recipes.add(new Recipe("Доширак как на упаковке",
                "От игоря линка", null,
                "https://r5---sn-nv47lnsk.googlevideo.com/videoplayback?expire=1616528122&ei=me5ZYN7FPIeJv_IPh6akmAs&ip=94.55.49.205&id=o-AAVSpCJQeB5HWsHWhyjEMU4SE2DhUIyWGog4scvan5bx&itag=22&source=youtube&requiressl=yes&mh=1y&mm=31%2C26&mn=sn-nv47lnsk%2Csn-4g5ednsr&ms=au%2Conr&mv=m&mvi=5&pl=24&initcwndbps=866250&vprv=1&mime=video%2Fmp4&ns=h6oPNQZV-qwIJfVn-ATem3IF&cnr=14&ratebypass=yes&dur=1189.535&lmt=1615746923888959&mt=1616506369&fvip=5&fexp=24001373%2C24007246&c=WEB&txp=5535432&n=Dg67Mx8_eqgPqvpsbk&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgWQ3Y6vM7geDGka0HXaHx6FFX7oxFrXYzCi4uQzZk4CMCIB_oMwF-9efsjyMWVZodvXBBE_zM4VkaSNwIsIPGku6i&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgPsKXQuIMFp-jnDZv6bxWaEzb8VX88fCa91USbseQ6OUCIQDboYY3GHfEfpJiZWocE6NYcvYWX7zqBWegxTbEA_YFig%3D%3D&title=%D0%93%D0%9E%D0%A2%D0%9E%D0%92%D0%9B%D0%AE%20%D0%94%D0%9E%D0%A8%D0%98%D0%9A%2C%20%D0%9A%D0%90%D0%9A%20%D0%9D%D0%90%20%D0%A3%D0%9F%D0%90%D0%9A%D0%9E%D0%92%D0%9A%D0%95"));

        recipes.add(new Recipe("Свиная башка",
                "Выглядит аппетитно!", null,
                "https://r3---sn-w5nuxa-33jd.googlevideo.com/videoplayback?expire=1616531004&ei=3PlZYJOWAdrf7QTF3IagDg&ip=180.183.67.151&id=o-AEKjxiRTlnpLErpquqrGwuvzqZy4bQIm3H8uwRFEN8jz&itag=22&source=youtube&requiressl=yes&mh=ai&mm=31%2C29&mn=sn-w5nuxa-33jd%2Csn-w5nuxa-c33ll&ms=au%2Crdu&mv=m&mvi=3&pl=21&initcwndbps=1040000&vprv=1&mime=video%2Fmp4&ns=z9FQu4izePe2reUnJsUv2AkF&ratebypass=yes&dur=93.158&lmt=1610104409922272&mt=1616509248&fvip=3&fexp=24001373%2C24007246&c=WEB&txp=6216222&n=a39ituglWL_kh098Hz&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgI0hK2VvEz9SLE_leNWkSIFEzwjyzyZQzcN4N7P_WtlcCIQCSY83a_HlU1UJNlFpG1vjkiGuQkrjISSfPlzSCzNsAEg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgeso2H7bFSR4IN_ASOpzRfjIcVafo3Le8uVRMyEWfc3kCIQDtQAzh4CspSOSNGK8nZUgFnYP3m9eYGrVvfR2KuMkuGg%3D%3D&title=%D1%80%D0%B5%D1%86%D0%B5%D0%BF%D1%82%20%D1%81%D0%B2%D0%B8%D0%BD%D0%B0%D1%8F%20%D0%B1%D0%B0%D1%88%D0%BA%D0%B0%20Azazin%20Kreet"));

        recipeVideoAdapter = new RecipeVideoAdapter(getActivity(), recipes);
        listView.setAdapter(recipeVideoAdapter);

        return root;
    }
}