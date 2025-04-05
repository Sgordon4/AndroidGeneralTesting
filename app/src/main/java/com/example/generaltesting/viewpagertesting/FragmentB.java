package com.example.generaltesting.viewpagertesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;
import java.util.Map;

public class FragmentB extends Fragment {
	private int currPos;
	private ViewPager2 viewPager;

	public static FragmentB newInstance(int startPos) {
		FragmentB fragment = new FragmentB();
		Bundle args = new Bundle();
		args.putInt("startPos", startPos);
		fragment.setArguments(args);
		return fragment;
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		currPos = getArguments().getInt("startPos");
		((MainActivity) requireActivity()).setPos(currPos);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_b, container, false);

		view.findViewById(R.id.back).setOnClickListener(v -> {
			getParentFragmentManager().popBackStack();
		});




		viewPager = view.findViewById(R.id.viewpager);


		ViewPager2 viewPager = view.findViewById(R.id.viewpager);
		viewPager.setAdapter(new VPAdapter(this, List.of("First", "Second", "Third")));
		viewPager.setCurrentItem(currPos, false);

		postponeEnterTransition();

		viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
			@Override
			public void onPageSelected(int position) {
				currPos = viewPager.getCurrentItem();
				((MainActivity) requireActivity()).setPos(currPos);
			}
		});



		setEnterSharedElementCallback(new SharedElementCallback() {
			@Override
			public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
				if(names.isEmpty()) return;

				ViewPage viewPage = (ViewPage) getChildFragmentManager().findFragmentByTag("f"+currPos);
				View page = viewPage.getView().findViewById(R.id.page_item);

				sharedElements.put(names.get(0), page);
				sharedElements.put(page.getTransitionName(), page);
			}
		});


		return view;
	}
}