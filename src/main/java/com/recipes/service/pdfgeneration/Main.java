package com.recipes.service.pdfgeneration;

import com.recipes.entity.Recipe;
import com.recipes.entity.User;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        RecipePdfGeneratorImpl generator = new RecipePdfGeneratorImpl();
        Recipe recipe = new Recipe();
        User user = new User();
        user.setLastName("Ivanenko");
        user.setFirstName("Іван");
        recipe.setDescription("Запашний штрудель із курятиною та грибами — ситна версія популярної страви, яку подарували світу австрійці. Соковита пропечена начинка, загорнута в тонке хрустке тісто: цей апетитний пиріг — ідеальний до обіду чи на перекус.\n" +
                "\n" +
                "Класичний штрудель готують із витяжного тіста на основі пшеничного борошна, вершкового масла та води, яке спочатку витримують у холоді, а потім ретельно розкачують. Та якщо вам потрібна швидка альтернатива, скористайтеся зручною заготовкою ТМ «Рудь». З нашим листковим тістом приготування буде легким і приємним, а випічка — смачною і ніжною.");

        recipe.setInstruction("Для приготування начинки чудово підійдуть шампіньйони та куряча грудка. А твердий сир подарує страві апетитні вершкові нотки.\n" +
                "\n" +
                " Гриби та цибулю нарізаємо, солимо і смажимо на розігрітій сковороді з олією до золотистого кольору. Даємо охолонути.\n" +
                "\n" +
                " Куряче філе відварюємо в підсоленій воді, нарізаємо невеликими кубиками та додаємо до грибів.\n" +
                "\n" +
                " Сир натираємо на грубій тертці, перемішуємо з грибами та курятиною. Додаємо сметану.\n" +
                "\n" +
                "Розморожуємо тісто за інструкцією на упаковці.\n" +
                "\n" +
                " Гриби та цибулю нарізаємо, солимо і смажимо на розігрітій сковороді з олією до золотистого кольору. Даємо охолонути.\n" +
                "\n" +
                " Куряче філе відварюємо в підсоленій воді, нарізаємо невеликими кубиками та додаємо до грибів.\n" +
                "\n" +
                " Сир натираємо на грубій тертці, перемішуємо з грибами та курятиною. Додаємо сметану.\n" +
                "\n" +
                "Готовий штрудель найкраще смакує зі свіжими овочами, зеленню або соусом зі сметани, часнику та кропу." +
                "Розморожуємо тісто за інструкцією на упаковці.\n" +
                "\n" +
                " Тісто тонко розкачуємо. Вздовж однієї сторони викладаємо начинку.\n" +
                "\n");
        recipe.setName("Штрудель");
        recipe.setRating(4.2);
        recipe.setCookingTime(120);
        recipe.setDishType("Перша страва");
        recipe.setUser(user);
        recipe.setImagePath("src/main/resources/pdf-resources/12.jpg");
        List<Recipe> recipes = List.of(recipe, recipe, recipe);
//        generator.generateRecipe(recipe);
//        generator.generateRecipesBook(recipes);
        PDDocument document = new PDDocument();

        document=generator.generateRecipesBook(recipes);

        document.save("recipes.pdf");
    }
}
