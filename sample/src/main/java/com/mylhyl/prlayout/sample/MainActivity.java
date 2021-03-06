package com.mylhyl.prlayout.sample;

import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mylhyl.prlayout.sample.app.DemoSwipeRefreshExpandableListFragment;
import com.mylhyl.prlayout.sample.app.DemoSwipeRefreshListFragment;
import com.mylhyl.prlayout.sample.app.GridViewXmlFragment;
import com.mylhyl.prlayout.sample.app.ListViewXmlFragment;
import com.mylhyl.prlayout.sample.app.RecyclerViewXmlFragment;

public class MainActivity extends AppCompatActivity implements TypesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, TypesFragment.newInstance())
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Fragment fragment = null;
        int typeId = (int) ContentUris.parseId(uri);
        switch (typeId) {
            case 0:
                fragment = ListViewXmlFragment.newInstance();
                break;
            case 1:
                fragment = DemoSwipeRefreshListFragment.newInstance();
                break;
            case 2:
                fragment = DemoSwipeRefreshExpandableListFragment.newInstance();
                break;
            case 3:
                fragment = GridViewXmlFragment.newInstance();
                break;
            case 4:
                fragment = RecyclerViewXmlFragment.newInstance();
                break;
        }
        if (fragment != null)
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, fragment)
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
    }
}
