package edu.sabanciuniv.exchangecurrency.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double sourceAmount;
    private double totalAmount;

    private String transactionId;
    private LocalDateTime transactionDate;

    @OneToOne
    private Pair pair;
}
