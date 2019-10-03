package vn.devpro.bookmanager_quannvph07250.model;

public class NguoiDung {
    public String username;
    public String password;
    public String phone;
    public String fullName;

    public NguoiDung(String username, String password, String phone, String fullName) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.fullName = fullName;
    }

    public NguoiDung(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public NguoiDung() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
