package com.aston.search_entertainment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entertainment")
public class Entertainment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entertainment_id")
    @GenericGenerator(name = "seq_entertainment_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_entertainment_id")})
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "location")
    private String location;

    @Column(name = "text")
    private String documents;

    @Column(name = "url")
    private String url;

    //    @Column(name = "date")
    @CreationTimestamp
    private Timestamp date;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "entertainment"
            , cascade = CascadeType.ALL)
    private List<Comment> comments;
}
