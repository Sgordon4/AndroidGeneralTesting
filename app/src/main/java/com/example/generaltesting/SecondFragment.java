package com.example.generaltesting;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.generaltesting.databinding.FragmentSecondBinding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondFragment extends Fragment {

	private FragmentSecondBinding binding;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		System.out.println("2 OnCreateView");
		binding = FragmentSecondBinding.inflate(inflater, container, false);
		return binding.getRoot();
	}

	public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
		System.out.println("Inside second, counter is "+viewModel.testInt);



		List<Integer> list = IntStream.range(0, 50).boxed().collect(Collectors.toList());
		ListView listView = binding.listviewSecond;
		listView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list));


		if(savedInstanceState != null) {
			Parcelable listState = savedInstanceState.getParcelable("listState");

			if(listState != null) {
				System.out.println("Parcel found: "+listState);
				listView.onRestoreInstanceState(listState);
			}
		}




		binding.buttonSecond.setOnClickListener(view1 ->
				NavHostFragment.findNavController(SecondFragment.this)
				.navigate(R.id.action_SecondFragment_to_FirstFragment));
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		Parcelable listState = binding.listviewSecond.onSaveInstanceState();
		outState.putParcelable("listState", listState);

		super.onSaveInstanceState(outState);
	}
}