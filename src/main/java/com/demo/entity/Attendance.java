package com.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(	name = "attendance")
@Getter
@Setter
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "uer_id")
    private String userId;

    @NotBlank
    @Column(name = "punch_in")
    private Instant punchIn;

    @NotBlank
    @Column(name = "punch_out")
    private Instant punchOut;
}
