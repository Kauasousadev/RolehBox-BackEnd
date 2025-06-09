package edu.kaua.helpencontro.models.user;

public enum UserRole {
    USER("user"),
    MODERATOR("moderator"),
    ADMIN("admin");

    private String role;

    private UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
