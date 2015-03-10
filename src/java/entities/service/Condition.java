package entities.service;

/**
 * A class for creating a condition for an SQL query
 * @author connorbode
 */
public class Condition {
    
    private Type type = Type.EMPTY;
    private String value;
    private String field;
    public static enum Type {
        EQUALS,
        LIKE,
        GREATER_THAN_EQUALS,
        LESS_THAN_EQUALS,
        GREATER_THAN,
        LESS_THAN,
        EMPTY
    };
    
    public Condition (String field, String condition) {
        this.field = field;
        
        if (condition == null) {
            // do something ?
        } else if (condition.startsWith("|")) {
            type = Type.LIKE;
            value = "%" + condition.substring(1) + "%";
        } else if (condition.startsWith("=")) {
            type = Type.EQUALS;
            value = condition.substring(1);
        } else if (condition.startsWith(">=")) {
            type = Type.GREATER_THAN_EQUALS;
            value = condition.substring(2);
        } else if (condition.startsWith("<=")) {
            type = Type.LESS_THAN_EQUALS;
            value = condition.substring(2);
        } else if (condition.startsWith(">")) {
            type = Type.GREATER_THAN;
            value = condition.substring(1);
        } else if (condition.startsWith("<")) {
            type = Type.LESS_THAN;
            value = condition.substring(1);
        } else {
            // do something ?
        }
    }
    
    public Type getType () {
        return type;
    }
    
    public String getValue () {
        return value;
    }
    
    public String getField () {
        return field;
    }
}
