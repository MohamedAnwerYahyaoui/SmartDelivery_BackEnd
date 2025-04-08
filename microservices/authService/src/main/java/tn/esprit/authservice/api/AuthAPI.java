package tn.esprit.authservice.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.authservice.models.LoginRecord;
import tn.esprit.authservice.services.impl.AuthServiceImpl;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthAPI {

    //  private final AuthServiceContrat authService;
    private final AuthServiceImpl authServiceImp;






    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRecord loginRequest) {
        return authServiceImp.login(loginRequest);

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam("refresh_token") String refreshToken) {
        return authServiceImp.logout(refreshToken);
    }


}

