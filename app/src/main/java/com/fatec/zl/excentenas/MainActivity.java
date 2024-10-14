package com.fatec.zl.excentenas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValor = findViewById(R.id.etValor);
        etValor.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.textView);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> Calcular());
    }

    private void Calcular(){
        int valor = Integer.parseInt(etValor.getText().toString());

        if(valor > 999 || valor < 100){
            tvRes.setText(getString(R.string.s_mensagem_erro));
        }
        else{
            int centena = valor / 100;
            int dezena = (valor % 100) / 10;
            int unidade = valor % 10;

            String msgcentena = getString(R.string.s_mensagem_centena) + " " + centena;
            String msgdezena = getString(R.string.s_mensagem_dezena) + " " + dezena;
            String msgunidade = getString(R.string.s_mensagem_unidade) + " " + unidade;
            String msg = msgcentena + "\n" + msgdezena + "\n" + msgunidade;

            tvRes.setText(msg);
        }

    }
}