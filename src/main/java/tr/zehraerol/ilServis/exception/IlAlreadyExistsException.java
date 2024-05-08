package tr.zehraerol.IlServis.exception;

public class IlAlreadyExistsException extends RuntimeException{
    public IlAlreadyExistsException(String msg){
        super(msg);
    }
}