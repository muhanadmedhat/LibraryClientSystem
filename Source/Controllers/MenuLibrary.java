package Controllers;
import java.util.*;

import Exceptions.ItemNotFoundException;
import Helper.Helper; 
import Models.Book;
import Models.LibraryItem;
import Models.Magazine;

public class MenuLibrary {
    private Library<LibraryItem> library;
    //private 
    public MenuLibrary(){
        library = new Library<LibraryItem>();
    }

    public List<LibraryItem> getLibraryItems(){
        return library.getLibraryList();
    }

    public void displayMenu(){
        while(true){
        Scanner input = new Scanner(System.in);
        System.out.println("Press: \n 1: Add books or magazines \n 2: View item details \n 3: Update item \n 4: Delete item \n 5: Display all items \n 6: Exit");
        
        String choice = input.nextLine();
        Integer choiceNumber = Helper.integerChecker(choice); //integerChecker(choice);
        
        while(choiceNumber<1 || choiceNumber>6){
            System.out.println("Choose number in the list");
            choice = input.nextLine();
            choiceNumber = Helper.integerChecker(choice);
        }
        if(choiceNumber == 1){
            addElement();
        }else if(choiceNumber == 2){
            try {
                retrieveElement();
            } catch (ItemNotFoundException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }else if(choiceNumber == 3){
            try {
                updateElement();
            } catch (ItemNotFoundException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }else if(choiceNumber == 4){
            try {
                deleteElement();
            } catch (ItemNotFoundException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }else if(choiceNumber == 5){
            displayElements();
        }else if(choiceNumber == 6){
            return;
        }
    }
    
    }

    public void addElement(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to add book and 2 to add magazine: ");
        String choice = input.nextLine();
        Integer choiceNumber = Helper.integerChecker(choice);
        while(choiceNumber < 1 || choiceNumber > 2){
            System.out.println("Invalid choice try again");
            choice = input.nextLine();
            choiceNumber = Helper.integerChecker(choice);
        }
        System.out.println("Enter the ID of the book");
        String idString = input.nextLine();
        Integer Id = Helper.integerChecker(idString);
        while(Id == -1){
            System.out.println("Invalid ID try anothr valid one");
            idString = input.nextLine();
            Id = Helper.integerChecker(idString);
        }
        System.out.println("Enter the title of the book");
        String title = input.nextLine();
        while(title.equals("")){
            System.out.println("Invalid title try new one");
            title = input.nextLine();
        }
        System.out.println("Enter the stock of the element");
        String stock = input.nextLine();
        Integer stockNumber = Helper.integerChecker(stock);
        while(stockNumber == -1){
            System.out.println("Enter valid stock");
            stock = input.nextLine();
            stockNumber = Helper.integerChecker(stock);
        }
        if(choiceNumber == 1){
        library.addItem(new Book(Id, title , stockNumber));
        }else{
            library.addItem(new Magazine(Id, title , stockNumber));
        }
        
        
    }


    public void retrieveElement() throws ItemNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID of the element to be retrieved");
        String id = input.nextLine();
        Integer Id = Helper.integerChecker(id);
        while(Id == -1){
            System.out.println("Invalid ID try again!");
            id = input.nextLine();
            Id = Helper.integerChecker(id);
        }
        library.getItem(Id);
        
    }

    public void updateElement()throws ItemNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the old title that will be changed: ");
        String oldName = input.nextLine();
        oldName = Helper.stringChecker(oldName);
        while(oldName.equals("")){
            System.out.println("Invalid name try again");
            oldName = input.nextLine();
            oldName = Helper.stringChecker(oldName);
        }
        System.out.println("Enter the new title: ");
        String newName = input.nextLine();
        newName = Helper.stringChecker(newName);
        while(newName.equals("")){
            System.out.println("Invalid name try again");
            newName = input.nextLine();
            newName = Helper.stringChecker(newName);
        }
        library.updateTitle(oldName, newName);
    }

    public void deleteElement() throws ItemNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the book to be deleted: ");
        String name = input.nextLine();
        name = Helper.stringChecker(name);
        while(name.equals("")){
            System.out.println("Invalid name try again");
            name = input.nextLine();
            name = Helper.stringChecker(name);
        } 
        library.deleteItem(name);
    }

    public void displayElements(){
        library.viewItems();
    }

    
}
