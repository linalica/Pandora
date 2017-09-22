package by.itransition.pandora.security.model;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */

public class TokenPayload {

    private Long userId;
    private long exp;

    public TokenPayload() {
    }

    public TokenPayload(final Long userId, final long exp) {
        this.userId = userId;
        this.exp = exp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }
}