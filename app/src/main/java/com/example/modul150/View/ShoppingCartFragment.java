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

public class ShoppingCartFragment extends Fragment {

    private List<Product> data;
    private List<Product> selectedProducts = new ArrayList<>();
    private ListView listView;
    private Button button;

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shopping_cart, container, false);
        final ProductAdapter adapter = new ProductAdapter(this, getLayoutInflater());
        listView = rootView.findViewById(R.id.listview);
        button = rootView.findViewById(R.id.button_delete);
        data = adapter.getProducts();
        listView.setAdapter(adapter);
        setData(data);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Product model = getData().get(i);

                if (model.isSelected())
                    model.setSelected(false);

                else
                    model.setSelected(true);

                getSelectedProducts().add(getData().set(i, model));

                //now update adapter
                adapter.updateRecords(getData());
            }
        });
        return rootView;
    }

    public void sendData(View view) {
        Gson gson = new Gson();

        String a = gson.toJson("[  {    \"id\": 1,    \"product\": \"test\",    \"price\": \"12\",    \"description\": \"test\"  },  {    \"id\": 2,    \"product\": \"test2\",    \"price\": \"12\",    \"description\": \"test2\"  }]");

        Bundle args = new Bundle();

        args.putString("ARGS", a);
        ShoppingCartFragmentDirections.ShoppingCartToShoppingCartSelection action = ShoppingCartFragmentDirections.shoppingCartToShoppingCartSelection(a);
        Navigation.findNavController(view).navigate(action);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
