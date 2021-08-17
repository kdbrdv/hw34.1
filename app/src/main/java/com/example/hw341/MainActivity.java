package com.example.hw341;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hw341.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btSend.setOnClickListener(v -> {
            sendMessage();
        });
    }

    private void sendMessage() {
        if (binding.edTitle.getText().toString().equals("") || binding.edEmail.getText().toString().equals("")
                || binding.edMessage.getText().toString().equals("")) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }
        else {
            String title= binding.edTitle.getText().toString();
            String message= binding.edMessage.getText().toString();
            Intent email= new Intent(Intent.ACTION_SENDTO);
            email.setData(Uri.parse("mailto:" + binding.edEmail.getText().toString()));
            email.putExtra(Intent.EXTRA_SUBJECT, title);
            email.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(email);
            /*Intent email= new Intent(Intent.ACTION_VIEW);
            email.setType("message/rfc822")
                    .setData(Uri.parse("mailto:" + binding.edEmail.getText().toString()))
                    .putExtra(Intent.EXTRA_EMAIL, "your.email@gmail.com")
                    .putExtra(Intent.EXTRA_SUBJECT, new String[]{title})
                    .putExtra(Intent.EXTRA_TEXT,new String[]{message} )
                    .setPackage("com.google.android.gm");
            startActivity(email);*/

        }
    }


}