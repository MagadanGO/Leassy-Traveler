package com.leassy.studiodd.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLClientInfoException;


public class CategoriasActivity extends ActionBarActivity {

    Bundle bundle;
    TextView textview;
    int idRe;
    String [] arreglo;
    ListView lista;
    ArrayAdapter<String> adaptador;
    int c;
    String opciones [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias );

        consultar();
        lista =(ListView) findViewById(R.id.opciones);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opciones);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {//Listener
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), CategoriasActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        } //Listener
        );

        bundle = getIntent().getExtras();
        idRe=bundle.getInt("id");

    }//Create

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categorias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void consultar(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"base",null,1);
        SQLiteDatabase base=admin.getWritableDatabase();
        String query = "select frases FROM areas WHERE id_ = "+idRe;
        Cursor cursor= base.rawQuery(query,null);
        opciones = new String [cursor.getCount()];
        int c=0;
        if (cursor.moveToFirst()){
            opciones [0]=cursor.getString(0);
            //textview.setText(arreglo [0]);
        }
        while(cursor.moveToNext()){
            opciones[c]=cursor.getString(0);
            c++;
        }
    }//Consultar

}
