package example.com.ex_desconto;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText edDesconto, edPreco;
    private double preco_cheio = 2000.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariaveis();
        inicializarAcoes();
    }

    private void inicializarVariaveis() {

        edDesconto = (EditText) findViewById(R.id.et_desconto);
        edPreco = (EditText) findViewById(R.id.et_preco);
        //
        edDesconto.setText("");
        edPreco.setText(String.valueOf(preco_cheio));

        edDesconto.addTextChangedListener(txt_desconto);
        edPreco.addTextChangedListener(txt_preco);

    }

    private void inicializarAcoes() {
    }

    private TextWatcher txt_desconto = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            edPreco.removeTextChangedListener(txt_preco);
            try {
                double desconto_digitado = Double.parseDouble(edDesconto.getText().toString());
                double novo_preco = (1 - desconto_digitado / 100) * preco_cheio;
                edPreco.setText(String.valueOf(novo_preco));
            } catch (Exception e) {
                edPreco.setText(String.valueOf(preco_cheio));
            }
            edPreco.addTextChangedListener(txt_preco);

        }
    };

    private TextWatcher txt_preco = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            edDesconto.removeTextChangedListener(txt_desconto);
            try {
                double preco_digitado = Double.parseDouble(edPreco.getText().toString());
                double desconto = (1 - preco_digitado / preco_cheio) * 100;
                edDesconto.setText(String.valueOf(desconto));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            edDesconto.addTextChangedListener(txt_desconto);

        }
    };

}

