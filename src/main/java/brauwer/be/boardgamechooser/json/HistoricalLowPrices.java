/* Copyright 2022 freecodeformat.com */
package brauwer.be.boardgamechooser.json;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/* Time: 2022-05-11 14:43:46 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class HistoricalLowPrices {

    private String country;
    private Date date;
    private String price;
    @JsonProperty("isLow")
    private boolean islow;
    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setPrice(String price) {
         this.price = price;
     }
     public String getPrice() {
         return price;
     }

    public void setIslow(boolean islow) {
         this.islow = islow;
     }
     public boolean getIslow() {
         return islow;
     }

}