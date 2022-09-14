package com.aston.search_entertainment.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter(PRIVATE)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity {
    /**
     * date of object create
     */
    @CreationTimestamp
    private Timestamp created;

    /**
     * date of object update
     */
    @CreationTimestamp
    private Timestamp updated;
}
