package vn.devpro.bookmanager_quannvph07250.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import vn.devpro.bookmanager_quannvph07250.R;
import vn.devpro.bookmanager_quannvph07250.adapter.NguoiDungAdapter;
import vn.devpro.bookmanager_quannvph07250.adapter.TheLoaiAdapter;
import vn.devpro.bookmanager_quannvph07250.dao.TheLoaiDAO;
import vn.devpro.bookmanager_quannvph07250.model.TheLoai;

public class ListTheLoaiActivity extends AppCompatActivity {

    ListView lvTheLoai;
    TheLoaiDAO theLoaiDAO;
    TheLoaiAdapter theLoaiAdapter;
    List<TheLoai> theLoaiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);
        setTitle("Thế loại");


        lvTheLoai = findViewById(R.id.lvTheLoai);
        theLoaiDAO = new TheLoaiDAO(this);
        theLoaiList = theLoaiDAO.getAllTheLoai();

        theLoaiAdapter = new TheLoaiAdapter(theLoaiList, ListTheLoaiActivity.this);
        lvTheLoai.setAdapter(theLoaiAdapter);

        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = view.getContext();
                Intent intent = new Intent(context, UpdateTheLoaiActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("maLoai_key", String.valueOf(theLoaiList.get(position).getMaTheLoai()));
                bundle.putString("tenLoai_key", theLoaiList.get(position).getTenTheLoai());
                bundle.putString("viTri_key", theLoaiList.get(position).getViTri());
                bundle.putString("mota_key", theLoaiList.get(position).getMoTa());
                intent.putExtra("bundleTL", bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnAddTheLoai:
                startActivity(new Intent(getBaseContext(), TheLoaiActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_list_the_loai, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
