package Helper;

import java.util.regex.Pattern;
import java.util.*;
import Models.Client;
import Models.LibraryItem;

public class Helper {
    public static  Integer integerChecker(String number){
        if(number.equals("")) return -1;
        try {
            Integer num = Integer.parseInt(number);
            if(num<=0) return -1;
            return num;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Invalid integer");
            return -1;
        }
    }

     public static  String stringChecker(String str){
        if(str.equals("")) return "";
        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(!Character.isLetter(c)){
                System.out.println("Invalid data");
                return "";
            }
        }
        return str;
    }

    public static boolean emailChecker(String email){
        return Pattern.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-z]+\\.(com|org)$", email);
    }

    public static Client findClient(Integer clientId , List<Client> clients){
        
        Client client = clients.stream()
                        .filter(c -> c.getId().equals(clientId))
                        .findFirst()
                        .orElse(null);
        return client;
    }

    public static LibraryItem findItem(Integer itemId, List<LibraryItem> items){
        LibraryItem libraryItem = items.stream()
                                  .filter(l -> l.getId().equals(itemId))
                                  .findFirst()
                                  .orElse(null);
        
          return libraryItem;                        
    }
}
