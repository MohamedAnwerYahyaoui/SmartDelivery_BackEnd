package tn.esprit.authservice.services.contrat;

import tn.esprit.authservice.models.RoleDTO;
import tn.esprit.authservice.models.RoleRecord;

import java.util.List;

public interface RoleServiceContrat {
    void createRole(RoleRecord newRole);
    void deleteRole(String roleName);
    public List<RoleDTO> getAllRoles();
    void assignRole(String userId ,String roleName);
    void deleteRoleFromUser(String userId ,String roleName);

    public void updateRole(String originalRoleName, RoleRecord updatedRole);
    public RoleDTO getRoleByName(String roleName);
    public RoleDTO getRoleById(String roleId);
}
