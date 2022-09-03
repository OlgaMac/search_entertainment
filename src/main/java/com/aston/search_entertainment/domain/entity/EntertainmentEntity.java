package com.aston.search_entertainment.domain.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entertainment")
public class EntertainmentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entertainment_id")
    @GenericGenerator(name = "seq_entertainment_id", strategy = "sequence",
            parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "seq_entertainment_id")})
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private UserEntity company_id;

    @Column(name = "location")
    private String location;

    @Column(name = "text")
    private String documents;

    @Column(name = "url")
    private String url;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "rating")
    private Double rating;
}
