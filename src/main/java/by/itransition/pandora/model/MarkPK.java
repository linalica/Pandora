package by.itransition.pandora.model;

import java.io.Serializable;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
public class MarkPK implements Serializable {

    protected Long userId;
    protected Long projectId;

    public MarkPK() {}

    public MarkPK(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkPK)) return false;

        MarkPK markPK = (MarkPK) o;

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
