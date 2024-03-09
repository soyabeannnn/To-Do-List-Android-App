package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.todolistapp.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {

    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
            setTitle("update");
            binding.editTitle.setText(getIntent().getStringExtra("title"));
            binding.editDesc.setText(getIntent().getStringExtra("desc"));
            int id=getIntent().getIntExtra("id",0);
            binding.add.setText("Update Note");

            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.editTitle.getText().toString());
                    intent.putExtra("desc", binding.editDesc.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        } else {


            setTitle("Add Made");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.editTitle.getText().toString());
                    intent.putExtra("desc", binding.editDesc.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));
    }
}