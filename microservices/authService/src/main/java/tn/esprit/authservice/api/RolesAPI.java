package tn.esprit.authservice.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.authservice.models.RoleDTO;
import tn.esprit.authservice.models.RoleRecord;
import tn.esprit.authservice.services.contrat.RoleServiceContrat;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import java.util.Map;
//@SecurityRequirement(name = "BearerAuth")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/roles")
public class RolesAPI {

    private final RoleServiceContrat roleService;
//

    @PostMapping("/add")
    public ResponseEntity<?> createRole(@RequestBody RoleRecord newRoleRecord) {

        roleService.createRole(newRoleRecord);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{roleName}")
    public ResponseEntity<?> deleteRole(@PathVariable String roleName) {

        roleService.deleteRole(roleName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }



    @PutMapping("/assign/users/{userId}")
    public ResponseEntity<?> assignRole(@PathVariable String userId, @RequestParam String roleName) {
        try {
            roleService.assignRole(userId, roleName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/remove/users/{userId}")
    public ResponseEntity<?> unAssignRole(@PathVariable String userId, @RequestParam String roleName) {
        try {
            roleService.deleteRoleFromUser(userId, roleName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{originalRoleName}")
    public ResponseEntity<?> updateRole(
            @PathVariable String originalRoleName,
            @RequestBody RoleRecord updatedRole
    ) {
        roleService.updateRole(originalRoleName, updatedRole);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/role/{roleName}")
    public ResponseEntity<RoleDTO> getRoleByName(@PathVariable String roleName) {
        RoleDTO roleDTO = roleService.getRoleByName(roleName);
        return ResponseEntity.ok(roleDTO);
    }

    @GetMapping("/id/{roleId}")
    public ResponseEntity<?> getRoleById(@PathVariable String roleId) {
        try {
            RoleDTO roleDTO = roleService.getRoleById(roleId);
            return ResponseEntity.ok(roleDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", e.getMessage()));
        }
    }


}

