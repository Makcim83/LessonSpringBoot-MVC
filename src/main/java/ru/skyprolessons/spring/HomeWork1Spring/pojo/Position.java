package ru.skyprolessons.spring.HomeWork1Spring.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idposition")
    private Integer idPosition;
    @Column(name = "nameposition")
    private String namePosition;
}