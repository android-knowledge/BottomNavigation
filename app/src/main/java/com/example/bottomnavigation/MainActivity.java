package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.bottomnavigation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

       binding.bottomNavigationView.setOnItemSelectedListener(item -> {

           switch (item.getItemId()) {
               case R.id.home:
                   replaceFragment(new HomeFragment());
                   break;

               case R.id.shorts:
                   replaceFragment(new ShortsFragment());
                   break;

               case R.id.subscriptions:
                   replaceFragment(new SubscriptionFragment());
                   break;

               case R.id.library:
                   replaceFragment(new LibraryFragment());
                   break;
           }

           return true;

       });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}