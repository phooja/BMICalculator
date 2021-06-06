package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

public class MainActivity2 extends AppCompatActivity {
    public float bmi(float weight,float height) {
        return weight / (height * height);
    }
    public String intrepet (float bmi) {
        if (bmi <18.5) {
            return "UNDER WEIGHT";
        }
        else   if (bmi >= 18 && bmi<25) {
            return "NORMAL WEIGHT";
        } else if (bmi >= 25&& bmi<30.0) {
            return "OVER WEIGHT";
        } else if(bmi>=30){
            return "OBESE";}
        return "bmi";


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText t1= findViewById(R.id.etxt);
        EditText t2=findViewById(R.id.etxt1);

        Button btn = findViewById(R.id.btn);

        Button btn1=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t11,t12;
                t11=t1.getText().toString();
                t12=t2.getText().toString();
                float weight=Float.parseFloat(t11);
                float height=Float.parseFloat(t12)/100;

                if(t11.isEmpty()||t12.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ENTER ALL FEILDS ",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Your BMI",Toast.LENGTH_SHORT).show();
                }


                float bmi=bmi(weight,height);
                Intent i= new Intent(MainActivity2.this,MainActivity3.class);
                i.putExtra("keyn",intrepet(bmi));
                i.putExtra("keyv",""+bmi);
                startActivity(i);

            }
        });
        String t555 =getIntent().getStringExtra("null");
        String t666 =getIntent().getStringExtra("nulls");
        t1.setText(t555);
        t2.setText(t666);
    }
    public void onBackPressed() {

        AlertDialog.Builder obj1 = new AlertDialog.Builder(this);
        obj1.setTitle("EXIT");
        obj1.setMessage("DO YOU WANT TO EXIT");
        obj1.setCancelable(false);
        obj1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        obj1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog obj22 = obj1.create();
        obj22.show();
    }

}