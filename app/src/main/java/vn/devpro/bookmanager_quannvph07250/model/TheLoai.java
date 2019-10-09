package vn.devpro.bookmanager_quannvph07250.model;

public class TheLoai {
    public int maTheLoai;
    public String tenTheLoai;
    public String viTri;
    public String moTa;

    public TheLoai(int maTheLoai, String tenTheLoai, String viTri, String moTa) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.viTri = viTri;
        this.moTa = moTa;
    }

    public TheLoai(String tenTheLoai, String viTri, String moTa) {
        this.tenTheLoai = tenTheLoai;
        this.viTri = viTri;
        this.moTa = moTa;
    }

    public TheLoai() {
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
