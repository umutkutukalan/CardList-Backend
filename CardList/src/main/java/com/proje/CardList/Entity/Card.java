package com.proje.CardList.Entity;

import com.proje.CardList.Entity.Enum.Derece;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;


    @Column
    private String ad;
    @Column
    private String tanim;


    @Column
    @DateTimeFormat
    private LocalDate basTarih;
    @Column
    @DateTimeFormat
    private LocalDate bitTarih;


    @Enumerated(EnumType.STRING)
    @Column
    private Derece derece;
    @Lob
    @Column
    private byte[] image;



}
