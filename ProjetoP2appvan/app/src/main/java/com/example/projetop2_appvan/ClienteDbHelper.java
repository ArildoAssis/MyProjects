package com.example.projetop2_appvan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.projetop2_appvan.ClienteContract.PontoDb;

import java.util.ArrayList;

public class ClienteDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 10;
    public static final String DATABASE_NAME = "Cliente.db";

    //CRIAR E DELETAR
    private static final String PONTO_CREATE = "create table " + PontoDb.TABLE_NAME + "("
            + PontoDb._ID + " integer primary key autoincrement, "
            + PontoDb.COLUMN_NOME + " text)";
    private static final String PONTO_DELETE = "drop table if exists " + PontoDb.TABLE_NAME;

    private static final String CIDADE_CREATE = "create table " + ClienteContract.CidadeDb.TABLE_NAME + "("
            + ClienteContract.CidadeDb._ID + " integer primary key autoincrement, "
            + ClienteContract.CidadeDb.COLUMN_NOME + " text)";
    private static final String CIDADE_DELETE = "drop table if exists " + ClienteContract.CidadeDb.TABLE_NAME;

    private static final String PERIODO_CREATE = "create table " + ClienteContract.PeriodoDb.TABLE_NAME + "("
            + ClienteContract.PeriodoDb._ID + " integer primary key autoincrement, "
            + ClienteContract.PeriodoDb.COLUMN_NOME + " text)";
    private static final String PERIODO_DELETE = "drop table if exists " + ClienteContract.PeriodoDb.TABLE_NAME;

    private static final String CLIENTE_CREATE = "create table " + ClienteContract.ClienteDb.TABLE_NAME + "("
            + ClienteContract.ClienteDb._ID + " integer primary key autoincrement, "
            + ClienteContract.ClienteDb.COLUMN_NOME + " text, "
            + ClienteContract.ClienteDb.COLUMN_CPF + " text, "
            + ClienteContract.ClienteDb.COLUMN_CELULAR + " text, "
            + ClienteContract.ClienteDb.COLUMN_ENDERECO + " text, "
            + ClienteContract.ClienteDb.COLUMN_CIDADE + " integer, "
            + ClienteContract.ClienteDb.COLUMN_PONTO + " integer, "
            + ClienteContract.ClienteDb.COLUMN_VALOR + " float, "
            + ClienteContract.ClienteDb.COLUMN_PERIODO + " integer, "
            + ClienteContract.ClienteDb.COLUMN_SITUACAO + " text, "
            + "foreign key (" + ClienteContract.ClienteDb.COLUMN_CIDADE +")   references " + ClienteContract.CidadeDb.TABLE_NAME + " (" + ClienteContract.CidadeDb._ID + "), "
            + "foreign key (" + ClienteContract.ClienteDb.COLUMN_PONTO + ") references " + ClienteContract.PontoDb.TABLE_NAME + " ("+ PontoDb._ID + "), "
            + "foreign key (" + ClienteContract.ClienteDb.COLUMN_PERIODO + ") references " + ClienteContract.PeriodoDb.TABLE_NAME + " (" + ClienteContract.PeriodoDb._ID + "));";
    private static final String CLIENTE_DELETE = " drop table if exists " + ClienteContract.ClienteDb.TABLE_NAME;

    public ClienteDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(PONTO_CREATE);
        db.execSQL(CIDADE_CREATE);
        db.execSQL(PERIODO_CREATE);
        db.execSQL(CLIENTE_CREATE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(PONTO_DELETE);
        db.execSQL(CIDADE_DELETE);
        db.execSQL(PERIODO_DELETE);
        db.execSQL(CLIENTE_DELETE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    //FUNÇÕES DO BD
    public boolean salvarPonto(Ponto ponto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PontoDb.COLUMN_NOME, ponto.getNome());
        long id = db.insert(ClienteContract.PontoDb.TABLE_NAME,null,contentValues);
        ponto.setId(id);
        return true;
    }
    public boolean salvarCidade(Cidade cidade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClienteContract.CidadeDb.COLUMN_NOME, cidade.getNome());
        long id = db.insert(ClienteContract.CidadeDb.TABLE_NAME,null,contentValues);
        cidade.setId(id);
        return true;
    }
    public boolean salvarPeriodo(Periodo periodo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClienteContract.PeriodoDb.COLUMN_NOME, periodo.getNome());
        long id = db.insert(ClienteContract.PeriodoDb.TABLE_NAME,null,contentValues);
        periodo.setId(id);
        return true;
    }
    public boolean salvarCliente(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClienteContract.ClienteDb.COLUMN_NOME, cliente.getNome());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_CPF, cliente.getCpf());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_CELULAR, cliente.getCelular());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_ENDERECO, cliente.getEndereco());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_CIDADE, cliente.getCidade());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_PONTO, cliente.getPonto());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_VALOR, cliente.getValor());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_PERIODO, cliente.getPeriodo());
        contentValues.put(ClienteContract.ClienteDb.COLUMN_SITUACAO, cliente.getSituacao());
        long id = db.insert(ClienteContract.ClienteDb.TABLE_NAME,null,contentValues);
        cliente.setId(id);
        return true;
    }

    public ArrayList consultarPontos() {
        ArrayList lista = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PontoDb.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            lista.add(new Ponto(cursor.getLong(cursor.getColumnIndex(PontoDb._ID)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.PontoDb.COLUMN_NOME))));
        }
        return lista;
    }
    public ArrayList consultarCidades() {
        ArrayList lista = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ClienteContract.CidadeDb.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            lista.add(new Cidade(cursor.getLong(cursor.getColumnIndex(ClienteContract.CidadeDb._ID)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.CidadeDb.COLUMN_NOME))));
        }
        return lista;
    }
    public ArrayList consultarPeriodos() {
        ArrayList lista = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ClienteContract.PeriodoDb.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            lista.add(new Periodo(cursor.getLong(cursor.getColumnIndex(ClienteContract.PeriodoDb._ID)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.PeriodoDb.COLUMN_NOME))));
        }
        return lista;
    }
    public ArrayList consultarClientes() {
        ArrayList lista = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ClienteContract.ClienteDb.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            lista.add(new Cliente(cursor.getLong(cursor.getColumnIndex(ClienteContract.ClienteDb._ID)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_NOME)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_CELULAR)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_CPF)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_ENDERECO)),
                    cursor.getInt(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_CIDADE)),
                    cursor.getInt(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_PONTO)),
                    cursor.getFloat(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_VALOR)),
                    cursor.getInt(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_PERIODO)),
                    cursor.getString(cursor.getColumnIndex(ClienteContract.ClienteDb.COLUMN_SITUACAO))));
        }
        return lista;
    }

    public String consultarNomePonto(int pos){
        String nome_p;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PontoDb.TABLE_NAME + " where " + PontoDb._ID + " = " + pos,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        nome_p = cursor.getString(1);
        return nome_p;
    }
    public String consultarNomeCidade(int pos){
        String nome_c;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ClienteContract.CidadeDb.TABLE_NAME + " where " + ClienteContract.CidadeDb._ID + " = " + pos,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        nome_c = cursor.getString(1);
        return nome_c;
    }
    public String consultarNomePeriodo(int pos){
        String nome_c;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ClienteContract.PeriodoDb.TABLE_NAME + " where " + ClienteContract.PeriodoDb._ID + " = " + pos,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        nome_c = cursor.getString(1);
        return nome_c;
    }
    public String consultarNomeCliente(int pos, int coluna){
        String nome_c;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ClienteContract.ClienteDb.TABLE_NAME + " where " + ClienteContract.ClienteDb._ID + " = " + pos,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        nome_c = cursor.getString(coluna);
        return nome_c;
    }

    public int atualizarNomePonto(long pos, String nome){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PontoDb.COLUMN_NOME, nome);
        return db.update(PontoDb.TABLE_NAME, contentValues, PontoDb._ID + " = " + pos, null);
    }
    public int atualizarNomeCidade(long pos, String nome){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClienteContract.CidadeDb.COLUMN_NOME, nome);
        return db.update(ClienteContract.CidadeDb.TABLE_NAME, contentValues, ClienteContract.CidadeDb._ID + " = " + pos, null);
    }
    public int atualizarNomePeriodo(long pos, String nome){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClienteContract.PeriodoDb.COLUMN_NOME, nome);
        return db.update(ClienteContract.PeriodoDb.TABLE_NAME, contentValues, ClienteContract.PeriodoDb._ID + " = " + pos, null);
    }
    public int atualizarNomeCliente(long pos, String nome, String cpf, String celular, String endereco, Integer cidade, Integer ponto, Float valor, Integer periodo, String situacao){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClienteContract.ClienteDb.COLUMN_NOME, nome);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_CPF, cpf);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_CELULAR, celular);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_ENDERECO, endereco);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_CIDADE, cidade);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_PONTO, ponto);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_VALOR, valor);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_PERIODO, periodo);
        contentValues.put(ClienteContract.ClienteDb.COLUMN_SITUACAO, situacao);
        return db.update(ClienteContract.ClienteDb.TABLE_NAME, contentValues, ClienteContract.ClienteDb._ID + " = " + pos, null);
    }
}
