package com.leassy.studiodd.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.*;

/**
 * Created by Omar on 29/09/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper
    {
        public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase base) {

            base.execSQL("create table categorias(id INTEGER,area TEXT);");

            base.execSQL("INSERT INTO categorias VALUES (0,'Social');");
            base.execSQL("INSERT INTO categorias VALUES (1,'Profesional');");
            base.execSQL("INSERT INTO categorias VALUES (2,'Via publica'); ");
            base.execSQL("INSERT INTO categorias VALUES (3,'Informacion'); ");
            base.execSQL("INSERT INTO categorias VALUES (4,'Escuela'); ");
            base.execSQL("INSERT INTO categorias VALUES (5,'Transporte'); ");
            base.execSQL("INSERT INTO categorias VALUES (6,'Alimentos'); ");
            base.execSQL("INSERT INTO categorias VALUES (7,'Gobierno'); ");
            base.execSQL("INSERT INTO categorias VALUES (8,'Mas'); ");

            base.execSQL("create table FRASES(ID INTEGER,area INTEGER,fraseesp TEXT,fraseing TEXT);");

            base.execSQL("INSERT INTO FRASES VALUES (0,0,'Hola, mi nombre es','Hi, my name is...'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,0,'Adios, ten un lindo día.','Good bye, have a nice day'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,0,'¿Como estás?','How are you?'); ");

            base.execSQL("INSERT INTO FRASES VALUES (0,1,'Aprecio tu atencion en este problema','I appreciate your attention to this matter'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,1,'Debes tener preguntas, por favor sientete libre de contactarme','Should you have questions, please feel free to contact me'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,1,'Es una gran oportunidad','This is a great opportunity.'); ");

            base.execSQL("INSERT INTO FRASES VALUES (0,2,'Aprecio tu atencion en este problema','I appreciate your attention to this matter'); ");
            base.execSQL("INSERT INTO FRASES VALUES (1,2,'Debes tener preguntas, por favor sientete libre de contactarme','Should you have questions, please feel free to contact me'); ");
            base.execSQL("INSERT INTO FRASES VALUES (2,2,'Es una gran oportunidad','This is a great opportunity.'); ");
            //base.close();
        }

        @Override
        public void onUpgrade(SQLiteDatabase base, int oldVersion, int newVersion) {

        }
    }