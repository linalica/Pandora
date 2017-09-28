package by.itransition.pandora.security;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

import by.itransition.pandora.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ikatlinsky
 * @since 3/29/17
 */
@NoArgsConstructor
@Getter
public class CrmUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private String locale = "en_US";
    private Set<SimpleGrantedAuthority> authorities;



    public CrmUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.locale = user.getLocale();
        this.authorities = new HashSet<>();
        this.authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return "CrmUserDetails{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", locale='" + locale + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
