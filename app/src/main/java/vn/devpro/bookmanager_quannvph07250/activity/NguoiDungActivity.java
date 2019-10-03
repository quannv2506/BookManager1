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

public class NguoiDungActivity extends AppCompatActivity {

//    private DatabaseHelper dbManager;
    private NguoiDungDAO nguoiDungDAO;
    Button btnListUser;
    EditText edtUser, edtPass, edtRememPass, edtPhone, edtFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);

        btnListUser = findViewById(R.id.btnShowUser);
        edtUser = findViewById(R.id.edtUpUser);
        edtPass = findViewById(R.id.edtUpPass);
        edtRememPass = findViewById(R.id.edtPassword3);
        edtPhone = findViewById(R.id.edtUpPhone);
        edtFullName = findViewById(R.id.edtUpName);

        btnListUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), ListNguoiDungActivity.class));
            }
        });


    }

    public void addUsers(View view) {
        String user = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        String remPass = edtRememPass.getText().toString();
        String phone = edtPhone.getText().toString();
        String fullName = edtFullName.getText().toString();
        if (!pass.equals(remPass)) {
            Toast.makeText(getBaseContext(), "Mật khẩu nhập lại phải giống mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        } else {
            nguoiDungDAO = new NguoiDungDAO(this);
            NguoiDung nd = new NguoiDung();
            nd.username = user;
            nd.password = pass;
            nd.phone = phone;
            nd.fullName = fullName;
            long result = nguoiDungDAO.insertUser(nd);
            if (result > 0) {
                Toast.makeText(this, "Lưu thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Lưu thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void clearUser(View view) {
        edtUser.setText("");
        edtPass.setText("");
        edtRememPass.setText("");
        edtPhone.setText("");
        edtFullName.setText("");
    }


}
