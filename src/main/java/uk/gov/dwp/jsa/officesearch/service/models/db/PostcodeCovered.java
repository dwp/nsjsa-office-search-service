package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

@Entity(name = "postcode_covered")
public class PostcodeCovered {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID postcodeCoveredId;
    private String postcodeZone;
    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;

    @ManyToOne()
    @JoinColumn(name = "dwp_jcp_id")
    private JobCentre jobCentre;

    public PostcodeCovered() {
    }

    public PostcodeCovered(
            final String postcodeZone,
            final LocalDateTime createdTimestamp,
            final LocalDateTime updatedTimestamp
    ) {
        this.postcodeZone = postcodeZone;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public UUID getPostcodeCoveredId() {
        return postcodeCoveredId;
    }

    public void setPostcodeCoveredId(final UUID postcodeCoveredId) {
        this.postcodeCoveredId = postcodeCoveredId;
    }

    public String getPostcodeZone() {
        return postcodeZone;
    }

    public void setPostcodeZone(final String postcodeZone) {
        this.postcodeZone = postcodeZone;
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

    public JobCentre getJobCentre() {
        return jobCentre;
    }

    public void setJobCentre(final JobCentre jobCentre) {
        this.jobCentre = jobCentre;
    }

    @Override
    public boolean equals(final Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "hash");
    }
}
