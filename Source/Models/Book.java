package Models;

public class Book extends LibraryItem {

    public Book(Integer id , String title , Integer stock){
        this.id = id;
        this.title = title;
        this.stock = stock;
    }
    @Override
    public Integer getId(){
        return this.id;
    }
    
    @Override
    public String getTitle(){
        return this.title;
    }
    
    @Override
    public void getItemDetails() {
        System.out.println("The book id is: "+id+" and the book name is: "+title + " its stock is: "+stock);
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public void setName(String title) {
        this.title = title;
    }
    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    @Override
    public Integer getStock() {
        return this.stock;
    }
    
}
