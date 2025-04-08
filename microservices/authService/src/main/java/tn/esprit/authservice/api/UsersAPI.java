package tn.esprit.authservice.api;


import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.authservice.models.UserDTO;
import tn.esprit.authservice.models.UserRecord;
import tn.esprit.authservice.services.contrat.UserServiceContrat;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
//@SecurityRequirement(name = "BearerAuth")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UsersAPI {
    private final UserServiceContrat userServiceContrat;
    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody UserRecord newUserRecord) {
        userServiceContrat.createUser(newUserRecord);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/addClient")
    public ResponseEntity<?> addClientUser(@RequestBody UserRecord newUserRecord) {
        userServiceContrat.createClientAccount(newUserRecord);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


//    @PutMapping("/{id}/send-verification-email")
//    public ResponseEntity<?> sendVerificationEmail(@PathVariable String id) {
//
//        userServiceContrat.sendVerificationEmail(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {

        userServiceContrat.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userServiceContrat.getAllUsers();
        return ResponseEntity.ok(users);
    }


//    @GetMapping("/helper/{id}")
//    public ResponseEntity<UserRepresentation> getUserHelper(@PathVariable String id) {
//        UserResource userResource = userServiceContrat.getUserHelper(id);
//        UserRepresentation user = userResource.toRepresentation();
//        return ResponseEntity.ok(user);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        UserDTO userDTO = userServiceContrat.getUser(id);
        return ResponseEntity.ok(userDTO);
    }



    @PutMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {

        userServiceContrat.forgotPassword(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}/roles")
    public ResponseEntity<?> getUserRoleEndpoint(@PathVariable String id) {

        return ResponseEntity.status(HttpStatus.OK).body(userServiceContrat.getUserRoleEndpoint(id));
    }

//    @GetMapping("/{id}/groups")
//    public ResponseEntity<?> getUserGroups(@PathVariable String id) {
//
//        return ResponseEntity.status(HttpStatus.OK).body(userServiceContrat.getUserGroups(id));
//    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable String userId,
            @RequestBody UserRecord updatedUser
    ) {
        userServiceContrat.updateUser(userId, updatedUser);
        return ResponseEntity.ok().build();
    }


}

