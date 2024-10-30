package praktikum.handlers.clientshttp;

import io.restassured.response.Response;
import praktikum.Urls;
import praktikum.entities.request.User;

public class UserHTTPClient extends BaseHTTPClient{
    public Response createUser(User user) {
        return doPostRequest(Urls.HOST + Urls.CREATE_USER,
                user, "application/json");
    }
    public Response deleteUser(String token) {
        return doDeleteRequest(
                Urls.HOST + Urls.USER, token);
    }
    public Response loginUser(User user) {
        return doPostRequest(
                Urls.HOST + Urls.LOGIN_USER,
                user,
                "application/json");
    }
    public Response updateUser(User user, String token) {
        return doPatchRequest(
                Urls.HOST + Urls.USER,
                user,
                "application/json",
                token
        );
    }
}
