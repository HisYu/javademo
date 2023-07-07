package bean;

public class User {
    private int userid;
    private String username;
    private  String userpwd;
    private String nameError;
    private String passwordError;

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public User(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    public boolean validate() {
        boolean isValid = true;

        if (username.trim().isEmpty()) {
            nameError = "请输入姓名";
            isValid = false;
        }

        if (userpwd.trim().isEmpty()) {
            passwordError = "请输入密码";
            isValid = false;
        } else if (userpwd.length() < 6 || userpwd.length() > 12) {
            passwordError = "密码长度必须在6到12位之间";
            isValid = false;
        }
        return isValid;
    }

}
