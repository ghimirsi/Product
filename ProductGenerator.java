import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator
{
    private String IDNum;
    private String name;
    private String description;
    private double cost;
    private static int begin = 1;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Boolean moreProducts = true;
        String ID = "";
        String name = "";
        String description = "";
        Double cost = 0.0;
        ArrayList<String> products = new ArrayList();

        for(moreProducts = SafeInput.getYNConfirm(in, "Do you have a product to add to the list?"); moreProducts; moreProducts = SafeInput.getYNConfirm(in, "Do you want to add another product to the list?")) {
            ID = genIDNum();
            name = SafeInput.getNonZeroLenString(in, "What is the  product's name?");
            description = SafeInput.getNonZeroLenString(in, "Please provide the product's description?");
            cost = SafeInput.getDouble(in, "Enter the product's cost?");
            products.add(ID + ", " + name + ", " + description + ", " + cost);
            System.out.print(products);
            new ProductGenerator(ID, name, description, cost);
        }

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestFile.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            Files.write(file, products);
            writer.newLine();
            writer.close();
            System.out.print("successfully added new products to the list");
        } catch (FileNotFoundException var12) {
            var12.printStackTrace();
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }

    public static int getStartSeed() {
        return begin;
    }

    public static void setStartSeed(int startSeed) {
        ProductGenerator.begin = startSeed;
    }

    public ProductGenerator(String IDNum, String name, String description, double cost) {
        this.IDNum = IDNum;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public ProductGenerator(String name, String description, double cost) {
        this.IDNum = genIDNum();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getIDNum() {
        return this.IDNum;
    }

    private static String genIDNum() {
        String newID;
        for(newID = "" + begin; newID.length() < 6; newID = "0" + newID) {
        }

        ++begin;
        return newID;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString() {
        return "PersonGenerator{IDNum='" + this.IDNum + '\'' + ", firstName='" + this.name + '\'' + ", lastName='" + this.description + '\'' + ", yearOfBirth='" + this.cost + '\'' + '}';
    }
}



