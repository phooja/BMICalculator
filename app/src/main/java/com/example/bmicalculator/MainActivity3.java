package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView t5=findViewById(R.id.value);
        TextView t6 =findViewById(R.id.inter);
        String t55 =getIntent().getStringExtra("keyn");
        String t66 =getIntent().getStringExtra("keyv");
        t5.setText(t66);
        t6.setText(t55);
        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                t5.setText("");
                t6.setText("");
                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                intent.putExtra("null","");
                intent.putExtra("nulls","");
                startActivity(intent);

            }
        });


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
        AlertDialog obj3 = obj1.create();
        obj3.show();
    }

}