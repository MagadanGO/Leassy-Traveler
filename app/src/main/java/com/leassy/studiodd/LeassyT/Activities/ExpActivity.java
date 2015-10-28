package com.leassy.studiodd.LeassyT.Activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import com.leassy.studiodd.LeassyT.R;


public class ExpActivity extends ActionBarActivity {

    int idRe,idA;
    Bundle bundle;
    Cursor cursor;
    ImageView imagen;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);

        bundle = getIntent().getExtras();
        idRe=bundle.getInt("idx");
        idA=bundle.getInt("idy");
        consultar();

        imagen = (ImageView) findViewById(R.id.imageView);

        cursor.moveToFirst();

        imagen.setImageResource(getResources().getIdentifier(cursor.getString(3),"drawable",getPackageName()));
        mp=MediaPlayer.create(this,getResources().getIdentifier(cursor.getString(2),"raw",getPackageName()));

        TextView txt1 = (TextView)findViewById(R.id.fraseesp);
        txt1.setText(cursor.getString(0));
        TextView txt2 = (TextView)findViewById(R.id.fraseing);
        txt2.setText(cursor.getString(1));

    }//OnCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exp, menu);
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

    public void listen(View v){
        mp.start();
    }

    public void consultar(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"base",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();
        cursor= base.rawQuery("select fraseesp,fraseing,audio,imagen from FRASES where ID = "+idRe+" and area="+idA,null);
    }//Consultar
}
