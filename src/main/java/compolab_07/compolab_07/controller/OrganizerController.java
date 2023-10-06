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
import org.springframework.web.server.ResponseStatusException;

import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.service.OrganizerService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
        final OrganizerService organizerService;

        @GetMapping("organizer")
        public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                        @RequestParam(value = "_page", required = false) Integer page) {

                Page<Organizer> pageOutput = organizerService.getEvents(perPage, page);

                HttpHeaders responseHeader = new HttpHeaders();
                responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
                return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);

        }

        @GetMapping("Organizer/{id}")
        public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
                Organizer output = organizerService.getEvent(id);
                if (output != null) {
                        return ResponseEntity.ok(output);
                } else {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The givenid is not found");

                }
        }

        @PostMapping("/organizers")
        public ResponseEntity<?> addEvent(@RequestBody Organizer event) {
                Organizer output = organizerService.save(event);
                return ResponseEntity.ok(output);
        }

}
