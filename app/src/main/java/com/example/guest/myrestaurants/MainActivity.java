package com.example.guest.myrestaurants;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Typeface;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRestaurantButton;
    private EditText mLocationEditText;
    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
            Typeface solo = Typeface.createFromAsset(getAssets(), "fonts/champ2.ttf");
            mAppNameTextView.setTypeface(solo);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindRestaurantButton = (Button) findViewById(R.id.findRestaurantsButton);

        mFindRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
