package tn.esprit.authservice.services.contrat;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import tn.esprit.authservice.models.UserDTO;

import java.util.List;

public interface UserService {
    void createUser(UserDTO newUserRecord);
    void sendVerificationEmail(String userId);
    void deleteUser(String userId);
    void forgotPassword(String username);
    UserResource getUser(String userId);
    List<RoleRepresentation> getUserRoles(String userId);
    List<GroupRepresentation> getUserGroups(String userId);

}
