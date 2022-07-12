package com.finalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobHistory {
@Id
@GeneratedValue
	private Long id;
	private String companyName;
	private String position;
	private String startDate;
	private String endDate;
	private boolean currentlyEmployed;
    private String comments;
	private String reasonToLeave;
	@JoinColumn
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Tags> tags;


	public JobHistory(String companyName, String position, String startDate, String endDate, boolean currentlyEmployed, String comments, String reasonToLeave, List<Tags> tags) {
		this.companyName = companyName;
		this.position = position;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentlyEmployed = currentlyEmployed;
		this.comments = comments;
		this.reasonToLeave = reasonToLeave;
		this.tags=tags;
	}


}