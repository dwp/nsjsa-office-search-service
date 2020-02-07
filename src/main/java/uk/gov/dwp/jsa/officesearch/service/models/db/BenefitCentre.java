package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

@Entity(name = "benefit_centre")
public class BenefitCentre {

    @Id
    @Column(name = "dwp_bc_id", updatable = false, nullable = false, unique = true)
    private Long benefitCentreId;
    @Column(name = "dwp_service_id")
    private String serviceId;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;

    @OneToMany(mappedBy = "benefitCentre", cascade = CascadeType.ALL)
    private List<JobCentre> jobCentres = new ArrayList<>();

    public BenefitCentre() {
    }

    public BenefitCentre(
            final String serviceId,
            final String name,
            final LocalDateTime createdTimestamp,
            final LocalDateTime updatedTimestamp
    ) {
        this.serviceId = serviceId;
        this.name = name;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public Long getBenefitCentreId() {
        return benefitCentreId;
    }

    public void setBenefitCentreId(final Long benefitCentreId) {
        this.benefitCentreId = benefitCentreId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(final String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(final LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(final LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public List<JobCentre> getJobCentres() {
        return jobCentres;
    }

    public void setJobCentres(final List<JobCentre> jobCentres) {
        this.jobCentres = jobCentres;
    }

    @Override
    public boolean equals(final Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }
}
