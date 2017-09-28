package by.pandora.model;

import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
@IdClass(SubscriptionPK.class)
public class Subscription implements IDatabaseEntity {

    @Column(name = "subscription_status")
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    @Id
    @Column(name = "users_user_id")
    private Long userId;

    @Id
    @Column(name = "projects_project_id")
    private Long projectId;

    public Subscription() {
    }

    public Subscription(SubscriptionStatus status, Long userId, Long projectId) {
        this.status = status;
        this.userId = userId;
        this.projectId = projectId;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
