package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import io.reactivex.rxjava3.core.Flowable;

public class Bbi extends AppCompatActivity {

    EditText tinggiBadan;
    TextView bbi;
    private TextView Bbilama;
    private RadioButton pria, wanita;
    private RxDataStore<Preferences> dataStore;
    private Preferences.Key<String> KEY_NAME = PreferencesKeys.stringKey("name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bbi);
        pria=findViewById(R.id.pria);
        wanita=findViewById(R.id.wanita);
        tinggiBadan=findViewById(R.id.tinggibadan);
        bbi=findViewById(R.id.bbi);
        Bbilama = findViewById(R.id.bbilama);
        Button proses = findViewById(R.id.button1);
        proses.setOnClickListener(this::onClick);

        dataStore = new RxPreferenceDataStoreBuilder(getApplicationContext(), "profile").build();
        Flowable<String> flowable = dataStore.data().map(preferences ->{
            String name = "-";
            if (preferences.get(KEY_NAME)!=null){
                name = preferences.get(KEY_NAME);
            }
            Bbilama.setText(name);
            return name;
        });

    }
    private void onClick(View v) {

        if(v.getId()==R.id.button1) {

        double bbi2 = 0;
        String stringTinggiBadan = tinggiBadan.getText().toString();
        double tinggibadan = Double.parseDouble(stringTinggiBadan);

        if(TextUtils.isEmpty(stringTinggiBadan)){
            tinggiBadan.setError("Field Tidak Boleh Kosong");
        }
        if (pria.isChecked()) {
            bbi2 = (tinggibadan - 100) * 0.9;
        }
        if (wanita.isChecked()) {
            bbi2 = (tinggibadan - 100) * 0.85;
        }
        String bbi3=String.valueOf(bbi2);
        bbi.setText(bbi3+"");
    }

    }

}