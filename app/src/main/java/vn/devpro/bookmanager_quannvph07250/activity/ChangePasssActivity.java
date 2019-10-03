package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import vn.devpro.bookmanager_quannvph07250.R;
import vn.devpro.bookmanager_quannvph07250.dao.NguoiDungDAO;
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;

public class ChangePasssActivity extends AppCompatActivity {

    NguoiDungDAO nguoiDungDAO;
    EditText edtPass, edtChangePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passs);

        edtPass = findViewById(R.id.edtPass);
        edtChangePass = findViewById(R.id.edtChangePass);
    }

    public void changePassword(View view) {
        nguoiDungDAO = new NguoiDungDAO(this);

        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        String username = pref.getString("USERNAME", "");
        String password = edtPass.getText().toString();

        NguoiDung nguoiDung = new NguoiDung(username, password);
        if (nguoiDungDAO.isChangePassword(nguoiDung)){
            Toast.makeText(getBaseContext(), "Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
        } else {
            Toast.makeText(getBaseContext(), "Thay đổi mật khẩu không thành công", Toast.LENGTH_SHORT).show();
        }
    }
}
