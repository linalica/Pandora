package by.pandora.tag;

import by.pandora.model.UserRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.security.Principal;

/**
 *
 */
public class UserTag extends TagSupport {

    private static final String USER = UserRole.ROLE_USER.name();
    private Principal principal;

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public int doStartTag() throws JspException {
        if(principal == null){
            return SKIP_BODY;
        }
        return USER.equals(((SimpleGrantedAuthority)
                ((UsernamePasswordAuthenticationToken) principal)
                        .getAuthorities().toArray()[0]).getAuthority()) ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

}
