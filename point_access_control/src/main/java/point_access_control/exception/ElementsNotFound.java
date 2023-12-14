package point_access_control.exception;

public class ElementsNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ElementsNotFound(String entity){

        super(entity + " de trabalho inexistentes");
    }
}
