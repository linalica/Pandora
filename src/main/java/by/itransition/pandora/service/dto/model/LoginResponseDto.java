package by.itransition.pandora.service.dto.model;

import by.itransition.pandora.service.dto.Dto;

/**
 * @author i.katlinsky
 * @since 21.07.2016
 */

public class LoginResponseDto implements Dto {

    private String token;

    public LoginResponseDto() {
    }

    public LoginResponseDto(final String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginResponseDto)) return false;

        LoginResponseDto that = (LoginResponseDto) o;

        return getToken() != null ? getToken().equals(that.getToken()) : that.getToken() == null;
    }

    @Override
    public int hashCode() {
        return getToken() != null ? getToken().hashCode() : 0;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
