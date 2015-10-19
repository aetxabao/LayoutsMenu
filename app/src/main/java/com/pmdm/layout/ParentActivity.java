package com.pmdm.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        int id = item.getItemId();
        switch (id){
            case R.id.Alfa:
                intent = new Intent(this, AlfaActivity.class);
                break;
            case R.id.Beta:
                intent = new Intent(this, BetaActivity.class);
                break;
            case R.id.Gamma:
                intent = new Intent(this, GammaActivity.class);
                break;
            case R.id.Iota:
                intent = new Intent(this, IotaActivity.class);
                break;
        }
        if (intent!=null) {
            startActivity(intent);
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
