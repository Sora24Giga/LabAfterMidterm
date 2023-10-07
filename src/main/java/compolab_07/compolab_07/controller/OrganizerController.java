package compolab_07.compolab_07.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.service.OrganizerService;
import compolab_07.compolab_07.util.LabMapper;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerLists(
            @RequestParam(value = "_limit", required = false) Integer pageSize,
            @RequestParam(value = "_page", required = false) Integer page) {
        HttpHeaders responseHeader = new HttpHeaders();
        Page<Organizer> pageOut = organizerService.getOrganizers(pageSize, page);
        responseHeader.set("x-total-count", String.valueOf(pageOut.getTotalElements()));
        if (pageOut.getContent().isEmpty()) {
            return new ResponseEntity<>(LabMapper.INSTANCE.getOrganizerDTO(pageOut.getContent()), responseHeader,
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(LabMapper.INSTANCE.getOrganizerDTO(pageOut.getContent()), responseHeader,
                HttpStatus.OK);
    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizer(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(output));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizer not found.");
        }
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer) {
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(output));
    }

}