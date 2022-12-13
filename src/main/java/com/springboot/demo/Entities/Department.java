package com.springboot.demo.Entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Department
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long departmentID;


//    @Length(max = 15, min = 2)
//    @Size(max = 15, min = 2)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
    @NotBlank(message = "Please add department name")
    String departmentName;

    String departmentAddress;

    String departmentCode;


}
