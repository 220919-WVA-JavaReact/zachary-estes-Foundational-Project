package com.revature.models;

import java.util.Objects;

public class Users {

    private int employeeId;

    private String first;

    private String last;

    private String username;

    private String password;

    private boolean isManager;

    public Users(int employeeId, String first, String last, String username, String password, boolean isManager) {
        this.employeeId = employeeId;
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
                "employeeId=" + employeeId +
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
        return employeeId == users.employeeId && isManager == users.isManager && first.equals(users.first) && last.equals(users.last) && username.equals(users.username) && password.equals(users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, first, last, username, password, isManager);
    }

}
