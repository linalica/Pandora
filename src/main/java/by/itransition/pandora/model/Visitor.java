package by.itransition.pandora.model;

import java.io.Serializable;

public class Visitor implements Serializable {

    private String locale;
    private String theme;

    public Visitor() {
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "locale='" + locale + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;

        Visitor visitor = (Visitor) o;

        if (getLocale() != null ? !getLocale().equals(visitor.getLocale()) : visitor.getLocale() != null) return false;
        return getTheme() != null ? getTheme().equals(visitor.getTheme()) : visitor.getTheme() == null;
    }

    @Override
    public int hashCode() {
        int result = getLocale() != null ? getLocale().hashCode() : 0;
        result = 31 * result + (getTheme() != null ? getTheme().hashCode() : 0);
        return result;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
