package com.revatureproj.models;

import java.util.Objects;

public class Tickets {

    private int ticketId;

    private String ticketStatus;

    private int dollarAmount;

    private String description;

    private Users users;
    private String username;

    public Tickets() {
    }

    public Tickets(int dollarAmount, String description, String username) {
        this.dollarAmount = dollarAmount;
        this.description = description;
        this.username = username;
    }

    public Tickets(int dollarAmount, String description, Users users) {
        this.dollarAmount = dollarAmount;
        this.description = description;
        this.users = users;
    }

    public Tickets(String username, int dollarAmount, String description) {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getDollarAmount() {
        return dollarAmount;
    }

    public void setDollarAmount(int dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", dollarAmount=" + dollarAmount +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return ticketId == tickets.ticketId && dollarAmount == tickets.dollarAmount && ticketStatus.equals(tickets.ticketStatus) && description.equals(tickets.description) && users.equals(tickets.users) && username.equals(tickets.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, ticketStatus, dollarAmount, description, users, username);
    }
}
