package com.example.lab4_3;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.lab4_3.R.id.tab1;
import static com.example.lab4_3.R.id.tab2;

public class Main2Activity extends AppCompatActivity {
    TabHost tabHost;
    EditText e_height,e_weight,e_area;
    Button b_bmi,b_m2toP,b_Ptom2;
    TextView text_result,text_bmi,text_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("각종 계산기");
        init();



        b_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(e_height.getText().toString()) / 100;
                double weight = Double.parseDouble(e_weight.getText().toString());
                double bmi = weight / height /height ;

                if(bmi <18.5) text_result.setText("체중부족입니다!");
                else if(bmi <23) text_result.setText("정상입니다!");
                else if(bmi <25) text_result.setText("과체중입니다!");
                else if(bmi >=25) text_result.setText("비만입니다!");

                text_bmi.setText("BMI 수치 : "+bmi);


            }
        });



        b_m2toP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double m2_area = Double.parseDouble(e_area.getText().toString());
                double p_area = m2_area / 3.305785 ;

                text_area.setText(p_area+"평");
            }
        });
        b_Ptom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double p_area = Double.parseDouble(e_area.getText().toString());
                double m2_area = p_area * 3.305785 ;
                text_area.setText(m2_area+"제곱미터");
            }
        });


    }


    void init(){
        tabHost = (TabHost)findViewById(R.id.tabhost1);
        e_height =(EditText)findViewById(R.id.edit_height);
        e_weight =(EditText)findViewById(R.id.edit_weight);
        b_bmi = (Button)findViewById(R.id.button_bmi);
        text_result =(TextView)findViewById(R.id.textView_result);
        text_bmi = (TextView)findViewById(R.id.result_bmi);
        e_area =(EditText)findViewById(R.id.editText_area);
        text_area =(TextView)findViewById(R.id.text_area);
        b_m2toP =(Button)findViewById(R.id.button_M2toP);
        b_Ptom2=(Button)findViewById(R.id.button_PtoM2);


        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").setContent(tab1).setIndicator("Bmi 계산기"));
        tabHost.addTab(tabHost.newTabSpec("B").setContent(tab2).setIndicator("면적 계산기"));

    }
}
