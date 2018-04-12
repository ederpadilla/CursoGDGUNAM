package dev.eder.padilla.cursogdgunam.secondactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    @BindView(R.id.text_view) TextView textView;
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e("Main2Activity","dio back pressed");
    }

    @OnClick(R.id.btn_get_text) public void getTextFromEditText(){
        try  {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
        String loQueElUsuairoIngreso = mEtTextInput.getText().toString();
        if (loQueElUsuairoIngreso.isEmpty()){
            mEtTextInput.setError("Necesitas ingresar texto");
        }else{
            Toast.makeText(getApplicationContext(),"🌮🌮🌮🌮lo que recibimos es "+ loQueElUsuairoIngreso,Toast.LENGTH_SHORT).show();
            textView.setText(loQueElUsuairoIngreso);
        }

    }
}
