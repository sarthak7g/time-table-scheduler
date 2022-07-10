package com.example.timetable.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -3649285369162252355L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, name = "is_active")
    private Boolean isActive = Boolean.TRUE;

    @Version
    @Column(nullable = false, name = "record_version_number")
    private Integer recordVersionNumber;

    @Column(name = "created_timestamp", nullable = false)
    private Long createdTimestamp;

    @Column(name = "last_updated_timestamp", nullable = false)
    private Long updatedTimestamp;
    
    @PrePersist
    protected void onCreate() {
        updatedTimestamp = createdTimestamp = DateTime.now().getMillis();
        this.isActive = null == this.isActive || this.isActive;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTimestamp = DateTime.now().getMillis();
    }
}
