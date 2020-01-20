package com.example.modul150.NetworkHelper;

import android.os.AsyncTask;

import com.example.modul150.Adapter.ProductAdapter;
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
/**
 * Gets Data from API Call
 *
 * @author Lara Akgün
 * @author Enma Ronquillo
 * @version 20.01.2020
 */
public class FetchData extends AsyncTask<Void, Void, List<Product>> {

    private String data;
    private ProductAdapter productAdapter;

    public FetchData(ProductAdapter productAdapter) {
        this.productAdapter = productAdapter;
    }

    public void setProductList(List<Product> productList) {
        this.productAdapter.updateRecords(productList);
    }

    //Gets the Json from API call
    //Converts Json into List<Products>
    @Override
    protected List<Product> doInBackground(Void... voids) {

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

            return products;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(List<Product> products) {
        super.onPostExecute(products);
        setProductList(products);
    }
}
