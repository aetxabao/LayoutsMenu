package com.pmdm.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlfaActivity extends ParentActivity {

    Params pars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfa);

        final EditText txtNombre = (EditText) findViewById(R.id.TxtNombre);
        final Button btnOk = (Button) findViewById(R.id.BtnOk);

        pars = Params.getInstance();
        txtNombre.setText(pars.nombre);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlfaActivity.this,BetaActivity.class);
                //intent.putExtra("NOMBRE", txtNombre.getText().toString());
                pars.nombre = txtNombre.getText().toString();
                startActivity(intent);
                AlfaActivity.this.finish();
            }
        });
    }

}
