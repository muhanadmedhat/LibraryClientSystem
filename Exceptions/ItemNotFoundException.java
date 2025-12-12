package Exceptions;

public class ItemNotFoundException extends Throwable{
    public ItemNotFoundException(){
        super("This element is not found");
    }
}
