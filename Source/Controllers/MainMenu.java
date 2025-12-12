package Controllers;
import Helper.Helper;
import Models.Client;
import Models.LibraryItem;

import java.util.*;
public class MainMenu {
    private MenuClient menuClient;
    private MenuLibrary menuLibrary;
    public MainMenu(){
        menuClient = new MenuClient();
        menuLibrary = new MenuLibrary();
    }
    
    public void displayMenu(){
        //MenuClient menuClient = new MenuClient();
        //MenuLibrary menuLibrary = new MenuLibrary();
        System.out.println(" 1- Client menu \n 2- Library menu \n 3- Exit \n 4- Borrow book for client \n 5- Return item from client \n 6- Exit");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        Integer choiceNumber = Helper.integerChecker(choice);
        while(choiceNumber != 6){
            if(choiceNumber == 1){
                menuClient.displayMenu();
            }else if(choiceNumber == 2){
                menuLibrary.displayMenu();
            }else if(choiceNumber == 4){
                //borrowBook(1, 1);
                System.out.println("Enter the clientID: ");
                String id = input.nextLine();
                Integer clientId = Helper.integerChecker(id);
                while(clientId < 0){
                    System.out.println("Enter valid ID: ");
                    id = input.nextLine();
                    clientId = Helper.integerChecker(id);
                }

                System.out.println("Enter the ID of the book");
                String bookidString = input.nextLine();
                Integer bookId = Helper.integerChecker(bookidString);
                while(bookId == -1){
                    System.out.println("Invalid ID try anothr valid one");
                    bookidString = input.nextLine();
                    bookId = Helper.integerChecker(bookidString);
                }

                borrowElement(clientId,bookId);

            }else if(choiceNumber == 5){
                System.out.println("Enter the clientID: ");
                String id = input.nextLine();
                Integer clientId = Helper.integerChecker(id);
                while(clientId < 0){
                    System.out.println("Enter valid ID: ");
                    id = input.nextLine();
                    clientId = Helper.integerChecker(id);
                }

                System.out.println("Enter the ID of the book");
                String bookidString = input.nextLine();
                Integer bookId = Helper.integerChecker(bookidString);
                while(bookId == -1){
                    System.out.println("Invalid ID try anothr valid one");
                    bookidString = input.nextLine();
                    bookId = Helper.integerChecker(bookidString);
                }
                returnElement(clientId, bookId);
            }
            System.out.println(" 1- Client menu \n 2- Library menu \n 3- Exit \n 4- Borrow book for client \n 5- Return item from client \n 6- Exit");
            choice = input.nextLine();
            choiceNumber = Helper.integerChecker(choice);
        }
        
    }

    public void returnElement(Integer userId , Integer elementId){
        List<Client> clients = menuClient.getClients();
        List<LibraryItem> libraryItems = menuLibrary.getLibraryItems();

        Client client = Helper.findClient(userId, clients);
        LibraryItem libraryItem = Helper.findItem(elementId, libraryItems);
        
        if(client == null){
            System.out.println("There is no client with this ID");
            return;
        }
        
        if(libraryItem == null){
            System.out.println("There is no library item with this ID");
            return;
        }

        Integer currentStock = libraryItem.getStock();
        Integer newStock = currentStock + 1;
        libraryItem.setStock(newStock);
        client.removeElement(libraryItem);
    }

    public void borrowElement(Integer userId , Integer elementId){
        List<Client> clients = menuClient.getClients();
        List<LibraryItem> libraryItems = menuLibrary.getLibraryItems();

        Client client = Helper.findClient(userId, clients);
        LibraryItem libraryItem = Helper.findItem(elementId, libraryItems);
    
        if(client == null){
            System.out.println("There is no client with this ID");
            return;
        }
        
        if(libraryItem == null){
            System.out.println("There is no library item with this ID");
            return;
        }

        if(libraryItem.getStock() == 0){
            System.out.println("This element is currently out of stock");
            return;
        }
        Integer currentStock = libraryItem.getStock();
        Integer newStock = currentStock - 1;
        libraryItem.setStock(newStock);
        client.addElement(libraryItem);
    }
}
