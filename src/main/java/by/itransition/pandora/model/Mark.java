package by.itransition.pandora.model;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@IdClass(MarkPK.class)
public class Mark implements IDatabaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "rating_mark")
    private Integer value;

    @Id
    @Column(name = "users_user_id")
    private Long userId;

    @Id
    @Column(name = "projects_project_id")
    private Long projectId;

    public Mark() {
    }

    public Mark(Integer value, Long userId, Long projectId) {
        this.value = value;
        this.userId = userId;
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "value=" + value +
                ", userId=" + userId +
                ", projectId=" + projectId +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
