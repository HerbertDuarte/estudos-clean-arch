package entities;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String description;
    private User requester;
    private User assignee;
    private String status;
    private Date createdAt;
    private Date closesAt;

    public static class Builder {
        private String ticketId;
        private String description;
        private User requester;
        private User assignee;
        private String status;
        private Date createdAt;
        private Date closesAt;

        private Builder() {
        }

        public Builder ticketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder requester(User requester) {
            this.requester = requester;
            return this;
        }

        public Builder assignee(User assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder closesAt(Date closesAt) {
            this.closesAt = closesAt;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    private Ticket(Builder builder) {

        validate(builder);

        this.ticketId = builder.ticketId != null ? builder.ticketId : UUID.randomUUID().toString();
        this.description = builder.description;
        this.requester = builder.requester;
        this.assignee = builder.assignee;
        this.status = builder.status != null ? builder.status : "OPEN";
        this.createdAt = builder.createdAt != null ? builder.createdAt : new Date();
        this.closesAt = builder.closesAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void assignUser(User user) {
        if (this.assignee != null) {
            throw new IllegalArgumentException("Ticket already assigned.");
        }

        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        this.assignee = user;
        this.status = "ASSIGNED";
    }

    public void close() {
        if (this.status.equals("OPEN")) {
            throw new IllegalArgumentException("Ticket is not assigned.");
        }
        this.status = "CLOSED";
        this.closesAt = new Date();
    }

    private void validate(Builder builder) {
        if (this.requester == null) {
            throw new IllegalArgumentException("Requester is required.");
        }

        if (this.description == null) {
            throw new IllegalArgumentException("Description is required.");
        }
    }

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId + ", description=" + description + ", requester=" + requester
                + ", assignee=" + assignee + ", status=" + status + ", createdAt=" + createdAt + ", closesAt="
                + closesAt + "]";
    }

}
