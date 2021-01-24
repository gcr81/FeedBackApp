package nc.prog1415;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.List;

import nc.prog1415.adapter.ProductAdapter;
import nc.prog1415.adapter.ProductCategoryAdapter;
import nc.prog1415.model.ProductCategory;
import nc.prog1415.model.Products;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycle, productItemRecycler;
    ProductAdapter productAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1,"Most Popular"));
        productCategoryList.add(new ProductCategory(2,"NearYou"));
        productCategoryList.add(new ProductCategory(3,"Least Favorite"));
        productCategoryList.add(new ProductCategory(4,"UnRated"));

        setProductRecycle(productCategoryList);


        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1,"Domino's Pizza","Domino's Pizza, Inc., branded as Domino's, is an American multinational pizza restaurant chain founded in 1961. The corporation is Delaware domiciled and headquartered at the Domino's Farms Office Park in Ann Arbor, Michigan.", R.drawable.b_burgerking));
        productsList.add(new Products(2,"A&W Restaurants"," A&W Restaurants, Inc. is an American chain of fast-food restaurants distinguished by its burgers, draft root beer and root beer floats.",R.drawable.bt_aww));
        productsList.add(new Products(3,"McDonald's ","McDonald's Corporation is an American fast food company, founded in 1940 as a restaurant operated by Richard and Maurice McDonald, in San Bernardino, California, United States.",R.drawable.mcdonalds));
        productsList.add(new Products(4,"Pizza Pizza"," Pizza Pizza Ltd. is a franchised Canadian pizza quick-service restaurant with its headquarters in Toronto, Ontario. Its restaurants are mainly in the province of Ontario while others are located in Quebec, Nova Scotia, and western Canada",R.drawable.bg_pizzapizza));


        setProductItemRecycler(productsList);

        feedbackButton();


    }

    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    public void feedBackBtn(View v){
        startActivity(new Intent(MainActivity.this,FeedBackData.class));
    }

    public void instaMapBtn(View v){
        startActivity(new Intent(MainActivity.this,instaMap.class));
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_map:
                Toast.makeText(this, "Item map Clicked", Toast.LENGTH_SHORT);

                startActivity(new Intent(MainActivity.this,instaMap.class));
                return true;
            case R.id.nav_feedback:
                Toast.makeText(this, "Item feedback Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,FeedBackData.class));
                return true;
            case R.id.nav_list:
                Toast.makeText(this, "Item list Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,FeedBackData.class));


                return true;
            default:
                return false;
        }
    }


   private  void feedbackButton(){

        Button btnSub = (Button) findViewById(R.id.btnSuuub);
         btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FeedBackData.class));
            }
        });
   }


    private void  setProductRecycle(List<ProductCategory> productCategoryList){

        productCatRecycle = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycle.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this,productCategoryList);
        productCatRecycle.setAdapter(productCategoryAdapter);
    }

    private void  setProductItemRecycler(List<Products> productsList){

        productItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        productItemRecycler.setAdapter(productAdapter);
    }



}