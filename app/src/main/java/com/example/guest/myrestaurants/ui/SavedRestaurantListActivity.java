package com.example.guest.myrestaurants.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.guest.myrestaurants.Constants;
import com.example.guest.myrestaurants.R;
import com.example.guest.myrestaurants.Adapters.FirebaseRestaurantViewHolder;
import com.example.guest.myrestaurants.models.Restaurant;
import com.example.guest.myrestaurants.Adapters.FirebaseRestaurantListAdapter;
import com.example.guest.myrestaurants.util.OnStartDragListener;
import com.example.guest.myrestaurants.util.SimpleItemTouchHelperCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedRestaurantListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_restaurant_list);
    }
}
