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
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;

public class UpdateNguoiDungActivity extends AppCompatActivity {

    Button btnShowUser, btnUpUser, btnCancelUp;
    EditText edtUpUser, edtUpPass, edtUpPhone, edtUpName;
    NguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_nguoi_dung);

        btnShowUser = findViewById(R.id.btnShowUser);
        btnUpUser = findViewById(R.id.btnUpUser);
        btnCancelUp = findViewById(R.id.btnCancelUp);
        edtUpUser = findViewById(R.id.edtUpUser);
        edtUpPass = findViewById(R.id.edtUpPass);
        edtUpPhone = findViewById(R.id.edtUpPhone);
        edtUpName = findViewById(R.id.edtUpName);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle != null) {
            edtUpUser.setText(bundle.getString("username_key"));
            edtUpPass.setText(bundle.getString("password_key"));
            edtUpPhone.setText(bundle.getString("phone_key"));
            edtUpName.setText(bundle.getString("fullName_key"));
        }

        btnShowUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListNguoiDungActivity.class));
            }
        });

        btnCancelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListNguoiDungActivity.class));
            }
        });

        btnUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUpUser.getText().toString();
                String pass = edtUpPass.getText().toString();
                String phone = edtUpPhone.getText().toString();
                String fullName = edtUpName.getText().toString();

                nguoiDungDAO = new NguoiDungDAO(UpdateNguoiDungActivity.this);
                NguoiDung nd = new NguoiDung(user, pass, phone, fullName);
//                nd.username = user;
//                nd.password = pass;
//                nd.phone = phone;
//                nd.fullName = fullName;
                long result = nguoiDungDAO.updateUser(user, phone, fullName);
                if (result > 0) {
                    Toast.makeText(UpdateNguoiDungActivity.this, "Update thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateNguoiDungActivity.this, "Update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
