package com.example.modul150.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.modul150.Model.Product;
import com.example.modul150.NetworkHelper.FetchData;
import com.example.modul150.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Fragment fragment;
    List<Product> products;
    LayoutInflater inflater;

    public ProductAdapter(Fragment fragment, LayoutInflater inflater) {
        this.fragment = fragment;
        this.inflater = inflater;
    }

    public List<Product> getProducts() {
        final FetchData process = new FetchData();
        process.execute();
        products = process.getProductList();
        return products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {

            view = inflater.inflate(R.layout.list_view_item, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = view.findViewById(R.id.product);
            holder.price = view.findViewById(R.id.price);
            holder.description = view.findViewById(R.id.description);
            holder.ivCheckBox = view.findViewById(R.id.iv_check_box);

            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        Product model = products.get(i);

        holder.tvUserName.setText(model.getproduct());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getdescription());


        if (model.isSelected())
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);

        else
            holder.ivCheckBox.setBackgroundResource(R.drawable.check);

        return view;

    }

    public void updateRecords(List<Product> products) {
        this.products = products;

        notifyDataSetChanged();
    }

    class ViewHolder {

        TextView tvUserName;
        TextView price;
        TextView description;
        ImageView ivCheckBox;

    }
}
