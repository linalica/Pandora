package by.pandora.model;

import java.io.Serializable;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
public class SubscriptionPK implements Serializable {

    protected Long userId;
    protected Long projectId;

    public SubscriptionPK() {}

    public SubscriptionPK(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionPK)) return false;

        SubscriptionPK markPK = (SubscriptionPK) o;

        if (userId != null ? !userId.equals(markPK.userId) : markPK.userId != null) return false;
        return projectId != null ? projectId.equals(markPK.projectId) : markPK.projectId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        return result;
    }
}
