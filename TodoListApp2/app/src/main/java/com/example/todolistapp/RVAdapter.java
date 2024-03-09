package com.example.todolistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapp.databinding.TaskSetBinding;

public class RVAdapter extends ListAdapter<Task,RVAdapter.ViewHolder> {

    public RVAdapter(){
        super(CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Task> CALLBACK=new DiffUtil.ItemCallback<Task>() {
        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())&& oldItem.getDesc().equals(newItem.getDesc());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_set,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task= getItem(position);
        holder.binding.titleTask.setText(task.getTitle());
        holder.binding.taskDesc.setText(task.getDesc());
    }
    public Task getTask(int position){
        return getItem(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TaskSetBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=TaskSetBinding.bind(itemView);
        }
    }
}
