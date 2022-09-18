package com.aston.search_entertainment.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "confirmation_tokens")
@EntityListeners(AuditingEntityListener.class)
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_confirmation_tokens_id")
    @GenericGenerator(name = "seq_confirmation_tokens_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_confirmation_tokens_id")})
    private Long id;
    private String token;

    @CreationTimestamp
    private Timestamp created;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expired;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public ConfirmationToken(String token, UserEntity userEntity, LocalDateTime expiredAt) {
        this.token = token;
        this.userEntity = userEntity;
        this.expired = expiredAt;
    }
}
