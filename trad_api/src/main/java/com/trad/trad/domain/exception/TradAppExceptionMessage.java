package com.trad.trad.domain.exception;

import java.util.Date;

public class TradAppExceptionMessage {
    public static String notFoundMessage (String value){
        return "El valor: " + value + ", no fue encontrado";
    }
    public static String expiredToken (Date expirated){
        return "Token fue expirado " + expirated ;
    }
    public static String errorSaving = "Ocurrio un error al guardar el registro";
}
