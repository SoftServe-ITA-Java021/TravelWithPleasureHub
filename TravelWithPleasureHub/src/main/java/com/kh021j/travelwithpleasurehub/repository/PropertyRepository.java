package com.kh021j.travelwithpleasurehub.repository;

import com.kh021j.travelwithpleasurehub.model.Property;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    Optional<Iterable<Property>> findByPriceLessThanEqual(Integer price);

    Optional<Iterable<Property>> findByLocality(String locality);

    Optional<Iterable<Property>> findByAddress(String address);

    @Query(value = "SELECT distinct property.id, title, description, locality, address," +
            " user_id, property_type_id, price, path_to_photo" +
            " FROM property" +
            " LEFT JOIN property_availability ON property.id = property_availability.property_id" +
            " WHERE property_availability.id IS NULL" +
            " or property.id not in(select property_id from property_availability where" +
            " booked_since  between ?1 and ?2 or booked_until between ?1 and ?2 or" +
            " (booked_since < ?1 and  booked_until > ?2))",
            nativeQuery = true)
    Optional<Iterable<Property>> findByAvailabilityInPeriod(LocalDate start, LocalDate end);

    @Query(value = "SELECT distinct property.id, title, description, locality, address," +
            " user_id, property_type_id, price, path_to_photo" +
            " FROM property" +
            " LEFT JOIN property_availability ON property.id = property_availability.property_id" +
            " WHERE property_availability.id IS NULL" +
            " or property.id not in(select property_id from property_availability where" +
            " booked_since  between ?1 and ?2 or booked_until between ?1 and ?2 or" +
            " (booked_since < ?1 and  booked_until > ?2)) order by price ?3",
            nativeQuery = true)
    Optional<Iterable<Property>> findByAvailabilityInPeriodAndSort(LocalDate start, LocalDate end, String order);

    Optional<Iterable<Property>> findAllByOrderByPriceAsc();

    Optional<Iterable<Property>> findAllByOrderByPriceDesc();

}