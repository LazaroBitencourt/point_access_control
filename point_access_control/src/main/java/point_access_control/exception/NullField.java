package point_access_control.exception;

public class NullField extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public NullField(String entityName){

        super(entityName + " não pode ser nulo ou conter campos nulos");
    }
}
