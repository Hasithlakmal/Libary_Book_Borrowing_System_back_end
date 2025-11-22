package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Borrow {


    private String borrowId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returntDate;
    private String status;


}
