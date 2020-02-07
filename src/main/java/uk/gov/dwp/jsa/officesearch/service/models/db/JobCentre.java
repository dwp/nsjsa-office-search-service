package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

@Entity(name = "job_centre")
public class JobCentre {

    @Id
    @Column(name = "dwp_jcp_id", updatable = false, nullable = false, unique = true)
    private Long jobCentreId;
    private String name;
    private String firstLine;
    private String secondLine;
    private String town;
    private String postcode;
    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;

    @ManyToOne()
    @JoinColumn(name = "dwp_bc_id")
    private BenefitCentre benefitCentre;

    @OneToMany(mappedBy = "jobCentre", cascade = CascadeType.ALL)
    private List<PostcodeCovered> postcodesCovered = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "jcp_number",
            joinColumns = @JoinColumn(name = "dwp_jcp_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_number_id")
    )
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public JobCentre() {
    }

    public JobCentre(
            final String name,
            final String firstLine,
            final String secondLine,
            final String town,
            final String postcode,
            final BenefitCentre benefitCentre,
            final List<PhoneNumber> phoneNumbers,
            final LocalDateTime createdTimestamp,
            final LocalDateTime updatedTimestamp
    ) {
        this.name = name;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.town = town;
        this.postcode = postcode;
        this.benefitCentre = benefitCentre;
        this.phoneNumbers = phoneNumbers;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public Long getJobCentreId() {
        return jobCentreId;
    }

    public void setJobCentreId(final Long jobCentreId) {
        this.jobCentreId = jobCentreId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(final String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(final String secondLine) {
        this.secondLine = secondLine;
    }

    public String getTown() {
        return town;
    }

    public void setTown(final String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postcode;
    }

    public void setPostCode(final String postcode) {
        this.postcode = postcode;
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

    public BenefitCentre getBenefitCentre() {
        return benefitCentre;
    }

    public void setBenefitCentre(final BenefitCentre benefitCentre) {
        this.benefitCentre = benefitCentre;
    }

    public List<PostcodeCovered> getPostcodesCovered() {
        return postcodesCovered;
    }

    public void setPostcodesCovered(final List<PostcodeCovered> postcodesCovered) {
        this.postcodesCovered = postcodesCovered;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(final List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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
