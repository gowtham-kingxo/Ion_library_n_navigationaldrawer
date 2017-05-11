package com.example.gowthamg.ion_library_n_navigationaldrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.concurrent.ExecutionException;

public class Main2Activity extends AppCompatActivity {
    String html="";
    //String s =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button bt = (Button) findViewById(R.id.btn);

          bt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  try {
                      Ion.with(Main2Activity.this)
                              .load("https://kart.la/search-results/?gmw_keywords&gmw_address%5B0%5D=Nanganallur%2C%20Chennai%2C%20Tamil%20Nadu&gmw_post=post&tax_category%5B0%5D=235&gmw_distance=3&gmw_units=metric&gmw_form=2&gmw_per_page=10&gmw_lat=12.9753604&gmw_lng=80.19012190000001&gmw_px=pt&action=gmw_post")
                              .asString().setCallback(new FutureCallback<String>() {
                          @Override
                          public void onCompleted(Exception e, String result) {
                              html = result;
                              Log.d("Html code",html);

                          }
                      }).get();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } catch (ExecutionException e) {
                      e.printStackTrace();
                  }

                  if( html.indexOf("<!-- Title -->") != -1)
              {
                  Toast.makeText(Main2Activity.this, "yaa its there", Toast.LENGTH_SHORT).show();
              }
                else
              {
                  Toast.makeText(Main2Activity.this, "yaa its null", Toast.LENGTH_SHORT).show();
              }

              }
          });

    }
}
