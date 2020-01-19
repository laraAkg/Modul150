package com.example.modul150.NetworkHelper;

import android.os.AsyncTask;

import com.example.modul150.Model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchData extends AsyncTask<Void, Void, Void> {

    private String data;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("http://10.0.2.2:8080/productList");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            data = data.subSequence(4, data.lastIndexOf("null")).toString();
            Gson gson = new Gson();
            List<Product> products = gson.fromJson(data, new TypeToken<ArrayList<Product>>() {
            }.getType());
            setProductList(products);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> convertStringToJson(String listOfProducts) {
/*        listOfProducts = listOfProducts.substring(1, listOfProducts.length() - 1);
        Gson gson = new Gson();
        List<Product> products = gson.fromJson(listOfProducts, new TypeToken<ArrayList<Product>>() {
        }.getType()); */
        List<Product> products = new ArrayList<>();
        Product product = new Product(1,"Test", "123","fgauhklf", true);
        Product product2 = new Product(1,"Test", "123","fgauhklf", true);
        products.add(product);
        products.add(product2);
        return products;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
