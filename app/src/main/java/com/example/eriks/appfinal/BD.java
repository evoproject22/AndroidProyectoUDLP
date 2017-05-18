package com.example.eriks.appfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BD extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "laspalmas1.dat";
    private static final int DATABASE_VERSION = 1;


    //DATABASE CREATION
    private static final String DATABASE_CREATE = "CREATE TABLE PRODUCTOS(COD NUMERIC (2) NOT NULL, NOMBRE VARCHAR (50) NOT NULL, PRECIO NUMERIC (3) NOT NULL,IMG VARCHAR (50) NOT NULL, CONSTRAINT PK_PRODUCTOS PRIMARY KEY (COD));";
    private static final String DATABASE_CREATE2 = "CREATE TABLE CLIENTES (NOMBRE VARCHAR (50) NOT NULL,APELLIDOS VARCHAR (50) NOT NULL, DNI VARCHAR (50) NOT NULL,EMAIL VARCHAR (50) NOT NULL, CONSTRAINT PK_CLIENTES PRIMARY KEY (DNI));";
    private static final String DATABASE_CREATE3 = "CREATE TABLE PARTIDOS (COD3 NUMERIC (2) NOT NULL, JORNADA NUMERIC (2) NOT NULL,IMG VARCHAR (50) NOT NULL, CONSTRAINT PK_PARTIDOS PRIMARY KEY (COD3));";
    private static final String DATABASE_CREATE4 = "CREATE TABLE AudioVisual(id Numeric(4) NOT NULL, Nombre VARCHAR(60) NOT NULL, Tipo NUMERIC(1) NOT NULL, Url VARCHAR(100) NOT NULL, CONSTRAINT PK_AUDIOVISUAL PRIMARY KEY(id));";

    public BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE2);
        database.execSQL(DATABASE_CREATE3);
        database.execSQL(DATABASE_CREATE4);


        ContentValues date_insert = new ContentValues();
        date_insert.put("id", 10);
        date_insert.put("nombre", "Ascenso");
        date_insert.put("tipo", 0);
        date_insert.put("url", "https://www.youtube.com/watch?v=J4pTV_CsBUY");

        long err = database.insert("AudioVisual", null, date_insert);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

