/*
package by.itransition.pandora.model;

import javax.persistence.*;
import java.sql.Timestamp;

*/
/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 *//*


@Entity
@Table(name = "projects")
public class Project {

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


   */
/* @ManyToMany
    @JoinTable(name = "objectives",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "objective_id"))
    private Set<Objective> objectives;


    @ManyToMany
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> subscribitions;*//*


}
*/
