package tn.esprit.authservice.models;

import java.util.List;

public record UserRecord(String username, String email, String password, String firstName, String lastName, List<String> roles) {}

