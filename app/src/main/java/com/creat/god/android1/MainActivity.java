package com.creat.god.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private Button btnOrder, nextEdit, btnCalendar;
    private TextView allSum, analis;
    private Switch switchPrase;
    private CheckBox chechBox;
    private boolean switchBooleanPrase;
    private boolean canPauOrNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        btnAct();
    }

    private void btnAct() {

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calendar.class);
                startActivity(intent);
            }
        });

        nextEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextEdits.class);
                startActivity(intent);
            }
        });

        switchPrase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)  {
                    switchBooleanPrase = true;
                } else {
                    switchBooleanPrase = false;
                }
            }
        });

        chechBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    canPauOrNo = true;
                } else {
                    canPauOrNo = false;
                }
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (canPauOrNo == false)
                    Toast.makeText(MainActivity.this, "Нужно согласиться с ценой!", Toast.LENGTH_SHORT).show();
                else {
                    if (switchBooleanPrase == true){
                        allSum.setText("к оплате 0");
                        analis.setText("Анализы: 0");
                    } else {
                        allSum.setText("к оплате 0");
                    }
                    Toast.makeText(MainActivity.this, "Оплата произведена", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initialization() {
        btnOrder = findViewById(R.id.btnOrder);
        nextEdit = findViewById(R.id.nextEdit);
        analis = findViewById(R.id.analis);
        allSum = findViewById(R.id.allSum);
        switchPrase = findViewById(R.id.switchPrase);
        chechBox = findViewById(R.id.chechBox);
        btnCalendar = findViewById(R.id.btnCalendar);
    }
}