package com.moringaschool.wallview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.wallview.Constants;
import com.moringaschool.wallview.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @BindView(R.id.FindMoviesButton) Button mFindMoviesButton;
    @BindView(R.id.GenresEdit) EditText mGenresEdit;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

//onclick listener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //butterknife  to bind views
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindMoviesButton.setOnClickListener(this);

    }
//    intent to navigate from mainactivity to moviesactivity on click
            @Override
            public void onClick(View v) {
                if (v == mFindMoviesButton) {
                    String genres = mGenresEdit.getText().toString();
                    if(!(genres).equals("")){
                        addToSharedPreferences(genres);
                    }
                Intent intent = new Intent(MainActivity.this, MoviesListActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_LONG).show();

                startActivity(intent);

    }
}



    private void addToSharedPreferences(String genres){
        mEditor.putString(Constants.PREFERENCES_GENRES_KEY, genres).apply();
    }
}








