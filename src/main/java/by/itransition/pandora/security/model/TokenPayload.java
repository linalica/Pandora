package by.itransition.pandora.security.model;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */

public class TokenPayload {

    private Long userId;
    private long exp;

    public TokenPayload(final Long userId, final long exp) {
        this.userId = userId;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "TokenPayload{" +
                "userId=" + userId +
                ", exp=" + exp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenPayload)) return false;

        TokenPayload that = (TokenPayload) o;

        if (getExp() != that.getExp()) return false;
        return getUserId() != null ? getUserId().equals(that.getUserId()) : that.getUserId() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (int) (getExp() ^ (getExp() >>> 32));
        return result;
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