package com.example.timetable.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseAuditableEntity extends BaseEntity {

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "last_updated_by")
    protected String lastUpdatedBy;

    @PrePersist
    public void onCreate() {
        super.onCreate();
        createdBy = lastUpdatedBy = "Automated user";
        this.setCreatedTimestamp(this.getCreatedTimestamp() == null ? DateTime.now().getMillis() : this.getCreatedTimestamp());
        this.setUpdatedTimestamp(this.getCreatedTimestamp());
    }


    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
        lastUpdatedBy = "Automated user";
        this.setUpdatedTimestamp(DateTime.now().getMillis());
    }
}
