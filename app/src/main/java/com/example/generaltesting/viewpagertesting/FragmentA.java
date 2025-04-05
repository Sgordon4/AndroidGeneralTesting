package com.example.generaltesting.viewpagertesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialFadeThrough;

import java.util.List;
import java.util.Map;

public class FragmentA extends Fragment {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		setExitSharedElementCallback(null);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a, container, false);

		setCallback();

		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


		View A = view.findViewById(R.id.a);
		ViewCompat.setTransitionName(A, "0");

		A.setOnClickListener(v -> {
			FragmentB fragmentB = FragmentB.newInstance(0);

			// Set up shared element transition
			setExitTransition(new MaterialFadeThrough());
			fragmentB.setSharedElementEnterTransition(new MaterialContainerTransform());


			getParentFragmentManager().beginTransaction()
					.setReorderingAllowed(true)
					.addSharedElement(A, "0")
					.replace(R.id.fragmentContainer, fragmentB)
					.addToBackStack(null)
					.commit();


		});



		View B = view.findViewById(R.id.b);
		ViewCompat.setTransitionName(B, "1");


		B.setOnClickListener(v -> {
			FragmentB fragmentB = FragmentB.newInstance(1);

			// Set up shared element transition
			setExitTransition(new MaterialFadeThrough());
			fragmentB.setSharedElementEnterTransition(new MaterialContainerTransform());



			getParentFragmentManager().beginTransaction()
					.setReorderingAllowed(true)
					.addSharedElement(B, "1")
					.replace(R.id.fragmentContainer, fragmentB)
					.addToBackStack(null)
					.commit();

		});

		System.out.println("Created");
	}


	private void setCallback() {
		setExitSharedElementCallback(new SharedElementCallback() {
			@Override
			public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
				if(names.isEmpty()) return;

				View A = getView().findViewById(R.id.a);
				View B = getView().findViewById(R.id.b);

				MainActivity activity = (MainActivity) requireActivity();
				View item = activity.vpPos == 0 ? A : B;

				sharedElements.put(names.get(0), item);
			}
		});
	}
}