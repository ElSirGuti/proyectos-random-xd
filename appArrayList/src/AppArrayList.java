
import javax.swing.JOptionPane;

public class AppArrayList {

    public static void main(String[] args) {
        
        ListBook obj = new ListBook();
        
        byte opcion;
        
        do{
            opcion = Byte.parseByte(JOptionPane.showInputDialog("Menu Principal \n 1. Add Book \n 2. Books list \n 3. Clear List Book \n 4. Exit")); 
            
            switch(opcion){
                case 1:
                    obj.addBook();
                    break;
                case 2:
                    obj.getBooks();
                    break;
                case 3:
                    obj.clearListBook();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Goodbye :D");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not Found");
                    break;
                    
            }
            
        }while(opcion != 4);
        
    }
    
}
