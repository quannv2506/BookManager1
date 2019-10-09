package vn.devpro.bookmanager_quannvph07250.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.devpro.bookmanager_quannvph07250.R;
import vn.devpro.bookmanager_quannvph07250.dao.NguoiDungDAO;
import vn.devpro.bookmanager_quannvph07250.dao.TheLoaiDAO;
import vn.devpro.bookmanager_quannvph07250.model.TheLoai;

public class TheLoaiAdapter extends BaseAdapter {

    List<TheLoai> theLoaiList;
    TheLoaiDAO theLoaiDAO;
    Context context;

    public TheLoaiAdapter(List<TheLoai> theLoaiList, Context context) {
        this.theLoaiList = theLoaiList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
    }

    @Override
    public Object getItem(int position) {
        return theLoaiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.item_the_loai, parent, false);
        TextView tvMaTheLoai = convertView.findViewById(R.id.tvMaTheLoai);
        TextView tvTenTheLoai = convertView.findViewById(R.id.tvTenTheLoai);
        ImageView imgDeleteTheLoai = convertView.findViewById(R.id.imgDeleteTheLoai);

        final TheLoai theLoai = theLoaiList.get(position);

        tvMaTheLoai.setText(String.valueOf(theLoai.getMaTheLoai()));
        tvTenTheLoai.setText(theLoai.getTenTheLoai());

        imgDeleteTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theLoaiDAO = new TheLoaiDAO(context);
                theLoaiDAO.deleteTheLoai(theLoaiList.get(position).getMaTheLoai());
                theLoaiList.remove(theLoai);
                notifyDataSetChanged();
            }
        });

        return convertView;

    }
}
