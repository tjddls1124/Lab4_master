package com.example.lab4_3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.lab4_3.R.id.title;
import static com.example.lab4_3.R.id.zoom;

public class MainActivity extends AppCompatActivity {
    LinearLayout L1;
    ImageView image1;
    TextView t1;
    int rotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        L1 = (LinearLayout)findViewById(R.id.Layout1);
        image1 = (ImageView)findViewById(R.id.imageView);
        t1 = (TextView)findViewById(R.id.textView);

        switch (item.getItemId()) {
            case R.id.backblue:
                L1.setBackgroundColor(Color.BLUE); break;
            case R.id.backred:
                L1.setBackgroundColor(Color.RED); break;
            case R.id.backyellow :
                L1.setBackgroundColor(Color.YELLOW); break;
            case R.id.turn30 :{ rotation +=30; image1.setRotation(rotation); break;}
            case R.id.chi:
            { image1.setImageResource(R.drawable.chicken);
                item.setChecked(true);
                t1.setText("겁나 맛있는 치킨"); break; }
            case R.id.spagetti: {
                image1.setImageResource(R.drawable.spaggetti);
                item.setChecked(true);
                t1.setText("새콤한 스파게티");break;
            }
            case R.id.title :
            {
                if ( item.isChecked() == true ) { item.setChecked(false); t1.setVisibility(View.INVISIBLE); }
                else  {item.setChecked(true); t1.setVisibility(View.VISIBLE);}
                break;
            }
            case R.id.zoom : {
                if (item.isChecked() == false) {
                    item.setChecked(true);
                    image1.setScaleX(2);
                    image1.setScaleY(2);
                }
                else {
                    item.setChecked(false);
                    image1.setScaleX(1);
                    image1.setScaleY(1);
                }break;
            }
            case R.id.next :{
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);break;
            }

        }


        return super.onOptionsItemSelected(item);
    }
}
