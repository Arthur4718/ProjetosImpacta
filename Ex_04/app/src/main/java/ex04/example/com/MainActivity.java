package ex04.example.com;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome,idade;
    private RadioButton r_f,r_m;
    private RadioGroup rg;
    private CheckBox chCidade;
    private Button btnLerdados;
    private ImageView imgAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariaveis();
        inicializarAcoes();
    }

    private void inicializarVariaveis() {
        nome = (EditText) findViewById(R.id.et_name);
        idade = (EditText) findViewById(R.id.et_age);
        r_f = (RadioButton) findViewById(R.id.r_f);
        r_m = (RadioButton) findViewById(R.id.r_m);
        rg = (RadioGroup) findViewById(R.id.rg);
        imgAvatar = (ImageView) findViewById(R.id.iv_avatar);
        btnLerdados = (Button) findViewById(R.id.btn_lerdados);
        nome.setText("");
        idade.setText("");
    }

    private void inicializarAcoes() {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                String resultado = null;
                switch (checkedId) {
                    case R.id.r_m:
                        resultado = "Masculino";
                        break;
                    case R.id.r_f:
                        resultado = "Feminino";
                        break;
                    default:
                        resultado = "Não sei";
                        break;

                }
                Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_SHORT).show();
            }
        });


    }

}

