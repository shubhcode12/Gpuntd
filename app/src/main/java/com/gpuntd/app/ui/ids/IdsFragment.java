package com.gpuntd.app.ui.ids;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.gpuntd.app.databinding.FragmentIdsBinding;


public class IdsFragment extends Fragment {

    FragmentIdsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentIdsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 1:
                        binding.rvMyID.setVisibility(View.GONE);
                        binding.rvCreateID.setVisibility(View.VISIBLE);
                        break;

                    default:
                        binding.rvCreateID.setVisibility(View.GONE);
                        binding.rvMyID.setVisibility(View.VISIBLE);
                        break;

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(1));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}