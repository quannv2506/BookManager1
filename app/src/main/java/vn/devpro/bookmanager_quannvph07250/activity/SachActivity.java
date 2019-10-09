package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import vn.devpro.bookmanager_quannvph07250.R;

public class SachActivity extends AppCompatActivity {


    ImageView imgAddTheLoail;
    Spinner spnLoaiSach;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        imgAddTheLoail = findViewById(R.id.imgAddTheLoai);
        spnLoaiSach = findViewById(R.id.spnSpecies);

        imgAddTheLoail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), TheLoaiActivity.class));
            }
        });




    }

}
