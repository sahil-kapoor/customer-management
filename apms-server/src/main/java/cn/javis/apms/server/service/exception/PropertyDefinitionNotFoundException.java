package cn.javis.apms.server.service.exception;

/**
 * Throws accessing property definition,
 * if no property definition with given property name was found
 * */
public class PropertyDefinitionNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -3283789725110542807L;

    public PropertyDefinitionNotFoundException(String msg) {
        super(msg);
    }

}
