package dev.eder.padilla.cursogdgunam.secondactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.eder.padilla.cursogdgunam.R;
import dev.eder.padilla.cursogdgunam.recyclerview.RecyclerViewActivity;

public class Main2Activity extends AppCompatActivity {
    Intent intent;
    int valorQuerecibimos;
    @BindView(R.id.btn_get_text) Button mBugetText;
    @BindView(R.id.et_text_input) EditText mEtTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        if (getIntent()!=null){
            intent = getIntent();
            valorQuerecibimos = (int) intent.getExtras().get(RecyclerViewActivity.nombreDelParametroQueVamosAMandar);
            Log.e("Segunda Actividad","🌮🌮🌮🌮lo que recibimos es "+valorQuerecibimos);
            Toast.makeText(getApplicationContext(),"🌮🌮🌮🌮lo que recibimos es ",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_get_text) public void getTextFromEditText(){
        String loQueElUsuairoIngreso = mEtTextInput.getText().toString();
        Toast.makeText(getApplicationContext(),"🌮🌮🌮🌮lo que recibimos es "+ loQueElUsuairoIngreso,Toast.LENGTH_SHORT).show();
    }
}
