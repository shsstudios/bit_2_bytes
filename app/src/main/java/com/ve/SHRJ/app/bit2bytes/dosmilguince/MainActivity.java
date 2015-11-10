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

   /* public void convertir(View view)
    {
        if ((Float.parseFloat(megabits.getText().toString()) ) >= 8.388608)
            {
                descarga.setText(String.valueOf((Float.parseFloat(megabits.getText().toString())) * 15625/131072) + " MB/s");
            }
            else
                {
                    descarga.setText(String.valueOf((Float.parseFloat(megabits.getText().toString())) * (15625/128)) + " KB/s");
                }
    }*/

    @Override
    public boolean onKeyDown(int codigoTecla, KeyEvent evento)
    {
        super.onKeyUp(codigoTecla, evento);

        boolean procesada = true;

       //ponertodo

        /////////

        return procesada;



    }


    // descarga.setText(String.valueOf((Float.parseFloat(megabits.getText().toString())) * (15625/128)) + " KB/s");
    // descarga.setText(tipoBits.getSelectedItem().toString());
    //tipoBits.toString();

       /* if (((megabits.getText().toString())) == null)
        {
            descarga.setText(String.valueOf((Float.parseFloat(megabits.getText().toString())) * 15625/131072) + " MB/s");
        }*/

    ///////////////////////////////////////////////////////////////////

    //N = Float.parseFloat(megabits.getText().toString())


    ///fin de N///////////////////////

    //P en texto = megabits.getText().toString()
           private  String TipoBits = megabits.getText().toString();

           private double P ;

                switch (TipoBits) {
                    case Byte:  P = 0;
                        break;
                    case 2:  monthString = "February";
                        break;
                    case 3:  monthString = "March";
                        break;
                    case 4:  monthString = "April";
                        break;
                    case 5:  monthString = "May";
                        break;
                    case 6:  monthString = "June";
                        break;
                    case 7:  monthString = "July";
                        break;
                    case 8:  monthString = "August";
                        break;
                    case 9:  monthString = "September";
                        break;
                    case 10: monthString = "October";
                        break;
                    case 11: monthString = "November";
                        break;
                    case 12: monthString = "December";
                        break;
                    default: monthString = "Invalid month";
                        break;
                }
//////FIN DE P/////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////
}
