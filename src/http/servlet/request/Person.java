package http.servlet.request;

import java.util.Arrays;

public class Person {
    private String[] hobby;
    private String username;
    private String sex;
    private String pwd;
    private String city;

    @Override
    public String toString() {
        return "Person{" +
                "hobby=" + Arrays.toString(hobby) +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
