package br.com.tabapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewParent;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.tabapp.fragment.BlankFragment;
import br.com.tabapp.fragment.InUpFragment;
import br.com.tabapp.fragment.InscitionsFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewpagertab);
        viewPager = findViewById(R.id.viewpager);

        getSupportActionBar().setElevation(0);

        //configurar adapter
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", BlankFragment.class)
                        .add("Inscriçõess", InscitionsFragment.class)
                        .add("Em alta", InUpFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}