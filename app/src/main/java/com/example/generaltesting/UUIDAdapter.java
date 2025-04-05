package com.example.generaltesting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UUIDAdapter extends RecyclerView.Adapter<UUIDAdapter.ViewHolder> {

	private final List<String> data;
	private final OnItemClickListener listener;

	public interface OnItemClickListener {
		void onItemClick(ImageView imageView, String transitionName);
	}

	public UUIDAdapter(List<String> data, OnItemClickListener listener) {
		this.data = data;
		this.listener = listener;
		setHasStableIds(true);  // Critical for smooth transition return!
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_grid_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		String transitionName = "image";
		holder.imageView.setTransitionName(transitionName);

		holder.imageView.setOnClickListener(v -> listener.onItemClick(holder.imageView, transitionName));
	}

	@Override
	public long getItemId(int position) {
		return data.get(position).hashCode();
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		ImageView imageView;
		public ViewHolder(View itemView) {
			super(itemView);
			imageView = itemView.findViewById(R.id.image);
		}
	}
}
