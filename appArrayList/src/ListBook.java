
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListBook {
    ArrayList<Book> listbook = new ArrayList();
    
    public String Input(String text){
        return JOptionPane.showInputDialog(text);
    }
    
    public void addBook(){
        String name = Input("Book Name: ");
        String edition = Input("Book Edition: ");
        Book book = new Book();
        
        book.setName(name);
        book.setEdition(edition);
        listbook.add(book);
    }
    
    public void getBooks(){
        String string = "";
        for (int i = 0; i < listbook.size(); i++) {
            string += "Book "+(i+1)+"\n";
            string += "Name: " + listbook.get(i).getName()+"\n";
            string += "Edition: " + listbook.get(i).getEdition()+"\n";
        }
        
        JOptionPane.showMessageDialog(null, string);
    }
    
    public void clearListBook(){
        JOptionPane.showMessageDialog(null, "Books Cleared!");
        listbook.clear();
    }
}
