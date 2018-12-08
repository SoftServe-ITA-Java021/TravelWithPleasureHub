package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.model.Meeting;
import com.kh021j.travelwithpleasurehub.model.MeetingFeedback;
import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.model.enumiration.FeedbackType;
import com.kh021j.travelwithpleasurehub.repository.MeetingFeedbackRepository;
import com.kh021j.travelwithpleasurehub.repository.MeetingRepository;
import com.kh021j.travelwithpleasurehub.repository.UserRepository;
import com.kh021j.travelwithpleasurehub.service.dto.MeetingFeedbackDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeetingFeedbackService {

    private final MeetingFeedbackRepository meetingFeedbackRepository;

    private final MeetingRepository meetingRepository;

    private final UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(MeetingService.class);

    private MeetingFeedback fromDTO(MeetingFeedbackDTO meetingFeedbackDTO) {
        if (meetingFeedbackDTO == null) {
            return null;
        }
        return MeetingFeedback.builder()
                .id(meetingFeedbackDTO.getId())
                .feedbackType(meetingFeedbackDTO.getFeedbackType() != null ?
                        FeedbackType.valueOf(meetingFeedbackDTO.getFeedbackType().toUpperCase()) : null)
                .meeting(meetingFeedbackDTO.getMeetingId() != null ?
                        meetingRepository.findById(meetingFeedbackDTO.getMeetingId()) : null)
                .text(meetingFeedbackDTO.getText())
                .build();
    }

    private MeetingFeedbackDTO toDTO(MeetingFeedback meetingFeedback) {
        if (meetingFeedback == null) {
            return null;
        }

        return MeetingFeedbackDTO.builder()
                .id(meetingFeedback.getId())
                .feedbackType(meetingFeedback.getFeedbackType().toString())
                .meetingId(meetingFeedback.getMeeting() != null ?
                        meetingFeedback.getMeeting().getId() : null)
                .text(meetingFeedback.getText())
                .build();
    }

    @Transactional
    public MeetingFeedbackDTO save(MeetingFeedbackDTO meetingFeedbackDTO) {
        log.debug("Request to send request for MeetingFeedback  : {} ", meetingFeedbackDTO);
        if (!meetingFeedbackRepository.existsById(meetingFeedbackDTO.getId())) {
            MeetingFeedback meetingFeedback = fromDTO(meetingFeedbackDTO);
            return toDTO(meetingFeedbackRepository.saveAndFlush(meetingFeedback));
        }
        log.error("Request to send request for MeetingFeedback : {} was failed", meetingFeedbackDTO);
        return null;
    }

    @Transactional
    public MeetingFeedbackDTO update(MeetingFeedbackDTO meetingFeedbackDTO) {
        log.debug("Request to update MeetingFeedback : {}", meetingFeedbackDTO);
        if (meetingFeedbackRepository.existsById(meetingFeedbackDTO.getId())) {
            MeetingFeedback meetingFeedback = fromDTO(meetingFeedbackDTO);
            return toDTO(meetingFeedbackRepository.saveAndFlush(meetingFeedback));
        }
        log.debug("Request to update MeetingFeedback was failed : {}", meetingFeedbackDTO);
        return null;
    }

    public Optional<MeetingFeedbackDTO> findById(Integer id) {
        log.debug("Request to get MeetingFeedback by id : {}", id);
        return Optional.ofNullable(toDTO(meetingFeedbackRepository.findById(id).get()));
    }

}