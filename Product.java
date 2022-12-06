public class Product
{
    private String IDNum;
    private String productName;
    private String productDesc;
    private double productCost;

    public Product(String IDNum, String productName, String productDesc, double productCost)
    {
        this.IDNum = IDNum;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCost = productCost;
    }

    public String getIDNum()
    {
        return IDNum;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setProductDesc(String productDesc)
    {
        this.productDesc = productDesc;
    }

    public String getProductDesc()
    {
        return productDesc;
    }

    public void setProductCost(double productCost)
    {
        this.productCost = productCost;
    }

    public double getProductCost()
    {
        return productCost;
    }

    public String toCSVDataRecord()
    {
        return IDNum + ", " + productName + ", " + productCost;
    }
}

