package com.example.lsiems.myrestaurants.util;

/**
 * Created by lsiems on 4/3/16.
 */
public interface ItemTouchHelperAdapter {
  boolean onItemMove(int fromPosition, int toPosition);
  void onItemDismiss(int position);
}
