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
import androidx.navigation.Navigator;

import com.example.modul150.Adapter.ProductAdapter;
import com.example.modul150.Model.Product;
import com.example.modul150.NetworkHelper.FetchData;
import com.example.modul150.R;

import java.util.List;

public class ShoppingCartFragment extends Fragment {

    List<Product> data;
    List<Product> selectedProducts;
    ListView listView;
    Button button;


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
        button = rootView.findViewById(R.id.button);
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
                selectedProducts.add(getData().set(i, model));
                getData().set(i, model);

                //now update adapter
                adapter.updateRecords(getData());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();

                String[] array = new String[selectedProducts.size()];
                int index = 0;
                for (Object value : selectedProducts) {
                    array[index] = (String) value;
                    index++;
                }


                args.putStringArray("ARGS", array);
                ShoppingCartFragmentDirections.ShoppingCartToShoppingCartSelection action = ShoppingCartFragmentDirections.shoppingCartToShoppingCartSelection(array);
                Navigation.findNavController(view).navigate(action);
            }
        });
        return rootView;
    }
}
