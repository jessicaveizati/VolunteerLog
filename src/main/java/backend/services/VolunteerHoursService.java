package backend.services;

import backend.repositories.VolunteerHoursRepo;

public class VolunteerHoursService {

    private final VolunteerHoursRepo repo;

    public VolunteerHoursService(VolunteerHoursRepo repo) {
        this.repo = repo;
    }

    // Returns total hours for a user by name
    public int getTotalVolunteerHoursForUser(String userName) {
        return repo.getTotalVolunteerHoursForUser(userName);
    }
}