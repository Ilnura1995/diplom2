package praktikum.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.entities.request.Ingredient;
import praktikum.entities.response.ResponseIngredients;
import praktikum.handlers.clientsapi.OrderApiClient;
import praktikum.handlers.clientsapi.ResponseChecks;
import praktikum.handlers.clientsapi.UserApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.fail;

@DisplayName("4. Создание заказа")
@Link(value = "Документация", url = "https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf")
public class TestsCreateOrder{

    private String email, password, name, token;
    private List<Ingredient> ingredients = new ArrayList<>();
    private final OrderApiClient orderApi = new OrderApiClient();
    private final UserApiClient userApi = new UserApiClient();
    private final ResponseChecks checks = new ResponseChecks();

    @Before
    @Step("Подготовка тестовых данных")
    public void prepareTestData() {
        createTestUser();
        loadIngredients();
    }

    @Step("Создание тестового пользователя")
    private void createTestUser() {
        email = "e-mail_" + UUID.randomUUID() + "@mail.com";
        password = "pass_" + UUID.randomUUID();
        name = "name";

        Response response = userApi.createUser(email, password, name);
        checks.checkStatusCode(response, 200);

        token = userApi.getToken(response);
        if (token == null) {
            fail("Токен не получен");
        }
    }

    @Step("Загрузка ингредиентов")
    private void loadIngredients() {
        Response response = orderApi.getIngredientList();
        checks.checkStatusCode(response, 200);
        ingredients = response.body().as(ResponseIngredients.class).getData();

        if (ingredients.isEmpty()) {
            fail("Список ингредиентов пуст");
        }
    }

    @After
    @Step("Удаление тестовых данных")
    public void cleanTestData() {
        if (token != null) {
            checks.checkStatusCode(userApi.deleteUser(token), 202);
        }
    }

    @Test
    @DisplayName("Создание заказа: с авторизацией и с ингредиентами")
    public void createOrderWithAuthAndIngredientsIsSuccess() {
        Response response = orderApi.createOrder(
                List.of(ingredients.get(0).get_id(), ingredients.get(ingredients.size() - 1).get_id()),
                token
        );

        checks.checkStatusCode(response, 200);
        checks.checkLabelSuccess(response, "true");
    }
}
