package nc.prog1415;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nc.prog1415.model.Data_Reference;

public class FeedBackData extends AppCompatActivity {

    EditText namedata,emaildata,messagedata,phoneNumberData;

    Button send, details,btnHome;
    Firebase firebase;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_data);

        namedata = findViewById(R.id.nameData);
        emaildata = findViewById(R.id.emailData);
        messagedata = findViewById(R.id.messageData);
        phoneNumberData = findViewById(R.id.messageData);


        send  = findViewById(R.id.btn_send);
        details  = findViewById(R.id.btn_details);
        Firebase.setAndroidContext(this);

        String UniqueId = Settings.Secure.getString(getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID);



        firebase = new Firebase("https://instafeed-91657-default-rtdb.firebaseio.com/Users"+ UniqueId);

        rootNode =FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                details.setEnabled(true);
                String names = namedata.getText().toString();
                String email = emaildata.getText().toString();
                String message = messagedata.getText().toString();
                String phonenumbers = phoneNumberData.getText().toString();

                Data_Reference feedBackData = new Data_Reference(names,email,message,phonenumbers);

                reference.child(names).setValue(feedBackData);

                //Firebase child_name = firebase.child("Name");
                //child_name.setValue(names);



                if (names.isEmpty()){
                    namedata.setError("This is a required field");
                    send.setEnabled(false);
                }else {
                    namedata.setError(null);
                    send.setEnabled(true);
                }


                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);

                if (names.isEmpty()){
                    emaildata.setError("This is a required field");
                    send.setEnabled(false);
                }else {
                    emaildata.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);
                if (names.isEmpty()){
                    messagedata.setError("This is a required field");
                    send.setEnabled(false);
                }else {
                    messagedata.setError(null);
                    send.setEnabled(true);
                }


                Toast.makeText(FeedBackData.this,"Your Data is send to server",Toast.LENGTH_SHORT).show();

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(FeedBackData.this)
                                .setTitle("Sended Details")
                                .setMessage("Name - "+  names+ "\n \nEmail - " +email +"\n\n Location"+ phonenumbers +"\n\n Message - "+ message )
                                .show();

                    }
                });


            }
        });
        MainActivityView();
    }


    private  void MainActivityView(){

         btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedBackData.this,MainActivity.class));
            }
        });
    }

}