package net.softsociety.spring3.domain;

public class Member {
    // 멤버 변수(=인스턴스 변수)
    private String usrid;
    private String usrpwd;
    private String usrname;
    private String usrcompany;
    private String phone;

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getUsrpwd() {
        return usrpwd;
    }

    public void setUsrpwd(String usrpwd) {
        this.usrpwd = usrpwd;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getUsrcompany() {
        return usrcompany;
    }

    public void setUsrcompany(String usrcompany) {
        this.usrcompany = usrcompany;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Member(String usrid, String usrpwd, String usrname, String usrcompany, String phone) {
        this.usrid = usrid;
        this.usrpwd = usrpwd;
        this.usrname = usrname;
        this.usrcompany = usrcompany;
        this.phone = phone;
    }

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "usrid='" + usrid + '\'' +
                ", usrpwd='" + usrpwd + '\'' +
                ", usrname='" + usrname + '\'' +
                ", usrcompany='" + usrcompany + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
