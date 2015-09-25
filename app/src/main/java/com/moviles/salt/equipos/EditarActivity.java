package com.moviles.salt.equipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit;
    Button btn;
    int pos;
    String equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        edit = (EditText) findViewById(R.id.edittext_nombre);
        btn = (Button) findViewById(R.id.btn_agregar);

        btn.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();

        if (extras != null)
            pos = extras.getInt("position");

        equipo = MainActivity.dataEquipo.get(pos);
        edit.setText(equipo);

    }


    @Override
    public void onClick(View v) {
        equipo = edit.getText().toString();

        MainActivity.dataEquipo.remove(pos);
        MainActivity.dataEquipo.add(pos,equipo);
        finish();
    }
}
