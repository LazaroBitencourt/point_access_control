package point_access_control.exception;

public class ElementsNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ElementsNotFound(){
        super("jornadas de trabalho inexistentes");
    }
}
