package edu.upc.dsa.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Calculadora extends AppCompatActivity {
    private TextView tvResultat;
    private double id1, id2, resultat;
    private int operacio = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //btnToggleMode.setOn
        tvResultat=findViewById(R.id.tvResultat);
    }

    public void numeroClick(View view){
        tvResultat = findViewById(R.id.tvResultat);
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        tvResultat.append(buttonText);
    }

    public void sumaClick(View view){
        operacio=1;
        tvResultat=findViewById(R.id.tvResultat);
        id1=Double.parseDouble(tvResultat.getText().toString());
        tvResultat.setText("");
    }

    public void restaClick(View view){
        operacio=2;
        tvResultat=findViewById(R.id.tvResultat);
        id1=Double.parseDouble(tvResultat.getText().toString());
        tvResultat.setText("");
    }

    public void multiplicacioClick(View view){
        operacio=3;
        tvResultat=findViewById(R.id.tvResultat);
        id1=Double.parseDouble(tvResultat.getText().toString());
        tvResultat.setText("");
    }

    public void divisioClick(View view){
        operacio=4;
        tvResultat=findViewById(R.id.tvResultat);
        id1=Double.parseDouble(tvResultat.getText().toString());
        tvResultat.setText("");
    }

    public void sinClick(View view){
        operacio=5;
        tvResultat=findViewById(R.id.tvResultat);
        tvResultat.setText("");
    }

    public void cosClick(View view){
        operacio=6;
        tvResultat=findViewById(R.id.tvResultat);
        tvResultat.setText("");
    }

    public void tanClick(View view){
        operacio=7;
        tvResultat=findViewById(R.id.tvResultat);
        tvResultat.setText("");
    }

    public void resetClick(View view){
        operacio=0;
        id1=0.0;
        id2=0.0;
        tvResultat=findViewById(R.id.tvResultat);
        tvResultat.setText("");
    }

    public void igualClick(View view){
        tvResultat=findViewById(R.id.tvResultat);
        String text = tvResultat.getText().toString();
        id2 = Double.parseDouble(text);

        if (operacio == 1){
            resultat = id1 + id2;
        }
        else if (operacio == 2){
            resultat = id1 - id2;
        }
        else if (operacio == 3){
            resultat = id1 * id2;
        }
        else if (operacio == 4){
            resultat = id1/id2;
        }
        else if (operacio == 5){
            //obtenim el valor de l'angle en graus des de la variable id2
            double angleGraus = this.id2;
            //convertim l'angle de graus a radians
            double angleRadians = Math.toRadians(angleGraus);
            //calcula el sinus de l'angle en radians i el guardem a la variable x
            double x = Math.sin(angleRadians);
            resultat = x;

        }
        else if (operacio == 6){
            double angleGraus = this.id2;
            double angleRadians = Math.toRadians(angleGraus);
            double x = Math.cos(angleRadians);
            resultat = x;
        }
        else if (operacio == 7){
            double angleGraus = this.id2;
            double angleRadians = Math.toRadians(angleGraus);
            double x = Math.tan(angleRadians);
            resultat = x;
        }
        //amb el format %4f treiem el resultat amb 4 espais de la paret esquerra
        tvResultat.setText(String.format(Locale.getDefault(),"%4f", resultat));
    }
}