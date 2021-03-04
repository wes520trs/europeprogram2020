package com.unitedcoder.regression.homework.sprint5;

public class TestDataHolder {
    private String firstName;
    private String lastName;
    private String email;
    private String catName;

    public TestDataHolder(String firstName, String lastName, String email, String catName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.catName = catName;
    }

    public TestDataHolder() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
