package com.example.submissionandroidpemula;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.submissionandroidpemula.adapter.FoodAdapter;
import com.example.submissionandroidpemula.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Food> foodList;
    private RecyclerView rvFood;
    private FoodAdapter foodAdapter;

    private Toolbar mTopToolbar;
//    private FoodAdapter.OnItemClickCallback onItemClickCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);

        rvFood = findViewById(R.id.rv_food);
        rvFood.setHasFixedSize(true);
        foodData();

        showRecyclerList();


    }

    private void showSelectedData(Food food) {
        Toast.makeText(this, "Kamu memilih" + food.getTempat(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_person) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList() {
        foodAdapter = new FoodAdapter(this, foodList);

        rvFood.setLayoutManager(new LinearLayoutManager(this));
        rvFood.setAdapter(foodAdapter);


//        foodAdapter.setOnItemClickCallback(new FoodAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(Food data) {
//                    showSelectedData(data);
//            }
//        });
//


    }

    private void foodData() {

        foodList = new ArrayList<>();
        foodList.add(new Food(R.drawable.img_bubur, "Bubur 25, Jakarta", "Makanan Burger Siap saji", "13.2 km"));
        foodList.add(new Food(R.drawable.img_noodle, "Indomie Goreng, Petukangan", "Mi Instan Tanpa pengawet", "2.2 km"));
        foodList.add(new Food(R.drawable.img_soto, "Soto Betawi,Bintaro", "Cepat saji, Soto Madura Asli", "32.2 km"));
        foodList.add(new Food(R.drawable.img_sate, "Sate ayam, Cepat saji", "Sate ayam beraneka rasa", "1.2 km"));
        foodList.add(new Food(R.drawable.img_pizza, "Domino pizza,Bintaro Xchange", "Pizza Domino Murah", "13.2 km"));


        foodList.add(new Food(R.drawable.img_burger, "Burger KING,Bintaro Plaza", "Burger Sayur ", "7.2 km"));
        foodList.add(new Food(R.drawable.img_bakmi, "Bakmi GM,Bintaro Xchange", "Bakmi Ayam Promo Murah", "6.2 km"));
        foodList.add(new Food(R.drawable.img_bakso, "Bakso Podomoro,Petukangan Utara", "Baksi Podomoro Keju", "32.2 km"));
        foodList.add(new Food(R.drawable.img_ketoprak, "Ketoprak Bang Yono,Budi Luhur", "Ketoprak Murah Meriah", "3.2 km"));
        foodList.add(new Food(R.drawable.img_saladbuah, "Salda Buah,Karawang", "Salda Buah Berisi tambahan keju", "5.2 km"));


    }
}
