package impression11.lesson6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


/* 1

When implmenting "Hamburger Menu" you need to go to the Gradle.build file for the app and
add this line inbetween "Dependencies" braces

compile 'com.android.support:appcompat-v7:22.1.1'

Bare in mind that the version may need to change if you're using a greater version of the SDK
For this example it will already be sorted so there's no need to change anything

 */

public class MainActivity extends ActionBarActivity {

    // 1 Set-up variable to identify the pull out draw
    private DrawerLayout mDrawerLayout;
    // 1 Set-up variable to identify the actionbar button that opens the menu
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 grab the drawer layout
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        // 1 run the setupDrawer method (see below)
        setupDrawer();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        // 2 Grab the tabhost tag and it's contents
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        // 2 identify where we want the fragments to appear
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        // 2 add the fragments to the tabs in the tab host
        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                fragment1.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                fragment2.class, null);


    }

    private void setupDrawer() {

        // 1 this sets up opening and closing the drawer actions this should not need to change between projects

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
