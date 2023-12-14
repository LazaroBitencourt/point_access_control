package point_access_control.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(String entity) {

        super(entity + " de trabalho inexistente");
    }
}
