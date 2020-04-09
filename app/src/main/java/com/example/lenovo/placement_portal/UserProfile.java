package com.example.lenovo.placement_portal;

public class UserProfile {
    public String userCGPA;
    public String userSkills;
    public String userEmail;
    public String userName;

    public UserProfile(){
    }

    public UserProfile(String userCGPA,String userSkills, String userEmail, String userName) {
        this.userCGPA = userCGPA;
        this.userSkills= userSkills;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserCGPA() {
        return userCGPA;
    }

    public void setUserCGPA(String userCGPA) {
        this.userCGPA = userCGPA;
    }
    public String getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(String userSkills) {
        this.userSkills = userSkills;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}