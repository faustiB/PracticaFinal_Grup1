import Presentation.Controller;
import Presentation.Menu;

import java.io.IOException;


/**
 * Main class of the program.
 */
public class Main {
    /**
     * Main function of the program.
     * @param args arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();

        Controller controller = new Controller(menu);
        controller.run();
    }
}
