package com.ve.SHRJ.app.bit2bytes.dosmilguince;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText megabits;
    private TextView descarga;
    private Spinner tipoBits;
    //protected ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        megabits = (EditText) findViewById(R.id.megabits);
        descarga = (TextView)  findViewById(R.id.descarga);
        tipoBits = (Spinner) findViewById(R.id.Bitspinner);
        //Spinner Bitspinner = (Spinner) findViewById(R.id.Bitspinner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onKeyUp(int codigoTecla, KeyEvent evento) {
        super.onKeyUp(codigoTecla, evento);

        boolean procesada = true;

        //ponertodo
        if (!(megabits.getText().toString().isEmpty()))
        {
            String BitSelected = tipoBits.getSelectedItem().toString();
            double P = 0;
            double N = Float.parseFloat(megabits.getText().toString());

            switch (BitSelected) {
                case "Bits":
                    P = 0;
                    break;
                case "Kilobits":
                    P = 3;
                    break;
                case "Megabits":
                    P = 6;
                    break;
                case "Gigabits":
                    P = 9;
                    break;
                case "Terabits":
                    P = 12;
                    break;
                case "Petabits":
                    P = 15;
                    break;
                case "Exabits":
                    P = 18;
                    break;
                case "Zettabits":
                    P = 21;
                    break;
                case "Yottabits":
                    P = 24;
                    break;
            }

            DecimalFormat formateador = new DecimalFormat("#.###");

            if (N < 8.192 && P == 0) {
                descarga.setText(String.valueOf(formateador.format(N / 8)));
            }
             else if(N < 8.192)
                {
                    descarga.setText(String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, (-10 * P / 3) + 10))) / 8)));
                }

            //if (N < 8.192) {
              //  descarga.setText(String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, (-10 * P / 3) + 10))) / 8)));
           // }

            if (N < 1048576 / 125 && N >= 8.192) {
                descarga.setText(String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, -10 * P / 3))) / 8)));
            }

            if (N >= 1048576 / 125) {
                descarga.setText(String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, (-10 * P / 3) - 10))) / 8)));
            }



        }
         else
            {
                descarga.setText("");
            }
        return procesada;

    }

}
