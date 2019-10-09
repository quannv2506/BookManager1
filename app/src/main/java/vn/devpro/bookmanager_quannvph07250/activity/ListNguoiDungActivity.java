package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.List;

import vn.devpro.bookmanager_quannvph07250.R;
import vn.devpro.bookmanager_quannvph07250.dao.NguoiDungDAO;
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;
import vn.devpro.bookmanager_quannvph07250.adapter.NguoiDungAdapter;

public class ListNguoiDungActivity extends AppCompatActivity {
    NguoiDungDAO nguoiDungDAO;
    ListView lvUser;
    NguoiDungAdapter nguoiDungAdapter;
    List<NguoiDung> nguoiDungList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        setTitle("Người dùng");

        lvUser = findViewById(R.id.lvUser);

        nguoiDungDAO = new NguoiDungDAO(this);
        nguoiDungList = nguoiDungDAO.getAllNguoiDung();

        nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList, ListNguoiDungActivity.this);
        lvUser.setAdapter(nguoiDungAdapter);

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = view.getContext();
                Intent intent = new Intent(context, UpdateNguoiDungActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username_key", nguoiDungList.get(position).getUsername());
                bundle.putString("password_key", nguoiDungList.get(position).getPassword());
                bundle.putString("phone_key", nguoiDungList.get(position).getPhone());
                bundle.putString("fullName_key", nguoiDungList.get(position).getFullName());
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnAddUser:
                startActivity(new Intent(getBaseContext(), NguoiDungActivity.class));
                break;
            case R.id.mnChangePass:
                startActivity(new Intent(getBaseContext(), ChangePasssActivity.class));
                break;
            case R.id.mnLogOut:

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_user, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
