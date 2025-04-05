package com.example.generaltesting.viewpagertesting;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class VPAdapter extends FragmentStateAdapter {
	private final List<String> items;

	public VPAdapter(@NonNull Fragment fragment, List<String> items) {
		super(fragment);
		this.items = items;
	}

	@NonNull
	@Override
	public Fragment createFragment(int position) {
		return ViewPage.newInstance(items.get(position), position);
	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
