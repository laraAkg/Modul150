package com.example.modul150.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.modul150.Adapter.ProductAdapter;
import com.example.modul150.Model.Product;
import com.example.modul150.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


/**
 * Fragment of second View
 *
 * @author Lara Akgün
 * @author Enma Ronquillo
 * @version 20.01.2020
 */
public class ShoppingCartSelectionFragment extends Fragment {

    ListView listView;
    Button buttonSend;
    ProductAdapter adapter;
    List<Product> products;
    TextView empty;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shopping_cart_selection, container, false);
        listView = rootView.findViewById(R.id.listview_selected);
        buttonSend = rootView.findViewById(R.id.button_continue);
        adapter = new ProductAdapter(this, getLayoutInflater());
        empty = rootView.findViewById(R.id.empty);

        //Parsing Received String into Json, from Json to a List of products
        String receivedData = getArguments().getString("selectedProducts");
        Gson gson = new Gson();
        products = gson.fromJson(receivedData, new TypeToken<ArrayList<Product>>() {
        }.getType());

        if (products.size() == 0){
            empty.setVisibility(View.VISIBLE);
            empty.setText("Nothing selected");
        }else {
            listView.setVisibility(View.VISIBLE);
            adapter.getSelectedProducts(products);
            listView.setAdapter(adapter);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Check of the checkboxes
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product model = adapter.products.get(i);

                if (model.isSelected()) {
                    model.setSelected(false);
                    products.remove(model);
                    adapter.updateRecords(adapter.products);

                } else {
                    model.setSelected(true);
                    products.add(model);

                    //updates adapter
                    adapter.updateRecords(adapter.products);
                }
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Coming soon...",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
