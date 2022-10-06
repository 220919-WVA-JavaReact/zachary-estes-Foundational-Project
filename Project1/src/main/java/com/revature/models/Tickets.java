package com.revature.models;

import java.util.Objects;

public class Tickets {

    private int ticketId;

    private String ticketStatus;

    private int dollarAmount;

    private String description;

    private Users user;

    public Tickets() {
    }

    public Tickets(int ticketId, int dollarAmount, String description, String ticketStatus, Users user) {
        this.ticketId = ticketId;
        this.dollarAmount = dollarAmount;
        this.description = description;
        this.ticketStatus = ticketStatus;
        this.user = user;
    }

    public Tickets(int ticketId, int dollarAmount, String description, String ticketStatus) {
        this.ticketId = ticketId;
        this.dollarAmount = dollarAmount;
        this.description = description;
        this.ticketStatus = ticketStatus;
    }

    public Tickets(int dollarAmount, String description, Users user) {
        this.dollarAmount = dollarAmount;
        this.description = description;
        this.user = user;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", dollarAmount=" + dollarAmount +
                ", description='" + description + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return ticketId == tickets.ticketId && dollarAmount == tickets.dollarAmount && description.equals(tickets.description) && ticketStatus.equals(tickets.ticketStatus) && user.equals(tickets.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, dollarAmount, description, ticketStatus, user);
    }
}

