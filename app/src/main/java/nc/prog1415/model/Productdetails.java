package nc.prog1415.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nc.prog1415.FeedBackData;
import nc.prog1415.MainActivity;
import nc.prog1415.R;

public class Productdetails extends AppCompatActivity {

    Button btnFeedBackm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_productdetails);
        ChangeToFeedBack();
        MainViewButton();
        MainView();
    }



    private  void ChangeToFeedBack(){

        btnFeedBackm = (Button) findViewById(R.id.btnMcDonaldSubmit);
        btnFeedBackm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Productdetails.this, FeedBackData.class));
            }
        });
    }

    private  void  MainView(){

        Button btnBackTop = (Button) findViewById(R.id.btnBackTop);
        btnBackTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Productdetails.this,MainActivity.class));
            }
        });
    }


    private  void  MainViewButton(){

        Button btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Productdetails.this,MainActivity.class));
            }
        });
    }

}