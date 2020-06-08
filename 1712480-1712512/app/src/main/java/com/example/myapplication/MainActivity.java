package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.DoubleAccumulator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvKQ;
    String KQ="";
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnCong,btnTru,btnNhan,btnChia,btnAC,btncham,btnBang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        setClick();
    }

    void anhXa()
    {
        btn0=findViewById(R.id.so0);
        btn1=findViewById(R.id.so1);
        btn2=findViewById(R.id.so2);
        btn3=findViewById(R.id.so3);
        btn4=findViewById(R.id.so4);
        btn5=findViewById(R.id.so5);
        btn6=findViewById(R.id.so6);
        btn7=findViewById(R.id.so7);
        btn8=findViewById(R.id.so8);
        btn9=findViewById(R.id.so9);
        btncham=findViewById(R.id.cham);
        btnCong=findViewById(R.id.dauCong);
        btnTru=findViewById(R.id.dauTru);
        btnChia=findViewById(R.id.dauChia);
        btnNhan=findViewById(R.id.dauNhan);
        btnAC=findViewById(R.id.AC);
        btnBang=findViewById(R.id.dauBang);
        tvKQ=findViewById(R.id.twKq);
    }

    void setClick()
    {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btncham.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnBang.setOnClickListener(this);
        btnAC.setOnClickListener(this);
    }

    String dau;
    int dem=0;
    double sobandau;
    double sothuhai;
    @Override
    public void onClick(View v) {
        Button btn = null;
        if(v.getId()==R.id.cham||v.getId()==R.id.so0||v.getId()==R.id.so1||v.getId()==R.id.so2||v.getId()==R.id.so3||v.getId()==R.id.so4||v.getId()==R.id.so5||v.getId()==R.id.so6||v.getId()==R.id.so7||v.getId()==R.id.so8||v.getId()==R.id.so9) {
            btn = (Button) v;
            String a = btn.getText().toString();
            KQ=KQ+a;
            tvKQ.setText(KQ);
            //Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.dauCong||v.getId()==R.id.dauTru||v.getId()==R.id.dauNhan||v.getId()==R.id.dauChia)
        {
            btn=(Button)v;
            if(dem==0)
            {
                if(!tvKQ.getText().toString().isEmpty())
                {
                    btn=(Button) v;
                    dau = btn.getText().toString();
                    try
                    {
                        sobandau = Double.parseDouble(tvKQ.getText().toString());
                    }catch (Exception e)
                    {
                        Toast.makeText(this, "Không hợp lệ", Toast.LENGTH_SHORT).show();
                        AC();
                    }
                    dem++;
                }
            }
            else
            {
                if(!tvKQ.getText().toString().isEmpty())
                {
                    try
                    {
                        sothuhai = Double.parseDouble(tvKQ.getText().toString());
                    }catch (Exception e)
                    {
                        Toast.makeText(this, "Không hợp lệ", Toast.LENGTH_SHORT).show();
                        AC();
                    }
                    dau = btn.getText().toString();
                    sobandau=tinh();
                    btn=(Button) v;
                    dau = btn.getText().toString();
                }
            }
            KQ="";
            tvKQ.setText("");
        }
        if(v.getId()==R.id.dauBang && !tvKQ.getText().toString().isEmpty() && dem>0)
        {
            try
            {
                sothuhai = Double.parseDouble(tvKQ.getText().toString());
            }catch (Exception e)
            {
                Toast.makeText(this, "Không hợp lệ", Toast.LENGTH_SHORT).show();
                AC();
            }
            KQ="";
            dem=0;
            sobandau=tinh();
            tvKQ.setText(sobandau +"");
            dau="";
        }
        if(v.getId()==R.id.AC)
        {
            AC();
        }

    }
    void AC()
    {
        KQ="";
        tvKQ.setText("");
        dem=0;
    }
    double tinh()
    {
        if(dau.equals("+"))
        {
            return sobandau+sothuhai;
        }
        if(dau.equals("-"))
        {
            return sobandau-sothuhai;
        }
        if(dau.equals("*"))
        {
            return sobandau*sothuhai;
        }
        if(dau.equals("/"))
            return sobandau/sothuhai;
        return sobandau;
    }
}
