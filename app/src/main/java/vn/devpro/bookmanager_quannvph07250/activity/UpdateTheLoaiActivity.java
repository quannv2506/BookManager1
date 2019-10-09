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

public class UpdateTheLoaiActivity extends AppCompatActivity {

    EditText edtTenTheLoai, edtViTri, edtMoTa, edtMaTheLoai;
    Button btnSuaTheLoai, btnHuy;

    TheLoaiDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_the_loai);

        edtTenTheLoai = findViewById(R.id.edTenTheLoai);
        edtMaTheLoai = findViewById(R.id.edMaTheLoai);
        edtViTri = findViewById(R.id.edViTri);
        edtMoTa = findViewById(R.id.edMoTa);
        btnSuaTheLoai = findViewById(R.id.btnSuaTheLoai);
        btnHuy = findViewById(R.id.btnHuyTL);


        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("bundleTL");
        if (bundle != null) {
            edtTenTheLoai.setText(bundle.getString("tenLoai_key"));
            edtViTri.setText(bundle.getString("viTri_key"));
            edtMoTa.setText(bundle.getString("mota_key"));
            edtMaTheLoai.setText(bundle.getString("maLoai_key"));
        }

        btnSuaTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenLoai = edtTenTheLoai.getText().toString();
                String viTri = edtViTri.getText().toString();
                String mota = edtMoTa.getText().toString();
                String maLoai = edtMaTheLoai.getText().toString();

                theLoaiDAO = new TheLoaiDAO(UpdateTheLoaiActivity.this);
                TheLoai theLoai = new TheLoai(Integer.valueOf(maLoai), tenLoai, viTri, mota);
                long result = theLoaiDAO.updateTheLoai(theLoai);
                if (result > 0) {
                    Toast.makeText(getBaseContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), ListTheLoaiActivity.class));
                } else {
                    Toast.makeText(getBaseContext(), "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListTheLoaiActivity.class));
            }
        });

    }
}
