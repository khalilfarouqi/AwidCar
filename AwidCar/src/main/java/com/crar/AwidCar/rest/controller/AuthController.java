package com.crar.AwidCar.rest.controller;

import com.crar.AwidCar.jwt.payload.request.SignupRequest;
import com.crar.AwidCar.rest.api.AuthApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController implements AuthApi {
    @Override
    public ResponseEntity<?> authenticateUser(SignupRequest signupRequest) {
        return null;
    }

    /*@Autowired
    UserRepository userRepository;
    @Autowired
    private HttpServletRequest request;
    @Value("${keycloak.auth-server-url}")
    private String keycloakAuthUrl;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.credentials.secret}")
    private String secret;
    @GetMapping(path = "/logout")
    public String logout() throws ServletException {
        request.logout();
        return "redirect:/auth";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignupRequest signupRequest){
        return null;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody SigninRequest signinRequest) {
        /*User user = userRepository.findByUsername(signinRequest.getUsername());
        if (user == null) return ResponseEntity.ok("Authentification invalide");
        if (user.getRoles() != signinRequest.getRoles()) return ResponseEntity.ok("Authentification invalide");
        AuthzClient authzClient = AuthzClient.create(new Configuration(keycloakAuthUrl, realm, clientId, new HashMap<>() {{
            put("secret", secret);
        }}, null));

        AccessTokenResponse response;
        try {
            response = authzClient.obtainAccessToken(user.getUserName(), signinRequest.getPassword());
        } catch (Exception e) {
            return ResponseEntity.ok("Authentification invalide");
        }

        return ResponseEntity.ok(response);*/
        //return null;
    //}
}
