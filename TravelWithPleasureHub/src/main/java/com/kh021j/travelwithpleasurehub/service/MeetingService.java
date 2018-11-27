package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.model.Meeting;
import com.kh021j.travelwithpleasurehub.repository.MeetingRepository;
import com.kh021j.travelwithpleasurehub.service.dto.MeetingDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeetingService {

    private final MeetingRepository meetingRepository;

    private final Logger log = LoggerFactory.getLogger(MeetingService.class);

    private Meeting fromDTO(MeetingDTO meetingDTO) {
        if (meetingDTO == null) {
            return null;
        }
        return Meeting.builder()
                .id(meetingDTO.getId())
                .content(meetingDTO.getContent())
                .header(meetingDTO.getContent())
                .link(meetingDTO.getLink())
                .location(meetingDTO.getLocation())
                .meetingType(meetingDTO.getMeetingType())
                .timeOfAction(meetingDTO.getTimeOfAction())
                .build();
    }

    private MeetingDTO toDTO(Meeting meeting) {
        if (meeting == null) {
            return null;
        }
        return MeetingDTO.builder()
                .id(meeting.getId())
                .content(meeting.getContent())
                .header(meeting.getContent())
                .link(meeting.getLink())
                .location(meeting.getLocation())
                .meetingType(meeting.getMeetingType())
                .timeOfAction(meeting.getTimeOfAction())
                .build();
    }

    @Transactional
    public MeetingDTO save(MeetingDTO meetingDTO) {
        log.debug("Request to save Meeting : {}", meetingDTO);
        if (!meetingRepository.existsById(meetingDTO.getId())) {
            Meeting meeting = fromDTO(meetingDTO);
            return toDTO(meetingRepository.saveAndFlush(meeting));
        }
        log.debug("Request to save Meeting was failed : {}", meetingDTO);
        return null;
    }

    @Transactional
    public MeetingDTO update(MeetingDTO meetingDTO) {
        log.debug("Request to update Meeting : {}", meetingDTO);
        if (meetingRepository.existsById(meetingDTO.getId())) {
            Meeting meeting = fromDTO(meetingDTO);
            return toDTO(meetingRepository.saveAndFlush(meeting));
        }
        log.debug("Request to update Meeting was failed : {}", meetingDTO);
        return null;
    }

    public Optional<MeetingDTO> findById(long id) {
        log.debug("Request to get Meeting by id : {}", id);
        return Optional.ofNullable(toDTO(meetingRepository.findById(id)));
    }

    public List<MeetingDTO> findAll() {
        log.debug("Request to get all Meetings ");
        return meetingRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

    }

    public List<MeetingDTO> findAllByHeaderFilter(String header) {
        log.debug("Request to get all Meetings by header filter : {} ", header);
        return meetingRepository.findAllByHeaderContaining(header).stream()
                .map(this::toDTO).collect(Collectors.toList());


    }

    public List<MeetingDTO> findAllByDateAfter(LocalDateTime time) {
        log.debug("Request to get all Meetings by time filter after : {} ", time);
        return meetingRepository.findAllByTimeOfActionAfter(time).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

    }

}
