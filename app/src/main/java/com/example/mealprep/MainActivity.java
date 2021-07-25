package com.example.mealprep;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.util.Xml;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenuItemView;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //HomeFragment hf = new HomeFragment(this);
        setContentView(R.layout.activity_main);
        FragmentContainerView fragmentContainerView = findViewById(R.id.fragmentContainerView);

        BottomNavigationView bottomNavigationView = this.findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener((MenuItem item) -> {

            int id = item.getItemId();
            FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
            if (false)
            for (Fragment f: getSupportFragmentManager().getFragments()) {
                tran.remove(f);
            }

            String name = getResources().getResourceEntryName(id);
            String[] pts = name.split("_");
            StringBuilder sb = new StringBuilder();
            for (String pt: pts) {
                sb.append(Character.toUpperCase(pt.charAt(0)));
                sb.append(pt.subSequence(1, pt.length()));
            }
            String name2 = sb.toString();
            String className = this.getClass().getPackage().getName() + "." + name;
            String className2 = this.getClass().getPackage().getName() + "." + name2;
            Class<? extends Fragment> fragClass = null;
            Fragment frag = null;
            try {
                try {
                    fragClass = (Class<? extends Fragment>) Class.forName(className);
                } catch (Throwable t) {
                    fragClass = fragClass != null ? fragClass
                            : (Class<? extends Fragment>) Class.forName(className2);
                }
                if (fragClass.getDeclaredConstructors()[0].getParameterTypes().length == 0) {
                    frag = fragClass.newInstance();
                } else {
                    frag = (Fragment) fragClass.getDeclaredConstructors()[0].newInstance(MainActivity.this);
                }
                tran.add(R.id.fragmentContainerView, frag, name);
                tran.commit();
                fragmentContainerView.removeAllViews();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}