package by.itransition.pandora.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project implements IDatabaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "project_description")
    private String description;

    @Column(name = "project_picture")
    private byte[] picture;

    @Column(name = "project_creating_time")
    private Timestamp creatingTime;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Column(name = "project_min_objective_achieved")
    private Boolean minObjectiveAchieved;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Objective> objectives;

   /* @OneToMany(mappedBy = "comments", cascade = CascadeType.ALL)
    private List<Comment> comments;*/

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creatingTime=" + creatingTime +
                ", projectStatus=" + projectStatus +
                ", minObjectiveAchieved=" + minObjectiveAchieved +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Timestamp getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(Timestamp creatingTime) {
        this.creatingTime = creatingTime;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Boolean getMinObjectiveAchieved() {
        return minObjectiveAchieved;
    }

    public void setMinObjectiveAchieved(Boolean minObjectiveAchieved) {
        this.minObjectiveAchieved = minObjectiveAchieved;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }
/*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
    public Set<Objective> getPublishers() {
        return publishers;
    }*/

/*
 @ManyToMany
    @JoinTable(name = "objectives",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "objective_id"))

    private Set<Objective> objectives;


    @ManyToMany
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> subscribitions;*/


}
