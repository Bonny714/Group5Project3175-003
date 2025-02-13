package com.example.group5project3175_003;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewUser3 extends AppCompatActivity {
    UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences user = getSharedPreferences("user",MODE_PRIVATE);
        setContentView(R.layout.activity_new_user3);
        userDatabase = new UserDatabase(this);
        TextView acName = findViewById(R.id.acName);
        Spinner budgetType = findViewById(R.id.budgettype);

        Button button = findViewById(R.id.btn3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted;


                String sacName = acName.getText().toString();
                String sbudgetType = budgetType.getSelectedItem().toString();
                String fName = user.getString("fName","");
                String lName = user.getString("lName","");
                String email = user.getString("email","");
                String psw = user.getString("psw","");
                String currency = user.getString("currency","");
                String language = user.getString("language","");
                String alarm = user.getString("alarm","");
                String theme = user.getString("theme","");


                isInserted = userDatabase.add(fName,
                            lName,
                            email,
                            psw,
                            currency,
                            language,
                            alarm,
                            theme,
                            sacName,
                            sbudgetType
                );
                    if (isInserted){
                        Toast.makeText(NewUser3.this,"Data added",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(NewUser3.this,"Data not added",Toast.LENGTH_LONG).show();
                    }

            }
        });


    }
}