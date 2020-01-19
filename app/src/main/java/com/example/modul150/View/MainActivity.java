package com.example.modul150.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modul150.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();
        shoppingCartFragment.sendData(view);
    }

    public void delete(View view) {
        ShoppingCartSelectionFragment shoppingCartSelectionFragment = new ShoppingCartSelectionFragment();
        shoppingCartSelectionFragment.remove(view);
    }

    public void showToast(View view) {
        Toast.makeText(getApplicationContext(), "In Progress....", Toast.LENGTH_SHORT).show();

    }
}
