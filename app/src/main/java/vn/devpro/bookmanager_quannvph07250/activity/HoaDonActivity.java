package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.devpro.bookmanager_quannvph07250.R;

public class HoaDonActivity extends AppCompatActivity {

    ImageView imgAddHD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        imgAddHD = findViewById(R.id.imgAddHD);

        imgAddHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), ThemHDActivity.class));
            }
        });
    }
}
