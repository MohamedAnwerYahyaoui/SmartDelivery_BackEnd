package tn.esprit.authservice.services.contrat;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import tn.esprit.authservice.models.UserDTO;
import tn.esprit.authservice.models.UserRecord;

import java.util.List;

public interface UserServiceContrat {
    void createUser(UserRecord newUserRecord);

    public void createClientAccount(UserRecord newUserRecord);
    void sendVerificationEmail(String userId);
    void deleteUser(String userId);
    void forgotPassword(String email);
    UserDTO getUser(String userId);
    List<RoleRepresentation> getUserRoleEndpoint(String userId);
    List<GroupRepresentation> getUserGroups(String userId);

    public List<UserDTO> getAllUsers();
    public UserResource getUserHelper(String userId);

    public void updateUser(String userId, UserRecord updatedUser);

}
