package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import static javax.swing.JOptionPane.*;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/**
 * This class manages the application's frames
 * 
 * @author Daniele Cuomo N8601346
 */
public class ViewController{
    private static JFrame frame;
    
    /**
     * Opens the initial login frame
     * 
     * @param args can be null
     */
    public static void main( String[] args ){
        LookAndFeelInfo[] arr = getInstalledLookAndFeels();
        try{
            setLookAndFeel(arr[3].getClassName());
        }catch(ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex){}
        frame = new view.Login();
        frame.setVisible(true);
    }    
    
    /**
     * Check if the string is a valid date
     * 
     * @param date the formatted string
     * @return if the string is valid, returns the corresponding date, otherwise null.
     */
    public static Date getValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try{ return dateFormat.parse(date.trim()); } 
        catch(ParseException pe){ return null; }
    }
    
    /**
     * Initializes a frame object and set it visible.
     * 
     * @param f A subclass of JFrame
     */
    public static void openFrame( Class<? extends JFrame> f ){
        frame.setVisible(false);
        frame.dispose();

        DataController.clear();

        try {
            frame = f.newInstance();
            frame.setVisible(true);
        } catch (InstantiationException | IllegalAccessException e){
            showException( e );
        }
    }
    
    /**
     * Shows errors to the user
     * 
     * @param ex the exception to be shown
     */
    public static void showException( Exception ex ){
        String msg = ErrorController.getMessage( ex );
        System.err.println( msg );
        showMessageDialog(frame, msg, "Error", ERROR_MESSAGE);
    }
    
    /**
     * Shows informations to the user
     * 
     * @param o the message to be shown
     */
    public static void showInfo( Object o ){
        System.out.println( o );
        showMessageDialog(frame, o, "Info Pop-up", DEFAULT_OPTION);
    }
    
    /**
     * Prompts the user for confirmation
     * 
     * @return  true if the user presses yes button, false otherwise.
     */
    public static boolean getConfirm(){
        int c = showConfirmDialog(frame,
                "Are you sure you want to complete this operation?", "Warning",
                YES_NO_OPTION);
        return c == 0;
    }
    
    /**
     * Prompts the user for answer
     * 
     * @param qst question that will be displayed
     * @return answer
     */
    public static String getAnswer(String qst){
        return showInputDialog(frame, null, qst, OK_CANCEL_OPTION);
    }
}