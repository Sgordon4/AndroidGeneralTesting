package com.example.generaltesting;

import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.generaltesting.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

	private AppBarConfiguration appBarConfiguration;
	private ActivityMainBinding binding;

	private MainViewModel viewModel;

	int vpPos = 0;
	public void setPos(int pos) {
		System.out.println("Setting position to "+pos);
		vpPos = pos;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		viewModel = new ViewModelProvider(this).get(MainViewModel.class);
		viewModel.testInt += 1;



		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());


		/*
		// Add FragmentA to the FragmentContainerView
		FragmentA fragmentA = new FragmentA();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragmentContainer, fragmentA)
				.commit();
		 */

		/*
		NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
				.findFragmentById(R.id.nav_host_fragment);
		NavController navController = navHostFragment.getNavController();
		NavigationUI.setupActionBarWithNavController(this, navController);

		 */
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		return NavigationUI.navigateUp(navController, appBarConfiguration)
				|| super.onSupportNavigateUp();
	}


	//---------------------------------------------------------------------------------------------


	@Override
	public void onConfigurationChanged(@NonNull Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		System.out.println("OnConfigurationChanged");
	}

	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("OnStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("OnResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("OnPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("OnStop");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		System.out.println("OnRestart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("OnDestroy");
	}
	 */
}