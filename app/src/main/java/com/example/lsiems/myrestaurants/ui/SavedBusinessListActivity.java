package com.example.lsiems.myrestaurants.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.lsiems.myrestaurants.MyRestaurantsApplication;
import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.adapters.FirebaseBusinessListAdapter;
import com.example.lsiems.myrestaurants.models.Business;
import com.example.lsiems.myrestaurants.util.OnStartDragListener;
import com.example.lsiems.myrestaurants.util.SimpleItemTouchHelperCallback;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedBusinessListActivity extends AppCompatActivity implements OnStartDragListener {
  private Query mQuery;
  private Firebase mFirebaseRef;
  private String mCurrentUserUid;
  private FirebaseBusinessListAdapter mAdapter;
  private ItemTouchHelper mItemTouchHelper;

  @Bind(R.id.recyclerView) RecyclerView mRecyclerView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restaurants);
    ButterKnife.bind(this);

    Firebase.setAndroidContext(this);
    mFirebaseRef = MyRestaurantsApplication.getAppInstance().getFirebaseRef();
    mCurrentUserUid = mFirebaseRef.getAuth().getUid();

    setUpFirebaseQuery();
    setUpRecyclerView();
  }

  private void setUpFirebaseQuery() {
    String location = mFirebaseRef.child("restaurants/" + mCurrentUserUid).toString();
    mQuery = new Firebase(location).orderByChild("index");
  }

  private void setUpRecyclerView() {
    mAdapter = new FirebaseBusinessListAdapter(mQuery, Business.class, this);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mAdapter);
    ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
    mItemTouchHelper = new ItemTouchHelper(callback);
    mItemTouchHelper.attachToRecyclerView(mRecyclerView);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_logout:
        this.logout();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void logout() {
    mFirebaseRef.unauth();
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }

  @Override
  public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
    mItemTouchHelper.startDrag(viewHolder);
  }

  @Override
  protected void onPause() {
    super.onPause();
//    for (Business business : mAdapter.getItems()) {
//      business.setIndex(Integer.toString(mAdapter.getItems().indexOf(business)));
//      mFirebaseRef.child("restaurants/" + mCurrentUserUid + "/"
//              + business.getName())
//              .setValue(business);
//    }
  }
}
