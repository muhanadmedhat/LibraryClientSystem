package Models;

public class Magazine extends LibraryItem{

    public Magazine(Integer id , String title , Integer stock){
        this.id = id;
        this.title = title;
        this.stock = stock;
    }
    public Integer getId(){
        return this.id;
    }

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
