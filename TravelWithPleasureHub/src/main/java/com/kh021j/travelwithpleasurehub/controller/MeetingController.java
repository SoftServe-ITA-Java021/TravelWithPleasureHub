package com.kh021j.travelwithpleasurehub.web.rest;

import com.kh021j.travelwithpleasurehub.service.MeetingService;
import com.kh021j.travelwithpleasurehub.service.dto.MeetingDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/meetings")
public class MeetingResource {

    private final Logger log = LoggerFactory.getLogger(MeetingResource.class);

    private final MeetingService meetingService;

    @PostMapping
    public ResponseEntity<MeetingDTO> createMeeting(@RequestBody MeetingDTO meetingDTO) throws URISyntaxException {
        log.debug("REST request to save Meeting : {}", meetingDTO);
        MeetingDTO result = meetingService.save(meetingDTO);
        if (result != null) {
            return ResponseEntity.created(new URI("/api/meetings/" + result.getId())).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<MeetingDTO> updateMeeting(@RequestBody MeetingDTO meetingDTO) {
        log.debug("REST request to update Meeting : {}", meetingDTO);
        MeetingDTO result = meetingService.update(meetingDTO);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDTO> findMeetingById(@PathVariable long id) {
        log.debug("REST request to get Meeting by id : {}", id);
        Optional<MeetingDTO> meetingDTO = meetingService.findById(id);
        return meetingDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<MeetingDTO> findAllMeetings() {
        log.debug("REST request to get Meetings : {}");
        return meetingService.findAll();
    }

    @GetMapping(params = "header")
    public List<MeetingDTO> findMeetingByHeaderFilter(@RequestParam String header) {
        log.debug("REST request to get Meetings with header : {}", header);
        return meetingService.findAllByHeaderFilter(header);
    }

    @GetMapping(params = "time")
    public List<MeetingDTO> findMeetingByTimeAfterFilter(@RequestParam LocalDateTime time) {
        log.debug("REST request to get Meetings after time : {}", time);
        return meetingService.findAllByDateAfter(time);
    }
}
