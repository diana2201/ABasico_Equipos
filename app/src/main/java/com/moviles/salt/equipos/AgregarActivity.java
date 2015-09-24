package com.moviles.salt.equipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        editText = (EditText) findViewById(R.id.edittext_nombre);
        btn = (Button) findViewById(R.id.btn_agregar);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity.dataEquipo.add(editText.getText().toString());
        finish();
    }
}
