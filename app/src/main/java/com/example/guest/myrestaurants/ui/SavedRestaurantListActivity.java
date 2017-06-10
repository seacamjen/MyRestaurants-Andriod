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

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedRestaurantListActivity extends AppCompatActivity implements OnStartDragListener {
    private DatabaseReference mRestaurantReference;
    private FirebaseRestaurantListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mRestaurantReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RESTAURANTS)
                .child(uid);

        mFirebaseAdapter = new FirebaseRestaurantListAdapter(Restaurant.class,
                R.layout.restaurant_list_item_drag, FirebaseRestaurantViewHolder.class,
                mRestaurantReference, this, this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
