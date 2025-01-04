package com.example.generaltesting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.generaltesting.databinding.FragmentFirstBinding;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("1 OnCreateView");
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Path dataDir = Paths.get(getContext().getFilesDir().getPath());
        File file = new File(dataDir.toString(), "newFile.png");
        File tempFile = new File(file.getParent(), "bbb.png");

        try {
            Files.deleteIfExists(tempFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageView imageView = view.findViewById(R.id.image);
        //Glide.with(imageView).load(tempFile).into(imageView);
        //Glide.with(imageView).load(Uri.fromFile(tempFile)).into(imageView);
        //Glide.with(imageView).load(file).into(imageView);



        binding.buttonFirst.setOnClickListener(view1 ->
                NavHostFragment.findNavController(FirstFragment.this)
				.navigate(R.id.action_FirstFragment_to_SecondFragment));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}