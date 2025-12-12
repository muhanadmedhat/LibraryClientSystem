package Controllers;
import java.util.*;

import Exceptions.ItemNotFoundException;
import Models.LibraryItem;
public class Library <T extends LibraryItem> {
    private List<T> libraryItems;

    public Library(){
        libraryItems = new ArrayList<>();
    }

    public Library(List<T> items){
        this.libraryItems = items;
    }

    public List<T> getLibraryList(){       
        return this.libraryItems; 
    }
    

    public void addItem(T item){
        Integer itemId = item.getId();
        String itemTitle = item.getTitle();
        Integer stock = item.getStock();
       for(int i=0;i<libraryItems.size();i++) {
            if(itemId.equals(libraryItems.get(i).getId())){
                System.out.println("This ID is already used");
                return;
            }
            if(itemTitle.equals(libraryItems.get(i).getTitle())){
                System.out.println("This item is already added");
                return;
            }
       }
       libraryItems.add(item);
       System.out.println("========Element added successfully========");
    }

    public void getItem(Integer ind) throws ItemNotFoundException{
        if(ind < 0) throw new ItemNotFoundException();
        for(int i=0;i<libraryItems.size();i++){
            if(ind.equals(libraryItems.get(i).getId())){
             libraryItems.get(i).getItemDetails();
             return;
            }
        }
        throw new ItemNotFoundException();
    }

    public void viewItems(){
        for(int i=0;i<libraryItems.size();i++){
            LibraryItem lItem = libraryItems.get(i);
            lItem.getItemDetails();
        }
    }

    public void deleteItem(String name)throws ItemNotFoundException{
        for(int i=0;i<libraryItems.size();i++){
            LibraryItem lItem = libraryItems.get(i);
            if(name.equals(lItem.getTitle())){
                libraryItems.remove(i);
                System.out.println("========Item deleted successfully========");
                return;
            }
        }
        throw new ItemNotFoundException();
    }

    public void updateTitle(String oldName , String newName) throws ItemNotFoundException{
         for(int i=0;i<libraryItems.size();i++){
            LibraryItem lItem = libraryItems.get(i);
            if(oldName.equals(lItem.getTitle())){
                libraryItems.get(i).setName(newName);
                System.out.println("========Item updated successfully========");
                return;
            }
        }
        throw new ItemNotFoundException();
    }

    public boolean isItemInStock(Integer itemId){
        for(int i=0;i<libraryItems.size();i++){
            LibraryItem libraryItem = libraryItems.get(i);
            if(itemId.equals(libraryItem.getId())){
                if(libraryItem.getStock() == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
