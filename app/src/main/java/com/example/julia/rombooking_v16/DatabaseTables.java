package com.example.julia.rombooking_v16;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Julia on 27.05.2016.
 */
public class DatabaseTables {


    public static final String ROM_DATA_TABLE = "rom";
    public static final String ROM_KODE = "rom_kode";
    public static final String ROM_NAVN = "rom_navn";
    public static final String ROM_TYPE_KODE = "rom_type_kode";
    public static final String KAPASITET_UND = "kapasitet_und";
    public static final String CAMPUS_ID = "campus_id";
    public static final String ER_AKTIVT = "er_aktiv";

 /*
    public static final String ROM_TYPER_DATA_TABLE = "rom_typer";
    public static final String ROM_TYPE_KODE = "rom_type_kode";

    public static final String ROM_UTSTYR_DATA_TABLE = "rom_utstyr";
    public static final String UTSTYR_KODE = "utstyr_kode";
    public static final String ROM_KODE = "rom_kode";

    */

    //sql statment for å opprette en ny tabell

    private static final String ROM_DATA_TABLE_CREATE = "create table"
      + ROM_DATA_TABLE
      + " (" + ROM_KODE + "text primary key autoincrement, "
      + ROM_NAVN + " text, "
      + ROM_TYPE_KODE + " text, "
      + KAPASITET_UND + " integer, "
      + CAMPUS_ID + " text, "
      + ER_AKTIVT + " integer, "  + ");";


    public  static void OnCreate(SQLiteDatabase database){
        database.execSQL(ROM_DATA_TABLE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.v(DatabaseTables.class.getName(), "Upgrading database from version"
        + oldVersion + "to" + newVersion
        + ", swich will destroy all old data");

        database.execSQL("DROP TABLE IF EXISITS " + ROM_DATA_TABLE);
        OnCreate(database);
    }


}
