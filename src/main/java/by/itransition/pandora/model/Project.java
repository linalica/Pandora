package by.itransition.pandora.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project implements IDatabaseEntity {

    private static final long serialVersionUID = 1L;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "project_creating_date")
    private Date creatingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "project_finish_date")
    private Date finishDate;


    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus = ProjectStatus.ACTIVE;

    @Column(name = "project_min_objective_achieved")
    private Boolean minObjectiveAchieved = false;

    //@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @Transient
    private List<Objective> objectives;

    //@OneToMany(mappedBy = "comments", cascade = CascadeType.ALL)
    @Transient
    private List<Comment> comments;

    @Transient
    private Double rating = 0.0;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", creatingDate=" + creatingDate +
                ", finishDate=" + finishDate +
                ", projectStatus=" + projectStatus +
                ", minObjectiveAchieved=" + minObjectiveAchieved +
                ", objectives=" + objectives +
                ", comments=" + comments +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (getId() != null ? !getId().equals(project.getId()) : project.getId() != null) return false;
        if (getName() != null ? !getName().equals(project.getName()) : project.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(project.getDescription()) : project.getDescription() != null)
            return false;
        if (!Arrays.equals(getPicture(), project.getPicture())) return false;
        if (getCreatingDate() != null ? !getCreatingDate().equals(project.getCreatingDate()) : project.getCreatingDate() != null)
            return false;
        if (getFinishDate() != null ? !getFinishDate().equals(project.getFinishDate()) : project.getFinishDate() != null)
            return false;
        if (getProjectStatus() != project.getProjectStatus()) return false;
        if (getMinObjectiveAchieved() != null ? !getMinObjectiveAchieved().equals(project.getMinObjectiveAchieved()) : project.getMinObjectiveAchieved() != null)
            return false;
        if (getObjectives() != null ? !getObjectives().equals(project.getObjectives()) : project.getObjectives() != null)
            return false;
        if (getComments() != null ? !getComments().equals(project.getComments()) : project.getComments() != null)
            return false;
        return getRating() != null ? getRating().equals(project.getRating()) : project.getRating() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getPicture());
        result = 31 * result + (getCreatingDate() != null ? getCreatingDate().hashCode() : 0);
        result = 31 * result + (getFinishDate() != null ? getFinishDate().hashCode() : 0);
        result = 31 * result + (getProjectStatus() != null ? getProjectStatus().hashCode() : 0);
        result = 31 * result + (getMinObjectiveAchieved() != null ? getMinObjectiveAchieved().hashCode() : 0);
        result = 31 * result + (getObjectives() != null ? getObjectives().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        return result;
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

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
