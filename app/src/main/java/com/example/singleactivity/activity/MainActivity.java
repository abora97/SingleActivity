package com.example.singleactivity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.singleactivity.R;
import com.example.singleactivity.fragment.FirstFragment;
import com.example.singleactivity.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = findViewById(R.id.btnGo);
        openFragment(new FirstFragment(),"test");
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new SecondFragment(),"test");

            }
        });
    }

    private void openFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
               // .remove(fragment)
                .replace(R.id.nav_host_fragment, fragment, tag)
                  // .add(R.id.nav_host_fragment,fragment, tag)
               .addToBackStack(null)
                .commit();
    }
}