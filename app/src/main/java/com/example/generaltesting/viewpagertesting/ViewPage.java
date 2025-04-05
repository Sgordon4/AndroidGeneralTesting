package com.example.generaltesting.viewpagertesting;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

public class ViewPage extends Fragment {
	private String item;
	private int pos;


	public static ViewPage newInstance(String item, int pos) {
		ViewPage fragment = new ViewPage();
		Bundle args = new Bundle();
		args.putString("item", item);
		args.putInt("pos", pos);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		item = getArguments().getString("item");
		pos = getArguments().getInt("pos");
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.viewpage, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		View pageItem = view.findViewById(R.id.page_item);
		ViewCompat.setTransitionName(pageItem, String.valueOf(pos));


		switch (pos) {
			case 0:
				pageItem.setBackgroundColor(Color.RED);
				break;
			case 1:
				pageItem.setBackgroundColor(Color.GREEN);
				break;
			case 2:
				pageItem.setBackgroundColor(Color.BLUE);
				break;
		}

		requireParentFragment().startPostponedEnterTransition();
	}
}
