package by.pandora.model;

import javax.persistence.*;


@Entity
@Table(name = "objectives")
public class Objective implements IDatabaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "objective_id")
    private Long id;

    @Column(name = "objective_name")
    private String name;

    @Column(name = "objective_description")
    private String description;

    @Column(name = "objective_balance")
    private Double balance = 0.0;

    @Column(name = "objective_price")
    private Double price = 0.0;

    @Column(name = "objective_closed")
    private Boolean closed = false;

    @Column(name = "objective_min")
    private Boolean min = false;

    @Column(name = "projects_project_id")
    private Long projectId;

    public Objective() {
    }

    public Objective(String name, Double price, Boolean min) {
        this.name = name;
        this.price = price;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", price=" + price +
                ", closed=" + closed +
                ", min=" + min +
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getMin() {
        return min;
    }

    public void setMin(Boolean min) {
        this.min = min;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
