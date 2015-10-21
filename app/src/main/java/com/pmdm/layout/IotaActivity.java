package com.pmdm.layout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class IotaActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iota);

        Bundle bundle = this.getIntent().getExtras();
        TextView lblInfo = (TextView) findViewById(R.id.LblResultado);

//        StringBuilder sb = new StringBuilder();
//        sb.append(bundle.getString("NOMBRE") + "\n");
//        String[] clave = bundle.getStringArray("CLAVE");
//        sb.append(clave[0] + clave[1] + clave[2] + clave[3] + "\n");
//        sb.append("Checkbox: " + bundle.getBoolean("CHK") + "\n");
//        sb.append("Radio op: " + bundle.getInt("OPT") + "\n");

//        Params pars = Params.getInstance();
//        sb.append(pars.nombre + "\n");
//        sb.append(pars.clave[0] + pars.clave[1] + pars.clave[2] + pars.clave[3] + "\n");
//        sb.append("Checkbox: " + pars.chk + "\n");
//        sb.append("Radio op: " + pars.opt + "\n");

//        lblInfo.setText(sb.toString());

        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String nombre = prefs.getString("nombre", "Sin nombre");
        String clave = prefs.getString("clave", "Sin clave");
        int opt = prefs.getInt("opt", 0);
        boolean chk = prefs.getBoolean("chk",false);
        String txt = nombre + "\n" + clave + "\n" + opt + "\n" + chk + "\n";
        lblInfo.setText(txt);
    }

}
