package com.example.modul150.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.modul150.Adapter.ProductAdapter;
import com.example.modul150.Model.Product;
import com.example.modul150.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment of first view
 *
 * @author Lara Akgün
 * @author Enma Ronquillo
 * @version 20.01.2020
 */
public class ShoppingCartFragment extends Fragment {

    private List<Product> selectedProducts = new ArrayList<>();
    private ListView listView;
    private Button button;
    ProductAdapter adapter;

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shopping_cart, container, false);
        adapter = new ProductAdapter(this, getLayoutInflater());
        listView = rootView.findViewById(R.id.listview);
        button = rootView.findViewById(R.id.button_delete);

        //Sets products in List
        adapter.getProducts();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Product model = adapter.products.get(i);

                if (model.isSelected()) {
                    model.setSelected(false);
                    getSelectedProducts().remove(model);
                    adapter.updateRecords(adapter.products);

                } else {
                    model.setSelected(true);
                    getSelectedProducts().add(model);

                    //now update adapter
                    adapter.updateRecords(adapter.products);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Convert List into array, convert array into String
        //Give String in navigation
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product[] array = getSelectedProducts().toArray(new Product[getSelectedProducts().size()]);
                Gson gson = new Gson();
                String json = gson.toJson(array);
                Bundle bundle = new Bundle();
                bundle.putString("selectedProducts", json);
                Navigation.findNavController(view).navigate(R.id.shopping_cart_to_shopping_cart_selection, bundle);
            }
        });
    }
}
