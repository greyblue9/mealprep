package com.example.mealprep;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.Settings;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.internal.ContextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#HomeFragment(Activity)} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public ListView lv;
    public ListAdapter<String, RecyclerView.ViewHolder> adapter;

    public HomeFragment() {

        // Required empty public constructor
        /*lv = ((MainActivity)getBaseContext()).findViewById(R.id.list_view);
        adapter = new ListAdapter<String, RecyclerView.ViewHolder>(new DiffUtil.ItemCallback<String>() {
            @Override
            public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return oldItem == newItem || (oldItem == null && newItem == null) ||
                        (
                                !(oldItem == null && newItem != null) &&
                                !(newItem == null && oldItem != null) &&
                                oldItem.equals(newItem)
                        );
            }

            @Override
            public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return areItemsTheSame(oldItem, newItem);
            }
        }) {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                MenuView.ItemView iv = new MenuView.ItemView() {
                    MenuItemImpl itemData;
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void initialize(MenuItemImpl itemData, int menuType) {
                        this.itemData = itemData;
                        this.itemData.setTitle("Hello world");
                    }

                    @Override
                    public MenuItemImpl getItemData() {
                        return itemData;
                    }

                    @Override
                    public void setTitle(CharSequence title) {

                    }

                    @Override
                    public void setEnabled(boolean enabled) {

                    }

                    @Override
                    public void setCheckable(boolean checkable) {

                    }

                    @Override
                    public void setChecked(boolean checked) {

                    }

                    @Override
                    public void setShortcut(boolean showShortcut, char shortcutKey) {

                    }

                    @Override
                    public void setIcon(Drawable icon) {

                    }

                    @Override
                    public boolean prefersCondensedTitle() {
                        return false;
                    }

                    @Override
                    public boolean showsIcon() {
                        return false;
                    }
                };
                return super.createViewHolder(parent, viewType);
            }

            @Override
            public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {

            }
        };*/
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

}