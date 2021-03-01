package com.mustafaseyrek.tcnohesapla;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHesapla = findViewById(R.id.btnHesapla);
        final TextView txtTc = findViewById(R.id.textTc);
        final TextInputEditText editInput = findViewById(R.id.editInput);

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dokuzHane = editInput.getText().toString();
                if (dokuzHane.length() == 9 && dokuzHane.charAt(0) != '0') {
                    int onuncu = 0;
                    int hesap1 = 0;
                    int hesap2 = 0;
                    for (int i = 0; i < 9; i++) {
                        if (i % 2 == 0) {//1 3 5 7 9 haneler
                            hesap1 += Integer.parseInt(String.valueOf(dokuzHane.charAt(i)));
                        } else { // 2 4 6 8 haneler
                            hesap2 += Integer.parseInt(String.valueOf(dokuzHane.charAt(i)));
                        }
                    }
                    onuncu = (hesap1 * 7 - hesap2) % 10;
                    String no = dokuzHane + onuncu + ((hesap1 + hesap2 + onuncu) % 10);

                     txtTc.setText( Html.fromHtml("TC kimlik numaranız <font color='#30d5c8'>"+no+"</font> olarak bulunmuştur."));
                } else {
                    Toast.makeText(MainActivity.this, "Lütfen ilk 9 haneyi doğru şekilde giriniz!", Toast.LENGTH_SHORT).show();
                    editInput.setText("");
                    txtTc.setText("");
                }
            }
        });

    }
}
