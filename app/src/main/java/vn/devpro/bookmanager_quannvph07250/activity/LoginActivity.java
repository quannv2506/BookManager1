package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import vn.devpro.bookmanager_quannvph07250.R;
import vn.devpro.bookmanager_quannvph07250.dao.NguoiDungDAO;
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;

public class LoginActivity extends AppCompatActivity {

    private EditText edUser, edPass;
    private Button btnLogin, btnCancel;
    private CheckBox chkRemember;
    NguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("BookManager");
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        chkRemember = findViewById(R.id.chkRemember);

    }

    public void openNew(View view) {
        nguoiDungDAO = new NguoiDungDAO(this);
        String username = edUser.getText().toString();
        String password = edPass.getText().toString();
        NguoiDung nguoiDung = new NguoiDung(username, password);
        boolean result = nguoiDungDAO.isLogin(nguoiDung);

        if (result){
            Toast.makeText(getBaseContext(), "Login thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getBaseContext(), TrangChuActivity.class));
        } else {
            Toast.makeText(getBaseContext(), "Login không thành công", Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view) {
        edUser.setText("");
        edPass.setText("");
    }

//    public void rememberU
}
