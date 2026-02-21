package models;

public record VolunteerHours(int id, int user_id, int organization_id, String date, int hours) {
}
