package by.itransition.pandora.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class User implements IDatabaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "user_enabled")
    private Boolean enabled;

    @Column(name = "user_avatar")
    private byte[] avatar;

    @Column(name = "user_first_name")
    private String firstName;

    @Column(name = "user_last_name")
    private String lastName;

    @Column(name = "user_passport")
    private byte[] passport;

    @Column(name = "user_birthday")
    private Timestamp birthday;

    @Column(name = "user_creating_time")
    private Timestamp creatingTime;

    @Column(name = "user_last_login_time")
    private Timestamp lastLoginTime;

    @Column(name = "user_locale")
    private String locale;

    @Column(name = "user_theme")
    private String theme;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                ", avatar=" + Arrays.toString(avatar) +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport=" + Arrays.toString(passport) +
                ", birthday=" + birthday +
                ", creatingTime=" + creatingTime +
                ", lastLoginTime=" + lastLoginTime +
                ", locale='" + locale + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPassport() {
        return passport;
    }

    public void setPassport(byte[] passport) {
        this.passport = passport;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Timestamp getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(Timestamp creatingTime) {
        this.creatingTime = creatingTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
