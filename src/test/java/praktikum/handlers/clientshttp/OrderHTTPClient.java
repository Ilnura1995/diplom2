package praktikum.handlers.clientshttp;

import io.restassured.response.Response;
import praktikum.Urls;
import praktikum.entities.request.Order;

public class OrderHTTPClient extends BaseHTTPClient {
    public Response createOrder(Order order, String token) {
        return doPostRequest(
                Urls.HOST + Urls.ORDERS,
                order,
                "application/json"
        );
    }
    public Response getIngredientList() {
        return doGetRequest(
                Urls.HOST + Urls.INGREDIENTS
        );
    }

    public Response getOrderList(String token) {
        return doGetRequest(
                Urls.HOST + Urls.ORDERS, token
        );
    }

    public Response getOrderListAll() {
        return doGetRequest(
                Urls.HOST + Urls.ORDERS_ALL
        );
    }
}
