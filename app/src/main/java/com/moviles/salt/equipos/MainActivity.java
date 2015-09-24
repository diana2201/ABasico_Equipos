package com.moviles.salt.equipos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    ListView list;
    String[] data;
    public static List<String> dataEquipo;
    ArrayAdapter<String> adapter;
    int pos;

    @Override
    protected void onRestart() {
        adapter.notifyDataSetChanged();
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        data = getResources().getStringArray(R.array.Equipos);

        dataEquipo = new ArrayList<String>();
        for(int i=0;i<data.length;i++)
        {
            dataEquipo.add(data[i]);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                dataEquipo);
        list.setAdapter(adapter);
        registerForContextMenu(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_add:
                Intent intent = new Intent(this,AgregarActivity.class);
                startActivity(intent);
                break;
            case R.id.action_info:
                Toast.makeText(this,"Seleccionaste Información",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this,"Seleccionaste Acerca de",
                        Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_ctx_list,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.
                AdapterContextMenuInfo) item.getMenuInfo();
        pos = info.position;


        switch (item.getItemId())
        {
            case R.id.action_edit:
                Toast.makeText(this,
                        "Seleccionaste editar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                showAlertDelete();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showAlertDelete() {

        AlertDialog alert = new AlertDialog.Builder(this).
                setTitle("Eliminar Equipo").
                setMessage("¿Estás seguro que deseas eliminar este equipo?").
                setPositiveButton("Aceptar",this).
                setNegativeButton("Cancelar",this).create();
        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which== DialogInterface.BUTTON_POSITIVE)
        {
            dataEquipo.remove(pos);
            adapter.notifyDataSetChanged();
        }

    }
}
