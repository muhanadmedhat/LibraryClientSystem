package Controllers;
import java.util.*;
import java.util.regex.Pattern;

import Helper.Helper;
import Models.Client;
public class MenuClient {
    
    private List<Client> clients;
    
    public MenuClient(){
        clients = new ArrayList<>();
        //Helper helper = new Helper();

    }
    public List<Client> getClients(){
        return this.clients;
    }

    public void displayMenu(){
        while(true){
        System.out.println("Press: \n 1- To add client \n 2- To get client \n 3- Update client \n 4- Delete client \n 5- View clients \n 6- Get Client Items \n 7- Exit");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        Integer choiceNumber = Helper.integerChecker(choice); //integerChecker(choice);
        while(choiceNumber<1 || choiceNumber>7){
            System.out.println("Choose number in the list");
            choice = input.nextLine();
            choiceNumber = Helper.integerChecker(choice);
        }
        if(choiceNumber == 1){
            //input.nextLine();
            System.out.println("Enter the ID: ");
            String id = input.nextLine();
            Integer Id = Helper.integerChecker(id);
            while(Id < 0){
               System.out.println("Enter valid ID: ");
                id = input.nextLine();
                Id = Helper.integerChecker(id);
            }
            System.out.println("Enter the name: ");
            String name = input.nextLine();
            String Name = Helper.stringChecker(name);
            while(Name.equals("")){
            System.out.println("Enter valid name: ");
                name = input.nextLine();
                Name = Helper.stringChecker(name);
            }
            System.out.println("Enter the email: ");
            String email = input.nextLine();
            while(Helper.emailChecker(email) == false){
                System.out.println("Invalid email enter another one");
                email = input.nextLine();
            }
            addClient(Id, Name, email);
            

        }else if(choiceNumber == 2){
            System.out.println("Enter the ID: ");
            String id = input.nextLine();
            Integer Id = Helper.integerChecker(id);
            while(Id < 0){
               System.out.println("Enter valid ID: ");
                id = input.nextLine();
                Id = Helper.integerChecker(id);
            }
            retrieveClient(Id);
        }else if(choiceNumber == 3){
            System.out.println("Enter the ID: ");
            String id = input.nextLine();
            Integer Id = Helper.integerChecker(id);
            while(Id < 0){
               System.out.println("Enter valid ID: ");
                id = input.nextLine();
                Id = Helper.integerChecker(id);
            }
            System.out.println("Enter the email: ");
            String email = input.nextLine();
            while(Helper.emailChecker(email) == false){
                System.out.println("Invalid email");
                email = input.nextLine();
            }
            updateClient(Id, email);
        }else if(choiceNumber == 4){
            System.out.println("Enter the ID: ");
            String id = input.nextLine();
            Integer Id = Helper.integerChecker(id);
            while(Id < 0){
               System.out.println("Enter valid ID: ");
                id = input.nextLine();
                Id = Helper.integerChecker(id);
            }
            deleteClient(Id);
        }else if(choiceNumber == 5){
            displayClients();
        }else if(choiceNumber == 6){
            getClientItemsById();
        }else if(choiceNumber == 7){
            return;
        }
    }
    }

    public void addClient(Integer id , String name , String email){
        Client client = new Client(id, name, email);
        for(int i=0;i<clients.size();i++){
            if(client.getId().equals(clients.get(i).getId())){
                System.out.println("This id is already used");
                return;
            }
        }
        clients.add(client);
        System.out.println("========Client added successfully========");
    }

    public void retrieveClient(Integer id){
        Client client = Helper.findClient(id, clients);
        if(client == null){
            System.out.println("There is no client with this ID");
            return;
        }
        client.getClientDetails();
    }

    public void updateClient(Integer id , String email){
        Client client = Helper.findClient(id, clients); 
        if(client == null){
            System.out.println("There is no client with this ID");
            return;
        }
        client.updateEmail(email);
        System.out.println("========Client updated successfully========");
    }

    public void deleteClient(Integer id){
       Client client = Helper.findClient(id, clients); 
        if(client == null){
            System.out.println("There is no client with this ID");
            return;
        }
        clients.remove(client);
        System.out.println("========Client deleted successfully========");

    }

    public void displayClients(){
        for(int i=0;i<clients.size();i++){
            Client client = clients.get(i);
            System.out.println(client.getId()+" "+client.getName()+" "+client.getEmail());
        }
    }

    public void getClientItemsById(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID: ");
            String id = input.nextLine();
            Integer Id = Helper.integerChecker(id);
            while(Id < 0){
               System.out.println("Enter valid ID: ");
                id = input.nextLine();
                Id = Helper.integerChecker(id);
            }
        Client client = Helper.findClient(Id, clients); 
        if(client == null){
            System.out.println("There is no client with this ID");
            return;
        }

        client.getClientItems();
    }
}
