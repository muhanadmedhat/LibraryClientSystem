package Models;
import java.util.regex.Pattern;
import java.util.*;
public class Client {
    private Integer Id;
    private String Name;
    private String Email;
    private List<LibraryItem> clientItems;
    // ^[a-zA-Z][a-zA-Z0-9]+@[a-z]+\.(com|org)$
    
    public Client(Integer id , String name , String email){
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.clientItems = new ArrayList<LibraryItem>();
    }

    public Integer getId(){
        return this.Id;
    }

    public String getName(){
        return this.Name;
    }

    public String getEmail(){
        return this.Email;
    }

    public void getClientDetails(){
        System.out.println(this.Id+" "+this.Name + " " + this.Email);
    }

    public void updateEmail(String email){
        this.Email = email;
    }

    public void getClientItems(){
        for(int i=0;i<clientItems.size();i++){
            LibraryItem item = clientItems.get(i);
            item.getItemDetails();
        }
    }

    public void addElement(LibraryItem item){
        clientItems.add(item);
    }

    public void removeElement(LibraryItem item){
        clientItems.remove(item);
    }
}
