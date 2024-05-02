package com.example.coach.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.coach.R;
import com.example.coach.controller.Control;

public class MainActivity extends Activity {

    //properties
    private EditText txtWeight;
    private EditText txtHeight;
    private EditText txtYear;
    private RadioGroup grpRadioSex;
    private TextView txtScore;
    private Button btnCalc;
    private ImageView imgScore;

    /**
     * Bind the properties to their respective
     * with the help of findViewById()
     */
    private void bindProperties(){
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        txtYear = (EditText) findViewById(R.id.txtYear);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        imgScore = (ImageView) findViewById(R.id.imgScore);
        grpRadioSex = (RadioGroup) findViewById(R.id.grpRadioSex);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindProperties();
        Control controller = Control.getInstance();
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the radio button checked by the user
                RadioButton rdSex = findViewById(grpRadioSex.getCheckedRadioButtonId());
                //get the tag value attached to id and convert it to int
                int rdSexValue = Integer.parseInt((String)rdSex.getTag());
                //TODO check the value if null and throw an error
                controller.createProfil(Integer.parseInt(txtHeight.getText().toString()),
                        Integer.parseInt(txtWeight.getText().toString()), rdSexValue,
                        Integer.parseInt(txtYear.getText().toString()));
                String message = controller.getImg() +" "+controller.getMessage();
                txtScore.setText(message);
                imgScore.setImageResource(controller.getImgPicture());
            }
        });
    }
}
