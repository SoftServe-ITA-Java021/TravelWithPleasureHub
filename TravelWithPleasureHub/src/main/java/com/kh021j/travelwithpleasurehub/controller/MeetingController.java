package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.service.MeetingService;
import com.kh021j.travelwithpleasurehub.service.dto.MeetingDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/meetings")
public class MeetingController {

    private final Logger log = LoggerFactory.getLogger(MeetingController.class);

    private final MeetingService meetingService;

    @PostMapping
    public ResponseEntity<MeetingDTO> createMeeting(@ModelAttribute MeetingDTO meetingDTO) throws URISyntaxException, IOException {
        log.debug("REST request to save Meeting : {}", meetingDTO);
        MeetingDTO result = meetingService.save(meetingDTO);
        if (result != null) {
            return ResponseEntity.created(new URI("/api/meetings/" + result.getId())).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/request-for-meeting/{meetingId}/{userId}")
    public ResponseEntity<MeetingDTO> sendRequestForMeeting(@PathVariable Integer meetingId, @PathVariable Integer userId) {
        log.debug("REST request to send request for Meeting with id : {} ,and wishing user id : {} ", meetingId, userId);
        MeetingDTO result = meetingService.sendRequestForMeeting(meetingId, userId);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/confirm-meeting/{ownerId}/{meetingId}/{wishingUserId}")
    public ResponseEntity<MeetingDTO> confirmUserForMeeting
            (@PathVariable Integer ownerId, @PathVariable Integer meetingId, @PathVariable Integer wishingUserId) {
        log.debug("REST request to send request for Meeting with id : {} ,owner id : {} ,and wishing user id : {} ",
                meetingId, ownerId, wishingUserId);
        MeetingDTO result = meetingService.confirmUserForMeeting(ownerId, meetingId, wishingUserId);
        if (result != null) {
            return ResponseEntity.ok(result);
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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMeeting(@PathVariable Integer id) {
        log.debug("REST request to remove Meeting with id : {}", id);
        if (meetingService.deleteById(id)) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDTO> findMeetingById(@PathVariable Integer id) {
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
    public List<MeetingDTO> findMeetingByTimeAfterFilter(@RequestParam String time) {
        LocalDateTime resTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        log.debug("REST request to get Meetings after time : {}", resTime);
        return meetingService.findAllByDateAfter(resTime);
    }

    @GetMapping(params = "location")
    public List<MeetingDTO> findMeetingByLocation(@RequestParam String location) {
        return meetingService.findAllByLocation(location);
    }

}