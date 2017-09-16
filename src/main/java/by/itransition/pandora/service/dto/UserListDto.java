package by.itransition.pandora.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto for user list item.
 * @author d.krivenky
 * @since 27.08.2016
 */
@Getter
@Setter
public class UserListDto implements Dto {

    private long id;
    private String username;
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
