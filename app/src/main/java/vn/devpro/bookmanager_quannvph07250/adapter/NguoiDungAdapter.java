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
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;

public class NguoiDungAdapter extends BaseAdapter {

    List<NguoiDung> nguoiDungList;
    NguoiDungDAO nguoiDungDAO;
    Context context;
//    NguoiDung nguoiDung;

    public NguoiDungAdapter(List<NguoiDung> nguoiDungList, Context context) {
        this.nguoiDungList = nguoiDungList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return nguoiDungList.size();
    }

    @Override
    public Object getItem(int i) {
        return nguoiDungList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.item_nguoidung_list, viewGroup, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvPhone);
        ImageView imgUser = view.findViewById(R.id.imgUser);
        ImageView imgDeleteUser = view.findViewById(R.id.imgDeleteUser);

        final NguoiDung nguoiDung =nguoiDungList.get(i);

        tvName.setText(nguoiDung.getUsername());
        tvPhone.setText(nguoiDung.getPhone());



        imgDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nguoiDungDAO = new NguoiDungDAO(context);
                nguoiDungDAO.deleteUser(nguoiDungList.get(i).getUsername());
//                NguoiDung nguoiDung = nguoiDungList.get(i);
                nguoiDungList.remove(nguoiDung);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
