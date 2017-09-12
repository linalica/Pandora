package by.itransition.pandora.model;

/**
 * Simple Enum that represents role of {@link User}.
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */
public enum UserLocale {
    RU("ru_RU"), en_US("en_US");

    String value;

    private UserLocale(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static boolean contains(String s) {
        for (UserLocale type : values()) {
            if (type.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
