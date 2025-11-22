package edu.icet.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class BorrowEntity {

    @Id
    private String borrowId;

    private LocalDate borrowDate;

    private LocalDate dueDate;

    private LocalDate returntDate;

    private String status;


    @ManyToOne(cascade = CascadeType.ALL)
    private  BookEntity bookEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    private  UserEntity userEntity;



}
