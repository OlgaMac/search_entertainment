package com.aston.search_entertainment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
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
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Accessors(chain = true)
@Table(name = "entertainment")
public class Entertainment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entertainment_id")
    @GenericGenerator(name = "seq_entertainment_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_entertainment_id")})
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @CreationTimestamp
    private Timestamp date;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "url")
    private String url;

    @Column(name = "text")
    private String documents;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "entertainment"
            , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;

    public void addComments(Comment comment) {
        this.comments.add(comment);
        comment.setEntertainment(this);
    }
    public void removeComments(Comment comment) {
        this.comments.remove(comment);
    }
}
