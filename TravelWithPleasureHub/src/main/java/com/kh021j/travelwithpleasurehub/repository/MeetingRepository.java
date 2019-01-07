package com.kh021j.travelwithpleasurehub.repository;

import com.kh021j.travelwithpleasurehub.model.Meeting;
import com.kh021j.travelwithpleasurehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

    Meeting findById(long id);

    List<Meeting> findAllByConfirmedUsersContainingOrWishingUsersContaining(User user1, User user2);

    List<Meeting> findAllByOwner(User user);

    @Query(value = "SELECT DISTINCT * FROM meeting m " +
            "INNER JOIN users u ON u.id = m.owner_id " +
            "WHERE (LOWER(m.header) LIKE LOWER(CONCAT('%', CASE WHEN ((:headerFilter IS NULL) OR (:headerFilter = 'undefined')) THEN '' ELSE :headerFilter END, '%')) " +
            "AND LOWER(m.location) LIKE LOWER(CONCAT('%', CASE WHEN ((:locationFilter IS NULL) OR (:locationFilter = 'undefined')) THEN '' ELSE :locationFilter END, '%')) " +
            "AND CASE WHEN ((:timeFilter IS NULL) OR (:timeFilter = 'undefined')) THEN '' ELSE :timeFilter END > " +
            "CONCAT(extract (YEAR from m.date_time),'-'," +
            "extract(MONTH from m.date_time),'-', " +
            "extract(DAY from m.date_time),' '," +
            "extract(HOUR from m.date_time),':'," +
            "extract(MINUTE from m.date_time))) ",
            nativeQuery = true)
    List<Meeting> findAllByFilter(@Param("headerFilter") String headerFilter,
                                  @Param("locationFilter") String locationFilter,
                                  @Param("timeFilter") String timeFilter);


}
