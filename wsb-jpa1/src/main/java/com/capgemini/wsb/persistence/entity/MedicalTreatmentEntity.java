package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	// Dodanie relacji do VisitEntity
	@ManyToOne
	@JoinColumn(name = "visit_id")
	private VisitEntity visitEntity;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public TreatmentType getType() {

		return type;
	}

	public void setType(TreatmentType type) {

		this.type = type;
	}

	public VisitEntity getVisit() {
		return visitEntity;
	}

	public void setVisit(VisitEntity visit) {
		this.visitEntity = visit;
	}
}
