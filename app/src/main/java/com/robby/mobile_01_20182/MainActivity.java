package com.robby.mobile_01_20182;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Robby
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtOutput1;
    private TextView txtOutput2;
    private TextView txtOutput3;
    @BindView(R.id.tv_output_4)
    TextView txtOutput4;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Cara pertama untuk implementasi click pada Button (Java dan XML). Method button1Click dipanggil pada xml
        txtOutput1 = findViewById(R.id.tv_output_1);

        //  Cara kedua untuk implementasi click pada Button (Java)
        txtOutput2 = findViewById(R.id.tv_output_2);
        button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                txtOutput2.setText(String.valueOf(random.nextInt(100)));
            }
        });

        //  Cara ketiga untuk implementasi click pada Button (Java dengan implements class)
        txtOutput3 = findViewById(R.id.tv_output_3);
        button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);

        //  Cara keempat yaitu dengan menggunakan ButterKnife
        ButterKnife.bind(this);

    }

    public void button1Click(View view) {
        Random random = new Random();
        txtOutput1.setText(String.valueOf(random.nextInt(100)));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_3) {
            Random random = new Random();
            txtOutput3.setText(String.valueOf(random.nextInt(100)));
        }
    }

    @OnClick(R.id.button_4)
    public void onClick() {
        Random random = new Random();
        txtOutput4.setText(String.valueOf(random.nextInt(100)));
    }

}
