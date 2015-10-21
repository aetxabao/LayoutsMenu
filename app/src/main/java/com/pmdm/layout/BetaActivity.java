package com.pmdm.layout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridLayout;

public class BetaActivity extends ParentActivity {

    //   Params pars;
    SharedPreferences prefs;
    String clave;

//    String[] clave = {null,null,null,null};
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beta);

//        pars = Params.getInstance();

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        clave = "";

        GridLayout gl = (GridLayout)findViewById(R.id.GridLayoutBeta);
        ViewTreeObserver vto = gl.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                GridLayout gl = (GridLayout) findViewById(R.id.GridLayoutBeta);
                fillview(gl);
                ViewTreeObserver obs = gl.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void onClickNumber(View view) {
        Button button = (Button)view;
        //if (n<4) clave[n++] = button.getText().toString();
//        if (n==0) for(int i=0;i<4;i++) pars.clave[i] = null;
//        if (n<4) pars.clave[n++] = button.getText().toString();

        if (n<4){
            clave += button.getText().toString() + " ";
            n++;
        }
        if (n==4) clave = clave.substring(0, clave.length()-1);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("clave", clave);
        editor.commit();
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, GammaActivity.class);
        //intent.putExtra("NOMBRE",this.getIntent().getExtras().getString("NOMBRE"));
        //intent.putExtra("CLAVE",clave);
        startActivity(intent);
        BetaActivity.this.finish();
    }

    public void fillview(GridLayout gl) {
        Button buttontemp;
        int idealChildWidth = (int) ((gl.getWidth()-20*gl.getColumnCount())/gl.getColumnCount());
        for( int i=0; i< gl.getChildCount();i++) {
            buttontemp = (Button) gl.getChildAt(i);
            buttontemp.setWidth(idealChildWidth);
        }
    }

}
