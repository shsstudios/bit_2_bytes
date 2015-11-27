package com.ve.SHRJ.app.bit2bytes.dosmilguince;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText megabits;
    private TextView descarga;
    private Spinner tipoBits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        megabits = (EditText) findViewById(R.id.megabits);
        descarga = (TextView)  findViewById(R.id.descarga);
        tipoBits = (Spinner) findViewById(R.id.Bitspinner);


        tipoBits.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()
                {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        Bit2Bytes();
                    }

                    public void onNothingSelected(AdapterView<?> parent)
                    {
                        descarga.setText("SHS studios");
                    }
                });
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

            Bit2Bytes();

        return procesada;

    }


    //Funcion que calcula los Bits a Bytes
    void Bit2Bytes()
    {
        //ponertodo
        if (!(megabits.getText().toString().isEmpty()))
        {
            String BitSelected = tipoBits.getSelectedItem().toString();
            int P = 0;
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

            DecimalFormat formateador = new DecimalFormat("#.##");

            //String SufijoBytes;

            ///////////////////////////////////////

            if (N < 8.192 && P == 0)
            {
                String ValorCrudo = String.valueOf(formateador.format(N / 8));

                descarga.setText(ValorCrudo + " " + SufijoBytes(P));
            }
            else if(N < 8.192)
            {
                String ValorCrudo = String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, (-10 * P / 3) + 10))) / 8));

                descarga.setText(ValorCrudo + " " + SufijoBytes(P - 3));
            }

            if (N < 1048576 / 125 && N >= 8.192)
            {
                String ValorCrudo = String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, -10 * P / 3))) / 8));

                descarga.setText(ValorCrudo + " " + SufijoBytes(P));
            }

            if (N >= 1048576 / 125)
            {
                String ValorCrudo = String.valueOf(formateador.format((N * (Math.pow(10, P)) * (Math.pow(2, (-10 * P / 3) - 10))) / 8));

                descarga.setText(ValorCrudo + " " + SufijoBytes(P + 3));
            }

        }
        else
        {
            descarga.setText("");
        }
    }

    //Funcion q devuelve el sufijo correspondiente a la cantidad calculada
    String SufijoBytes(int valorp)
    {
        String Sufijo="";

        switch (valorp) {
            case  0:
                Sufijo = "Bytes";
                break;
            case  3:
                Sufijo = "KB";
                break;
            case 6:
                Sufijo = "MB";
                break;
            case 9:
                Sufijo = "GB";
                break;
            case 12:
                Sufijo = "TB";
                break;
            case 15:
                Sufijo = "PB";
                break;
            case 18:
                Sufijo = "EB";
                break;
            case 21:
                Sufijo = "ZB";
                break;
            case 24:
                Sufijo = "YB";
                break;
            default:
                Sufijo = "YB";
                break;

        }

        return Sufijo;
    }

}
