package uk.gov.dwp.jsa.officesearch.service.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.gov.dwp.jsa.officesearch.service.models.db.JobCentre;

public interface JobCentreRepository extends CrudRepository<JobCentre, Long> {
}
