package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.devpro.bookmanager_quannvph07250.R;
import vn.devpro.bookmanager_quannvph07250.dao.NguoiDungDAO;
import vn.devpro.bookmanager_quannvph07250.dao.TheLoaiDAO;
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;
import vn.devpro.bookmanager_quannvph07250.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {

    TheLoaiDAO theLoaiDAO;

    EditText edtTenTheLoai, edtMoTa, edtViTri;
    Button btnThemTheLoai, btnHuyTheLoai, btnShowTheLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);


        edtTenTheLoai = findViewById(R.id.edtTenTheLoai);
        edtMoTa = findViewById(R.id.edtMoTa);
        edtViTri = findViewById(R.id.edtViTri);
        btnThemTheLoai = findViewById(R.id.btnThemTheLoai);
        btnHuyTheLoai = findViewById(R.id.btnHuyTheLoai);
        btnShowTheLoai = findViewById(R.id.btnShowTheLoai);

        if (edtTenTheLoai.length() == 0 && edtViTri.length() == 0 && edtMoTa.length() == 0) {
            btnThemTheLoai.setText("Thêm");
        } else {
            btnThemTheLoai.setText("Sửa");
        }

        btnShowTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListTheLoaiActivity.class));
            }
        });
    }


    public void addTheLoai(View view) {
        String tenTheLoai = edtTenTheLoai.getText().toString();
        String moTa = edtMoTa.getText().toString();
        String viTri = edtViTri.getText().toString();

        theLoaiDAO = new TheLoaiDAO(this);
        TheLoai theLoai = new TheLoai(tenTheLoai, viTri, moTa);

        long result = theLoaiDAO.insertTheLoai(theLoai);
        if (result > 0) {
            Toast.makeText(this, "Thêm thể loại thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();

        }
    }

    public void clearTheLoai(View view) {
    }

    public void showTheLoai(View view) {
    }
}
