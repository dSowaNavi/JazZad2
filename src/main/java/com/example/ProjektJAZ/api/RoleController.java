package com.example.ProjektJAZ.api;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;
import com.example.ProjektJAZ.service.RoleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @PostMapping("/roles/updateRoleName")
    public ResponseEntity<?> updateRoleName(@RequestBody RoleNameForm form) {
        roleService.updateRoleName(form.getId(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/roles/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI url = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(url).body(roleService.saveRole(role));
    }
}

@Data
class RoleNameForm {
    private long id;
    private String roleName;
}