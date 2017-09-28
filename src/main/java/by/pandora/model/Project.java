package by.pandora.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "project_creating_date")
    private Date creatingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "project_finish_date")
    private Date finishDate;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.ACTIVE;

    @Column(name = "project_min_objective_achieved")
    private Boolean minObjectiveAchieved = false;

    @Column(name = "project_creator_id")
    private Long creatorId;

    @Column(name = "project_rating")
    private Double rating = 0.0;

    @Column(name = "project_price")
    private Double price = 0.0;

    @Column(name = "project_balance")
    private Double balance = 0.0;

    @Transient
    private List<Objective> objectives;

    @Transient
    private List<Comment> comments;

    @Transient
    private List<Integer> subscriptions;

    @Transient
    private List<Integer> marks;

    @Transient
    private User creator;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", creatingDate=" + creatingDate +
                ", finishDate=" + finishDate +
                ", status=" + status +
                ", minObjectiveAchieved=" + minObjectiveAchieved +
                ", creatorId=" + creatorId +
                ", rating=" + rating +
                ", price=" + price +
                ", balance=" + balance +
                ", objectives=" + objectives +
                ", comments=" + comments +
                ", subscriptions=" + subscriptions +
                ", marks=" + marks +
                ", creator=" + creator +
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
        if (getStatus() != project.getStatus()) return false;
        if (getMinObjectiveAchieved() != null ? !getMinObjectiveAchieved().equals(project.getMinObjectiveAchieved()) : project.getMinObjectiveAchieved() != null)
            return false;
        if (getCreatorId() != null ? !getCreatorId().equals(project.getCreatorId()) : project.getCreatorId() != null)
            return false;
        if (getRating() != null ? !getRating().equals(project.getRating()) : project.getRating() != null) return false;
        if (getPrice() != null ? !getPrice().equals(project.getPrice()) : project.getPrice() != null) return false;
        if (getBalance() != null ? !getBalance().equals(project.getBalance()) : project.getBalance() != null)
            return false;
        if (getObjectives() != null ? !getObjectives().equals(project.getObjectives()) : project.getObjectives() != null)
            return false;
        if (getComments() != null ? !getComments().equals(project.getComments()) : project.getComments() != null)
            return false;
        if (getSubscriptions() != null ? !getSubscriptions().equals(project.getSubscriptions()) : project.getSubscriptions() != null)
            return false;
        if (getMarks() != null ? !getMarks().equals(project.getMarks()) : project.getMarks() != null) return false;
        return getCreator() != null ? getCreator().equals(project.getCreator()) : project.getCreator() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getPicture());
        result = 31 * result + (getCreatingDate() != null ? getCreatingDate().hashCode() : 0);
        result = 31 * result + (getFinishDate() != null ? getFinishDate().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getMinObjectiveAchieved() != null ? getMinObjectiveAchieved().hashCode() : 0);
        result = 31 * result + (getCreatorId() != null ? getCreatorId().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        result = 31 * result + (getObjectives() != null ? getObjectives().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        result = 31 * result + (getSubscriptions() != null ? getSubscriptions().hashCode() : 0);
        result = 31 * result + (getMarks() != null ? getMarks().hashCode() : 0);
        result = 31 * result + (getCreator() != null ? getCreator().hashCode() : 0);
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Boolean getMinObjectiveAchieved() {
        return minObjectiveAchieved;
    }

    public void setMinObjectiveAchieved(Boolean minObjectiveAchieved) {
        this.minObjectiveAchieved = minObjectiveAchieved;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public List<Integer> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Integer> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
