package point_access_control.exception;

public class NullField extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NullField(){
        super("Jornada de trabalho não pode conter campos nulos");
    }
}
