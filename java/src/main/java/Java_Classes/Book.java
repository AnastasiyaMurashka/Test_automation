package Java_Classes;

public class Book {
    // Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно методы в классе,
    // создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
    // В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
    //Создать массив объектов. Вывести:
    //a) список книг заданного автора;
    //b)   список книг, выпущенных заданным издательством;
    //c)   список книг, выпущенных после заданного года.
    private long id;
    private String nameBook;
    private String author;
    private String publisher;
    private int yearOfPublic;
    private int numOfPages;
    private double price;
    private String typeOfCover;
    Book(String nameBook, String author, int yearOfPublic, int numOfPages){
        this.nameBook=nameBook;
        this.author=author;
        this.yearOfPublic=yearOfPublic;
        this.numOfPages=numOfPages;
        id=0;
        price=0;
        typeOfCover="unknown";
    }
    Book(long id, String nameBook, String author, double price, String typeOfCover){
        this.id=id;
        this.nameBook=nameBook;
        this.author=author;
        this.price=price;
        this.typeOfCover=typeOfCover;
        publisher="unknown";
        yearOfPublic=0;
        numOfPages=0;
    }

    Book(long id, String nameBook, String author, String publisher, int yearOfPublic, int numOfPages, double price,
         String typeOfCover){
        this.id=id;
        this.nameBook=nameBook;
        this.author=author;
        this.publisher=publisher;
        this.yearOfPublic=yearOfPublic;
        this.numOfPages=numOfPages;
        this.price=price;
        this.typeOfCover=typeOfCover;
    }
    public void setID(long id){
        this.id=id;
    }
    public void setNameBook(String nameBook){
        this.nameBook=nameBook;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public void setYearOfPublic(int yearOfPublic){
        this.yearOfPublic=yearOfPublic;
    }
    public void setNumOfPages(int numOfPages){
        this.numOfPages=numOfPages;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setTypeOfCover(String typeOfCover) {
        this.typeOfCover = typeOfCover;
    }
    public long getId() {
        return id;
    }
    public String getNameBook() {
        return nameBook;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }

    public int getYearOfPublic() {
        return yearOfPublic;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public double getPrice() {
        return price;
    }

    public String getTypeOfCover() {
        return typeOfCover;
    }
    public String toString(){
        return String.format(" Book:\n ID %d;\n name %s;\n author %s;\n publisher %s;\n year of publication %d;\n",
                id, nameBook, author,publisher, yearOfPublic)+String.format(" number of pages %d;\n price %10.2f;" +
                "\n type of cover %s;",numOfPages,price,typeOfCover);
    }
}
