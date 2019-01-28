package com.onboarding.ecomm.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.onboarding.ecomm.CartActivity;
import com.onboarding.ecomm.Fragment.ElectronicsFragment;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Login.LoginPage;
import com.onboarding.ecomm.Model.Response.CartResponse;
import com.onboarding.ecomm.Model.Response.Category;
import com.onboarding.ecomm.PrefManager;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.Search.SearchResultActivity;
import com.onboarding.ecomm.session.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String tokenId = null;
    public static int notificationCountCart = 0;
    List<CartResponse> cartResponses = new ArrayList<>();
    private RecyclerView recyclerView;
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FloatingActionButton floatingActionButton;
    private CardView cardView;
    private IApiClass iApiClass;
    private IApiClass iApiClass2;
    //private SessionManager session;
    private boolean doubleBackToExitPressedOnce;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("LELO.COM");
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        floatingActionButton = findViewById(R.id.fab);

        SessionManager sessionManager = new SessionManager(this);
        if (!sessionManager.isLoggedIn()) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LoginPage.class);
                    startActivity(intent);
                }
            });
        } else {
            floatingActionButton.setClickable(false);
        }


        iApiClass = AppController.retrofitProduct.create(IApiClass.class);

        iApiClass2 = AppController.retrofitOrderItem.create(IApiClass.class);
        tokenId = sessionManager.getUserDetails().get("CustomerId");
        //Log.e("token", tokenId);
        iApiClass2.getCartItems(tokenId).enqueue(new Callback<List<CartResponse>>() {
            @Override
            public void onResponse(Call<List<CartResponse>> call, Response<List<CartResponse>> response) {
                cartResponses = response.body();
//                Log.e("REsponse",cartResponses.toString());
//                for(CartResponse cartResponse:cartResponses){
//                    AppController.quantityInCart+=cartResponse.getQuantity();

            }


            @Override
            public void onFailure(Call<List<CartResponse>> call, Throwable t) {

            }
        });


        //session = new SessionManager(getApplicationContext());
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        //session.checkLogin();

        //HashMap<String, String> user = session.getUserDetails();

        //String customerId = user.get(SessionManager.CUSTOMER_ID);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);


        iApiClass.getAllCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    setupViewPager(viewPager, response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }

        });
        if (viewPager != null) {
            tabLayout.setupWithViewPager(viewPager);
        }

        Menu NavMenu=navigationView.getMenu();
        if(sessionManager.isLoggedIn()){
            NavMenu.findItem(R.id.logout).setVisible(true);
        }
        else{
            NavMenu.findItem(R.id.logout).setVisible(false);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce = true) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            startActivity(new Intent(MainActivity.this, SearchResultActivity.class));
            return true;
        } else if (id == R.id.action_cart) {
            SessionManager sessionManager = new SessionManager(this);
            if (sessionManager.isLoggedIn()) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                intent.putExtra("CustomerId", tokenId);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
                Toast.makeText(this,"Login before accessing orders",Toast.LENGTH_SHORT).show();
            }
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        SessionManager sessionManager = new SessionManager(this);
        if (itemId == R.id.my_orders) {
            if (sessionManager.isLoggedIn()) {
                Intent intent = new Intent(MainActivity.this, OrderPageActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
                Toast.makeText(this,"Login before accessing orders",Toast.LENGTH_SHORT).show();
            }
        } else if (itemId == R.id.my_cart) {
            //session.logoutUser();
            if (sessionManager.isLoggedIn()) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                intent.putExtra("CustomerId", tokenId);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
                Toast.makeText(this,"Login before accessing orders",Toast.LENGTH_SHORT).show();
            }
        }
        else if(itemId==R.id.logout){
            if(sessionManager.isLoggedIn()){
                sessionManager.logoutUser(this);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this,"Logged Out!",Toast.LENGTH_SHORT).show();


            }
        } else if (itemId == R.id.logout) {
            sessionManager.logoutUser(this);
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void setupViewPager(ViewPager viewPager, List<Category> categoryList) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (int i = 0; i < categoryList.size(); i++) {
            adapter.addFragment(ElectronicsFragment.getElectronicsFragmentInstance(categoryList.get(i).getCategoryId()), categoryList.get(i).getName());
        }
        viewPager.setAdapter(adapter);

    }

}

class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}

