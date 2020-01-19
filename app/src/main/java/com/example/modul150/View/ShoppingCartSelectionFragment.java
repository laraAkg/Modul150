package com.example.modul150.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.modul150.Adapter.ProductAdapter;
import com.example.modul150.Model.Product;
import com.example.modul150.NetworkHelper.FetchData;
import com.example.modul150.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSelectionFragment extends Fragment {

    ListView listView;
    List<Product> liste;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shopping_cart_selection, container, false);
        final ProductAdapter adapter = new ProductAdapter(this, getLayoutInflater());
        listView = rootView.findViewById(R.id.listview_selected);

        String listOfProducts = ShoppingCartSelectionFragmentArgs.fromBundle(getArguments()).getSelectedProducts();
        FetchData fetchData = new FetchData();
        liste = fetchData.convertStringToJson(listOfProducts);
        listView.setAdapter(adapter);


        return rootView;
    }


    public void remove(View view) {
        //remove from List
    }
}
