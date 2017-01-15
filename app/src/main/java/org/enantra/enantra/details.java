package org.enantra.enantra;

import com.google.gson.annotations.SerializedName;

/**
 * Created by theMachine on 14-01-2017.
 */
public class details {
    @SerializedName("name")
    String name;
    @SerializedName("gender")
    String gender;
    @SerializedName("age")
    String age;
    @SerializedName("email")
    String email;
    @SerializedName("phone")
    String phone;
    @SerializedName("place")
    String place;
    @SerializedName("student")
    String student;
    @SerializedName("organization")
    String org;
    @SerializedName("referalId")
    String ref;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
