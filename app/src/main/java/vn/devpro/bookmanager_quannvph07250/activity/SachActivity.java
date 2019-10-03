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

public class SachActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] subject = {"Công nghệ thông tin", "Đồ họa", "Marketing", "Du lịch"};
    ImageView imgAddTheLoail;
    Spinner spnSpecies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        imgAddTheLoail = findViewById(R.id.imgAddTheLoai);
        spnSpecies = findViewById(R.id.spnSpecies);

        imgAddTheLoail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), TheLoaiActivity.class));
            }
        });

//        spnSpecies.setOnItemClickListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, subject);
        spnSpecies.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
