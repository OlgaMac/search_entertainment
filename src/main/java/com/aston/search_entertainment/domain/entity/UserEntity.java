package com.aston.search_entertainment.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users_id")
    @GenericGenerator(name = "seq_users_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_users_id")})
    private Long id;
    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @CreationTimestamp
    private Timestamp created;

    @Column(name = "enabled")
    private Boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "userId"
            , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Company> companies;

    @Setter(PRIVATE)
    @OneToMany(mappedBy = "user", fetch = EAGER)
    private List<Comment> comments = new ArrayList<>();

    public void addComments(Comment comment) {
        this.comments.add(comment);
        comment.setUser(this);
    }

    public void removeComments(Comment comment) {
        this.comments.remove(comment);
    }

}
