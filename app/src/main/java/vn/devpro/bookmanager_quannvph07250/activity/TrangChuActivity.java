package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.devpro.bookmanager_quannvph07250.R;

public class TrangChuActivity extends AppCompatActivity {

    ImageView imgSpecies, imgBook, imgUser, imgInvoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        setTitle("QUẢN LÝ SÁCH");

        imgSpecies = findViewById(R.id.imgSpecies);
        imgBook = findViewById(R.id.imgBook);
        imgUser = findViewById(R.id.imgUser);
        imgInvoice = findViewById(R.id.imgInvoice);

        imgSpecies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), TheLoaiActivity.class));
            }
        });

        imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SachActivity.class));
            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), NguoiDungActivity.class));
            }
        });

        imgInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), HoaDonActivity.class));
            }
        });
    }
}
