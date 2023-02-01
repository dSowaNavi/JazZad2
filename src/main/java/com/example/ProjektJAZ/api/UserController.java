package com.example.ProjektJAZ.api;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;
import com.example.ProjektJAZ.service.UserService;
import jakarta.persistence.Cacheable;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/api")
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/getUser?{id}")
    public ResponseEntity<AppUser> getUsers(@PathVariable("objectId") Long objectId) {

        return ResponseEntity.ok().body(userService.getUser(objectId));
    }

    @PostMapping("/users/save")
    public ResponseEntity<AppUser> saveUsers(@RequestBody AppUser user) {
        URI url = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(url).body(userService.saveUser(user));
    }


    @PostMapping("/users/updateRoleUser")
    public ResponseEntity<?> updateUserRole(@RequestBody RoleToUserForm form) {
        userService.updateUserRole(form.getId(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm {
    private long id;
    private String roleName;
}
