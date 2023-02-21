package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Project name is required")
    @Size(min = 4,max = 20,message = "Please use minmum 4 and maximum 20 characters")
    private String projectName;
    @NotBlank(message = "Project identifier is required")
    @Size(min=4,max = 20,message = "Please use 4 to 5 characters")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Project description is required")
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;
}
