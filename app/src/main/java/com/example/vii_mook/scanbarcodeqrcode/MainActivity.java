package com.example.vii_mook.scanbarcodeqrcode;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.vii_mook.scanbarcodeqrcode.R.id.txtResult;

public class MainActivity extends AppCompatActivity {
    private Button btnScan;
    private TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnScan = (Button) findViewById(R.id.btnScan);
        textResult = (TextView) findViewById(txtResult);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

//                    IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
//                    integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
                    Intent intentOption = new Intent("com.google.zxing.client.android.SCAN");
                    intentOption.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    intentOption.putExtra("SCAN_MODE", "BARCODE_MODE");
                    startActivityForResult(intentOption, 0);

                } catch (Exception e) {

                    Toast.makeText(getBaseContext(), "Please Install Barcode Scanner", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                String format = data.getStringExtra("SCAN_RESULT_FORMAT");
                textResult.setText("Result : " + contents);
            }
        }
    }


}
