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

import compolab_07.compolab_07.entity.Participant;
import compolab_07.compolab_07.service.ParticipantService;
import compolab_07.compolab_07.util.LabMapper;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("participants")
    public ResponseEntity<?> getParticipantLists(
            @RequestParam(value = "_limit", required = false) Integer pageSize,
            @RequestParam(value = "_page", required = false) Integer page) {
        HttpHeaders responseHeader = new HttpHeaders();
        Page<Participant> pageOut = participantService.getParticipants(pageSize, page);
        responseHeader.set("x-total-count", String.valueOf(pageOut.getTotalElements()));
        if (pageOut.getContent().isEmpty()) {
            return new ResponseEntity<>(LabMapper.INSTANCE.getParticipantDTO(pageOut.getContent()), responseHeader,
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(LabMapper.INSTANCE.getParticipantDTO(pageOut.getContent()), responseHeader,
                HttpStatus.OK);
    }

    @GetMapping("Participants/{id}")
    public ResponseEntity<?> getParticipant(@PathVariable("id") Long id) {
        Participant output = participantService.getParticipant(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(output));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found.");
        }
    }

    @PostMapping("/Participants")
    public ResponseEntity<?> addParticipant(@RequestBody Participant Participant) {
        Participant output = participantService.save(Participant);
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(output));
    }

}