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
public class User {

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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getConfirmPassword() != null ? !getConfirmPassword().equals(user.getConfirmPassword()) : user.getConfirmPassword() != null)
            return false;
        if (getRole() != user.getRole()) return false;
        if (getEnabled() != null ? !getEnabled().equals(user.getEnabled()) : user.getEnabled() != null) return false;
        if (!Arrays.equals(getAvatar(), user.getAvatar())) return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (!Arrays.equals(getPassport(), user.getPassport())) return false;
        if (getBirthday() != null ? !getBirthday().equals(user.getBirthday()) : user.getBirthday() != null)
            return false;
        if (getCreatingTime() != null ? !getCreatingTime().equals(user.getCreatingTime()) : user.getCreatingTime() != null)
            return false;
        return getLastLoginTime() != null ? getLastLoginTime().equals(user.getLastLoginTime()) : user.getLastLoginTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getConfirmPassword() != null ? getConfirmPassword().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (getEnabled() != null ? getEnabled().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getAvatar());
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getPassport());
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getCreatingTime() != null ? getCreatingTime().hashCode() : 0);
        result = 31 * result + (getLastLoginTime() != null ? getLastLoginTime().hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
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
}
