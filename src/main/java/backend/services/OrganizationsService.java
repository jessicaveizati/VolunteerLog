package backend.services;

import backend.repositories.OrganizationsRepo;
import backend.repositories.UsersRepo;
import models.Organizations;
import models.Users;

import java.util.List;
public class OrganizationsService {
    private final OrganizationsRepo repo;

    public OrganizationsService(OrganizationsRepo organizationsRepo) {
        repo = organizationsRepo;
    }

    public List<Organizations> getAllOrganizations() {
        return repo.getOrganizations();
    }
}
