package by.itransition.pandora.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
@Entity
@Table(name = "comments")
public class Comment implements IDatabaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "comment_creating_time")
    private Timestamp creatingTime;

    @Column(name = "users_user_id")
    private Long userId;

    @Column(name = "projects_project_id")
    private Long projectId;



    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", creatingTime=" + creatingTime +
                ", userId=" + userId +
                ", projectId=" + projectId +
                '}';
    }
}
