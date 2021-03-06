package com.leassy.studiodd.LeassyT.Activities;

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

import com.leassy.studiodd.LeassyT.R;


public class FrasesActivity extends ActionBarActivity {

    String opciones[];
    int idRe;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        bundle = getIntent().getExtras();
        idRe=bundle.getInt("id");
        consultar();

        ListView lista =(ListView) findViewById(R.id.fraseslist);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opciones);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),ExpActivity.class);
                i.putExtra("idx",position);
                i.putExtra("idy",idRe);
                startActivity(i);
            }
        });

    }//onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frases, menu);
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
        SQLiteDatabase base = admin.getWritableDatabase();
        Cursor cursor= base.rawQuery("select fraseesp from FRASES where area = "+idRe,null);
        opciones = new String [cursor.getCount()];
        int c=0;
        while(cursor.moveToNext()){
            opciones[c]=cursor.getString(0);
            c++;
        }
    }//Consultar
}
