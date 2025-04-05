package com.example.generaltesting;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.Transition;

import com.example.generaltesting.databinding.FragmentFirstBinding;
import com.google.android.material.transition.MaterialContainerTransform;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstFragment extends Fragment {

	private FragmentFirstBinding binding;

	private RecyclerView recyclerView;
	private UUIDAdapter adapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		binding = FragmentFirstBinding.inflate(inflater, container, false);
		return binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


		setEnterTransition(new MaterialContainerTransform());
		setExitTransition(new MaterialContainerTransform());
		setReenterTransition(new MaterialContainerTransform());
		setSharedElementReturnTransition(new MaterialContainerTransform());
		setReturnTransition(new MaterialContainerTransform());
		setSharedElementEnterTransition(new MaterialContainerTransform());
		setSharedElementReturnTransition(new MaterialContainerTransform());



		ImageView imageView = binding.image;
		imageView.setOnClickListener(v -> {
			SecondFragment secondFragment = new SecondFragment();

			Bundle args = new Bundle();
			args.putString("transitionName", "image");
			secondFragment.setArguments(args);

			getParentFragmentManager().beginTransaction()
					.setReorderingAllowed(true)
					.addSharedElement(imageView, "image")
					.replace(R.id.container, secondFragment)
					.addToBackStack(null)
					.commit();
		});

		/*
		recyclerView = view.findViewById(R.id.recyclerview);
		recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
		recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
				startPostponedEnterTransition(); // Resume transition once layout is ready
				return true;
			}
		});


		List<String> uuidList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			uuidList.add(UUID.randomUUID().toString());
		}

		adapter = new UUIDAdapter(uuidList, (imageView, transitionName) -> {

			SecondFragment secondFragment = new SecondFragment();

			Bundle args = new Bundle();
			args.putString("transitionName", transitionName);
			secondFragment.setArguments(args);

			getParentFragmentManager().beginTransaction()
					.setReorderingAllowed(true)
					.addSharedElement(imageView, transitionName)
					.replace(R.id.container, secondFragment)
					.addToBackStack(null)
					.commit();


			FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
					.addSharedElement(imageView, transitionName)
					.build();

			Bundle args = new Bundle();
			args.putString("transitionName", transitionName);

			NavController navController = NavHostFragment.findNavController(this);
			navController.navigate(R.id.SecondFragment, args, null, extras);

		});

		recyclerView.setAdapter(adapter);
		 */

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


	public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		RecyclerView recyclerView = binding.recyclerview;
		recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

		List<UUID> list = IntStream.range(0, 50).mapToObj(i -> UUID.randomUUID()).collect(Collectors.toList());
		recyclerView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
			@NonNull
			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
				LayoutInflater inflater = LayoutInflater.from(parent.getContext());
				View itemView = inflater.inflate(R.layout.rv_grid_item, parent, false);
				return new ViewHolder(itemView);
			}

			@Override
			public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
				View sharedItem = holder.itemView.findViewById(R.id.image);
				ViewCompat.setTransitionName(holder.itemView, String.valueOf(position));

				holder.itemView.setOnClickListener(view1 -> {
					NavController navController = NavHostFragment.findNavController(FirstFragment.this);

					FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
							.addSharedElement(holder.itemView, holder.itemView.getTransitionName())
							.build();

					navController.navigate(R.id.action_FirstFragment_to_SecondFragment, null, null, extras);
				});
			}

			@Override
			public int getItemCount() {
				return list.size();
			}

			class ViewHolder extends RecyclerView.ViewHolder {
				public ViewHolder(@NonNull View itemView) {
					super(itemView);
				}
			}
		});
		if(savedInstanceState != null) {
			Parcelable rvState = savedInstanceState.getParcelable("rvState");

			if(rvState != null) {
				System.out.println("Parcel found: "+rvState);
				recyclerView.getLayoutManager().onRestoreInstanceState(rvState);
			}
		}



		binding.buttonFirst.setOnClickListener(view1 ->
				NavHostFragment.findNavController(FirstFragment.this)
				.navigate(R.id.action_FirstFragment_to_SecondFragment));
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		Parcelable rvState = binding.recyclerview.getLayoutManager().onSaveInstanceState();
		outState.putParcelable("rvState", rvState);

		super.onSaveInstanceState(outState);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	 */
}