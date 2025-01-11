package com.entity.relationship.onetoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="citizen")
@Data
public class CitizenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer citizenId;
	@Column(name="citizenName")
	String name;
}
