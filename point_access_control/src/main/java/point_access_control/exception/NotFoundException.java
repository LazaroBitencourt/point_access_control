package point_access_control.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Jornada de trabalho inexistente");
    }
}
