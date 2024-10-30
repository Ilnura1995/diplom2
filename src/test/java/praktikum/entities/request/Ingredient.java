package praktikum.entities.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingredient {

    private String _id;
    private String name;
    private String type;
    private double proteins;
    private double fat;
    private double carbohydrates;
    private int calories;
    private double price;
    private String image;
    private String imageMobile;
    private String imageLarge;
    private int version;

}
