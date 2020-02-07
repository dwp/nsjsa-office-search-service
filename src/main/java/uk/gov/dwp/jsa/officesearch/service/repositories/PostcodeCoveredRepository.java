package uk.gov.dwp.jsa.officesearch.service.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.gov.dwp.jsa.officesearch.service.models.db.PostcodeCovered;

import java.util.Optional;

public interface PostcodeCoveredRepository extends CrudRepository<PostcodeCovered, Long> {

    Optional<PostcodeCovered> findByPostcodeZoneIgnoreCase(final String postcodeZone);

}
