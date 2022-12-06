import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;

public class ProductReader {
    public ProductReader() {
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Path target = (new File(System.getProperty("user.dir"))).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog((Component)null) == 0) {
                target = chooser.getSelectedFile().toPath();
                BufferedReader inFile = new BufferedReader(new FileReader(target.toFile()));
                String line = inFile.readLine();
                System.out.println(" ID#                      Product Name                     Description               Cost");
                System.out.println("=============================================================================================");

                while((line = inFile.readLine()) != null) {
                    ArrayList<String> products = new ArrayList(Arrays.asList(line.split(",[ ]*")));
                    int spacingSeparation = 3;
                    int longest = "                         ".length();
                    int spacing = longest + spacingSeparation;
                    System.out.print(String.format("%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s\n", products.get(0), products.get(1), products.get(2), products.get(3)));
                }

                inFile.close();
            } else {
                System.out.println("Please select a file,program shutting down.");
                System.exit(0);
            }
        } catch (FileNotFoundException var9) {
            System.out.println("ERROR!!File not found ");
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

    }
}
