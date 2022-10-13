package com.revatureproj.models;

import java.util.Objects;

public class Users {


    private String first;

    private String last;

    private String username;

    private String password;

    private boolean isManager;

    private  int employee_id;

    public Users() {
    }

    public Users(String first, String last, String username, String password, boolean isManager, int employee_id) {
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.isManager = isManager;
        this.employee_id = employee_id;
    }

    public Users(int employee_id, String first, String last, String username, String password, boolean isManager) {
        this.employee_id = employee_id;
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    public Users(String first, String last, String username, String password, boolean isManager) {
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    public Users(String receivedFirst, String receivedLast, String receivedUsername, String receivedPassword) {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
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

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    @Override
    public String toString() {
        return "Users{" +
                "employee_id=" + employee_id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isManager=" + isManager +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return employee_id == users.employee_id && isManager == users.isManager && first.equals(users.first) && last.equals(users.last) && username.equals(users.username) && password.equals(users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, first, last, username, password, isManager);
    }
}
