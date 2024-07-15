package entities;

import java.util.UUID;

public class User {
    private String userId;
    private String name;

    public static class Builder {
        private String userId;
        private String name;

        public Builder() {
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.userId = builder.userId != null ? builder.userId : UUID.randomUUID().toString();
        this.name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
