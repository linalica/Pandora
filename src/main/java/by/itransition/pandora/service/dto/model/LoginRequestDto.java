package by.itransition.pandora.service.dto.model;

import by.itransition.pandora.service.dto.Dto;

/**
 * @author i.katlinsky
 * @since 21.07.2016
 */

public class LoginRequestDto implements Dto {

    private String username;
    private String password;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String username, String password) {

        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginRequestDto)) return false;

        LoginRequestDto that = (LoginRequestDto) o;

        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        return getPassword() != null ? getPassword().equals(that.getPassword()) : that.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
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
}
