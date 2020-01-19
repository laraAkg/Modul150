package com.example.modul150.Controller;

import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.ListAdapter;

import com.example.modul150.Adapter.ProductAdapter;
import com.example.modul150.DAO.ProductDAO;
import com.example.modul150.Model.Product;
import com.example.modul150.NetworkHelper.FetchData;
import com.example.modul150.View.ShoppingCartFragment;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    List<Product> products = getAllProduct();

    @Override
    public List<Product> getAllProduct() {
        FetchData process = new FetchData();
        return process.getProductList();
    }
    @Override
    public List<Product> setAllProduct() {
        return null;
    }
}
