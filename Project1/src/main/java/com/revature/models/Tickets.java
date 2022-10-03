package com.revature.models;

import java.util.Objects;

public class Tickets {

    private int ticketId;

    private int dollarAmount;

    private String description;

    private String ticketStatus;

    public Tickets(int ticketId, int dollarAmount, String description, String ticketStatus) {
        this.ticketId = ticketId;
        this.dollarAmount = dollarAmount;
        this.description = description;
        this.ticketStatus = ticketStatus;
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

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", dollarAmount=" + dollarAmount +
                ", description='" + description + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return ticketId == tickets.ticketId && dollarAmount == tickets.dollarAmount && description.equals(tickets.description) && ticketStatus.equals(tickets.ticketStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, dollarAmount, description, ticketStatus);
    }
}

