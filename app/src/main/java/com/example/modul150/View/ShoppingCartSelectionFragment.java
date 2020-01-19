package com.example.modul150.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.modul150.Adapter.ProductAdapter;
import com.example.modul150.Model.Product;
import com.example.modul150.NetworkHelper.FetchData;
import com.example.modul150.R;

public class ShoppingCartSelectionFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shopping_cart_selection, container, false);

       // Bundle args = getArguments();
      //  String list = args.getLong(ShoppingCartFragment.);

     //   final ProductAdapter adapter = new ProductAdapter(this, , getLayoutInflater());

        return rootView;
    }
}
