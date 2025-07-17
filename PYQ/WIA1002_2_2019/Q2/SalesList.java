/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */
public class SalesList {
    private String region;
    private String salesRepresentativeName;
    private Integer salesAmount;
    
    public SalesList(){
        this(null, null, 9);
    }
    
    public SalesList(String region, String salesRepresentativeName, Integer salesAmount){
        this.region = region;
        this.salesRepresentativeName = salesRepresentativeName;
        this.salesAmount = salesAmount;
    }
    
    public String getRegion() {
        return region;
    }

    public String getSalesRepresentativeName() {
        return salesRepresentativeName;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }
    
    @Override
    public String toString(){
        return String.format("%-11s %3d %s", region, salesAmount, salesRepresentativeName);
    }
}
