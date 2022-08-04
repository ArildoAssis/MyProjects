package com.example.projetop2_appvan;

import android.provider.BaseColumns;

public final class ClienteContract {
    public ClienteContract(){
    }
    public static abstract class PontoDb implements BaseColumns {
        public static final String TABLE_NAME = "ponto";
        public static final String COLUMN_NOME = "nome";
    }
    public static abstract class CidadeDb implements BaseColumns {
        public static final String TABLE_NAME = "cidade";
        public static final String COLUMN_NOME = "nome";
    }
    public static abstract class PeriodoDb implements BaseColumns {
        public static final String TABLE_NAME = "periodo";
        public static final String COLUMN_NOME = "nome";
    }
    public static abstract class ClienteDb implements BaseColumns{
        public static final String TABLE_NAME = "cliente";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_CPF = "cpf";
        public static final String COLUMN_CELULAR = "celular";
        public static final String COLUMN_ENDERECO = "endereco";
        public static final String COLUMN_CIDADE = "cidade";
        public static final String COLUMN_PONTO = "ponto";
        public static final String COLUMN_VALOR = "valor";
        public static final String COLUMN_PERIODO = "periodo";
        public static final String COLUMN_SITUACAO = "situacao";
    }
}