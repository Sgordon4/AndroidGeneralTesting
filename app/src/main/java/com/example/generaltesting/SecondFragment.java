package com.example.generaltesting;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;

import com.example.generaltesting.databinding.FragmentSecondBinding;
import com.google.android.material.transition.MaterialContainerTransform;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondFragment extends Fragment {

	private FragmentSecondBinding binding;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSharedElementEnterTransition(new MaterialContainerTransform());
		setSharedElementReturnTransition(new MaterialContainerTransform());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_second, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ImageView imageView = view.findViewById(R.id.image);
		String transitionName = getArguments() != null ? getArguments().getString("transitionName") : "";
		imageView.setTransitionName(transitionName);
	}


	/*
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Transition transition = new MaterialContainerTransform();
		transition.setDuration(600);

		setSharedElementEnterTransition(transition);
		setSharedElementReturnTransition(transition);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		binding = FragmentSecondBinding.inflate(inflater, container, false);
		ImageView imageView = binding.image;
		imageView.setTransitionName("12");

		return binding.getRoot();
	}

	public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
		System.out.println("Inside second, counter is "+viewModel.testInt);



		binding.buttonSecond.setOnClickListener(view1 -> {
			NavController navController = NavHostFragment.findNavController(SecondFragment.this);
			ImageView imageView = binding.image;
			FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
					.addSharedElement(imageView, imageView.getTransitionName())
					.build();

			navController.navigate(R.id.action_SecondFragment_to_FirstFragment, null, null, extras);
		});
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
	 */
}