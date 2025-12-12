package Models;

public abstract class LibraryItem{
    protected Integer id;
    protected String title;
    protected Integer stock;
    public abstract void setId(Integer id);
    public abstract void setName(String title);
    public abstract void setStock(Integer stock);
    public abstract Integer getId();
    public abstract String getTitle();
    public abstract Integer getStock();
    public abstract void getItemDetails();
}
