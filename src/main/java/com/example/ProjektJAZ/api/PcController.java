package com.example.ProjektJAZ.api;

import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.Role;
import com.example.ProjektJAZ.model.WorkPc;
import com.example.ProjektJAZ.service.PcService;
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
public class PcController {
    private  final PcService pcService;

    @GetMapping("/computers")
    public ResponseEntity<List<WorkPc>> getPcs() {
        return ResponseEntity.ok().body(pcService.getAllPcs());
    }

    @PostMapping("/computers/save")
    public ResponseEntity<WorkPc> savePC(@RequestBody WorkPc pc) {
        URI url = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/computers/save").toUriString());
        return ResponseEntity.created(url).body(pcService.savePc(pc));
    }

    @PostMapping("/computers/updatePcName")
    public ResponseEntity<?> updatePcName(@RequestBody PcNameForm name) {
        pcService.updatePcName(name.getId(), name.getPcName());
        return ResponseEntity.ok().build();
    }

}
@Data
class PcNameForm {
    private long id;
    private String pcName;
}