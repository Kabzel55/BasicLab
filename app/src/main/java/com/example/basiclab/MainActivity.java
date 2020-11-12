package com.example.basiclab;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{
    protected static int activatedFragment = 1;
    protected static Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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
        if (id == R.id.action_1)
        {
            displaySnackbarText(R.string.action_1);
            switch (activatedFragment)
            {
                case 2:
                {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_SecondFragment_to_FirstFragment);
                    break;
                }
                case 3:
                {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_ThirdFragment_to_FirstFragment);
                    break;
                }
            }
        }
        if (id == R.id.action_2)
        {
            displaySnackbarText(R.string.action_2);
            switch (activatedFragment)
            {
                case 1:
                {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_FirstFragment_to_SecondFragment);
                    break;
                }
                case 3:
                {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_ThirdFragment_to_SecondFragment);
                    break;
                }
            }
        }
        if (id == R.id.action_3)
        {
            displaySnackbarText(R.string.action_3);
            switch (activatedFragment)
            {
                case 1:
                {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_FirstFragment_to_ThirdFragment);
                    break;
                }
                case 2:
                {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_SecondFragment_to_ThirdFragment);
                    break;
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }
    public void displaySnackbarText(int stringResource)
    {
        Snackbar.make(findViewById(android.R.id.content), getResources().getString(stringResource), Snackbar.LENGTH_LONG).show();
    }
}