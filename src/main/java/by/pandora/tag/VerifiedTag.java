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
public class VerifiedTag extends TagSupport {

    private static final String VERIFIED = UserRole.ROLE_VERIFIED.name();
    private static final String ADMIN = UserRole.ROLE_ADMIN.name();

    private Principal principal;

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public int doStartTag() throws JspException {
        if (principal == null) {
            return SKIP_BODY;
        }
        String authority = ((SimpleGrantedAuthority)
                ((UsernamePasswordAuthenticationToken) principal)
                        .getAuthorities().toArray()[0]).getAuthority();

        return (VERIFIED.equals(authority) || ADMIN.equals(authority)) ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

}
