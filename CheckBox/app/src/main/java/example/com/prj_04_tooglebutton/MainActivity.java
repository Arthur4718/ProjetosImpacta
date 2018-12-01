package example.com.prj_04_tooglebutton;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private CheckBox cb_ios, cb_android;
    //Utilizando todos os elementos filhos da clase view
    private RadioGroup rg;
    private RadioButton rb_m;
    private RadioButton rb_f;

    private ToggleButton tb_tomada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariaveis();
        inicializarAcoes();
    }

    private void inicializarVariaveis() {
        context = MainActivity.this;

        cb_ios = (CheckBox) findViewById(R.id.cbiOS);
        cb_android = (CheckBox) findViewById(R.id.cbAndroid);

        rg = (RadioGroup) findViewById(R.id.rg);
        rb_f = (RadioButton) findViewById(R.id.rb_f);
        rb_m = (RadioButton) findViewById(R.id.rb_m);

        DBToScreen();
        ScreenToDB();

    }


    private void DBToScreen() {

        int sabe_ios = 1;
        String sabe_android = "s";
        String sexo = "f";

        boolean status = true;

        if (sabe_ios == 1) {
            cb_ios.setChecked(true);
        } else {
            cb_ios.setChecked(false);
        }

        switch (sexo.toLowerCase()) {
            case Constantes.M:
                rb_m.setChecked(true);
                break;
            case Constantes.F:
                rb_f.setChecked(true);
                break;
            default:
                break;
        }
        tb_tomada.setChecked(status);

    }

    private void ScreenToDB() {
        int sabe_ios = -1;
        String sabe_android = "";


    }


    private void inicializarAcoes() {

        cb_android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, isChecked ? "Eu sei" : "Eu não sei", Toast.LENGTH_SHORT).show();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                String resultado = null;

                switch (checkedId) {
                    case R.id.rb_m:
                        resultado = "Masculino";
                        break;
                    case R.id.rb_f:
                        resultado = "Feminino";
                        break;
                    default:
                        resultado = "Não sei";
                        break;

                }
                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });


    }

}

