package com.pmdm.layout;

//Patrón Singleton
public class Params {

    public String nombre = null;
    public String[] clave = {null, null, null, null};
    public boolean chk = false;
    public int opt = 0;

    private static final Params INSTANCE = new Params();

    //Constructor que impide la instanciación de otras clases
    private Params(){}

    public static Params getInstance(){
        return INSTANCE;
    }

}
