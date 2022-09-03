package com.aston.search_entertainment.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company_id")
    @GenericGenerator(name = "seq_company_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_company_id")})
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(name = "location")
    private String location;

    @Column(name = "documents")
    private String documents;
}
