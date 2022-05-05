package haroo.domain;

import java.io.Serializable;

public class EmployeeVO implements Serializable {
    private int em_no;//사원 번호
    private int po_no;//직책 번호
    private int de_no;//부서 번호
    private String em_name;//사원이름
    private String em_ext;//내선 전화
    private String em_phone;//휴대 전화
    private String em_email;//이메일
    private String em_first;//입사일
    private String em_last;//퇴사일
    private int au_no;//권한 번호
    private String em_pw;//비밀번호

    public EmployeeVO() {}

    public EmployeeVO(int em_no, int po_no, int de_no, String em_name, String em_ext, String em_phone, String em_email, String em_first, String em_last, int au_no, String em_pw) {
        this.em_no = em_no;
        this.po_no = po_no;
        this.de_no = de_no;
        this.em_name = em_name;
        this.em_ext = em_ext;
        this.em_phone = em_phone;
        this.em_email = em_email;
        this.em_first = em_first;
        this.em_last = em_last;
        this.au_no = au_no;
        this.em_pw = em_pw;
    }

    public int getEm_no() {
        return em_no;
    }

    public void setEm_no(int em_no) {
        this.em_no = em_no;
    }

    public int getPo_no() {
        return po_no;
    }

    public void setPo_no(int po_no) {
        this.po_no = po_no;
    }

    public int getDe_no() {
        return de_no;
    }

    public void setDe_no(int de_no) {
        this.de_no = de_no;
    }

    public String getEm_ext() {
        return em_ext;
    }

    public void setEm_ext(String em_ext) {
        this.em_ext = em_ext;
    }

    public String getEm_phone() {
        return em_phone;
    }

    public void setEm_phone(String em_phone) {
        this.em_phone = em_phone;
    }

    public String getEm_email() {
        return em_email;
    }

    public void setEm_email(String em_email) {
        this.em_email = em_email;
    }

    public String getEm_first() {
        return em_first;
    }

    public void setEm_first(String em_first) {
        this.em_first = em_first;
    }

    public String getEm_last() {
        return em_last;
    }

    public void setEm_last(String em_last) {
        this.em_last = em_last;
    }

    public int getAu_no() {
        return au_no;
    }

    public void setAu_no(int au_no) {
        this.au_no = au_no;
    }

    public String getEm_pw() {
        return em_pw;
    }

    public void setEm_pw(String em_pw) {
        this.em_pw = em_pw;
    }

    public String getEm_name() {
        return em_name;
    }

    public void setEm_name(String em_name) {
        this.em_name = em_name;
    }
}
