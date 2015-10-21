package com.pmdm.layout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class GammaActivity extends ParentActivity {

    //    Params pars;
    SharedPreferences prefs;
    CheckBox chk;
    RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamma);

        chk = (CheckBox) findViewById(R.id.ChkOpcion);
        int i = 0;
        rb1 = (RadioButton) findViewById(R.id.Radio1);
        rb2 = (RadioButton) findViewById(R.id.Radio2);
//        pars = Params.getInstance();
//        if (pars.opt==1) rb1.setChecked(true);
//        if (pars.opt==2) rb2.setChecked(true);
//        chk.setChecked(pars.chk);
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        int opt = prefs.getInt("opt", 0);
        boolean b = prefs.getBoolean("chk",false);
        if (opt==1) rb1.setChecked(true);
        if (opt==2) rb2.setChecked(true);
        chk.setChecked(b);
    }

    public void onClick(View view) {
        int i = 0;
        Intent intent = new Intent(this, IotaActivity.class);
//        intent.putExtra("NOMBRE", this.getIntent().getExtras().getString("NOMBRE"));
//        intent.putExtra("CLAVE", this.getIntent().getExtras().getStringArray("CLAVE"));
//        intent.putExtra("CHK", chk.isChecked());
        if (rb1.isChecked()) i = 1;
        if (rb2.isChecked()) i = 2;
//        intent.putExtra("OPT", i);
//        pars.opt = i;
//        pars.chk = chk.isChecked();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("chk", chk.isChecked());
        editor.putInt("opt", i);
        editor.commit();

        startActivity(intent);
        GammaActivity.this.finish();
    }
}
