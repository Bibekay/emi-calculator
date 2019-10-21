package com.example.emi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etP,etR,etT;
    TextView result;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etP = findViewById(R.id.principle);
        etR  = findViewById(R.id.rate);
        etT = findViewById(R.id.time);
        btncalculate =findViewById(R.id.calculateEMI);
        result =findViewById(R.id.emidis);

        btncalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
           float emiOut;
           float P = Float.parseFloat(etP.getText().toString());
           float R = Float.parseFloat(etR.getText().toString());
           float T = Float.parseFloat(etT.getText().toString());

           emiOut =  emical(P,R,T);
           result.setText(String.format("EMI =%.2f",emiOut));

    }

    // Calculation of EMI
    static float emical (float p, float r, float t)
    {
        float emiOut,r1,t1;
        r1 = r / (12 * 100); // monthly interest
        t1 = t * 12; // monthly duration
        emiOut = (p * r1 * (float)Math.pow(1 + r1, t1))
                / (float)(Math.pow(1 + r1, t1) - 1);

        return (emiOut);

    }
}
