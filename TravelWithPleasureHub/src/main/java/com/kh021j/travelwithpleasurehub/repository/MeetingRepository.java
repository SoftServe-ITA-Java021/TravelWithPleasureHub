package com.kh021j.travelwithpleasurehub.repository;

import com.kh021j.travelwithpleasurehub.model.Meeting;
import com.kh021j.travelwithpleasurehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    Meeting findById(long id);

    List<Meeting> findAllByHeaderContaining(String header);

    List<Meeting> findAllByTimeOfActionAfter(LocalDateTime time);

    List<Meeting> findAllByConfirmedUsersContainsAndTimeOfActionIsBefore(User user, LocalDateTime time);

}
