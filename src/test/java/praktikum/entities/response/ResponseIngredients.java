package praktikum.entities.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import praktikum.entities.request.Ingredient;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseIngredients {
    public String success;
    public List<Ingredient> data;
}
