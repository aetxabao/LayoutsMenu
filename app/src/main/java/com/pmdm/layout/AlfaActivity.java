package com.pmdm.layout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlfaActivity extends ParentActivity {

//    Params pars;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfa);

        final EditText txtNombre = (EditText) findViewById(R.id.TxtNombre);
        final Button btnOk = (Button) findViewById(R.id.BtnOk);

//        pars = Params.getInstance();
//        txtNombre.setText(pars.nombre);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String nombre = prefs.getString("nombre", "Nombre por defecto");
        txtNombre.setText(nombre);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlfaActivity.this,BetaActivity.class);
                //intent.putExtra("NOMBRE", txtNombre.getText().toString());
//                pars.nombre = txtNombre.getText().toString();

                SharedPreferences.Editor editor = prefs.edit();
                String nombre =  txtNombre.getText().toString();
                editor.putString("nombre", nombre);
                editor.commit();

                startActivity(intent);
                AlfaActivity.this.finish();
            }
        });
    }

}
