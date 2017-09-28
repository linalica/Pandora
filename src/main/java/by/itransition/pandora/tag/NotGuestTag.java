package by.itransition.pandora.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.security.Principal;

/**
 *
 */
public class NotGuestTag extends TagSupport {

    private Principal principal;

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public int doStartTag() throws JspException {
        return principal != null ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

}
