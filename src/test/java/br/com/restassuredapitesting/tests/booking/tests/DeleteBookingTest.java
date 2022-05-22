package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.runners.AcceptanceTests;
import br.com.restassuredapitesting.runners.SecurityTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;


@Feature("Feature - Excluir uma Reserva")
public class DeleteBookingTest extends BaseTest {
    PostBookingRequest postBookingRequest = new PostBookingRequest();
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Excluir Reserva")
    public void excluirReserva() {

        String token = postAuthRequest.getToken();
        int id = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");

        deleteBookingRequest.deleteBooking(id, token)
                .then()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Excluir Reserva Inexistente")
    public void excluirReservaInesistente() {

        String token = postAuthRequest.getToken();
        int id = 999999999;

        deleteBookingRequest.deleteBooking(id, token)
                .then()
                .statusCode(405);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, SecurityTests.class})
    @DisplayName("Excluir Reserva sem Autorização")
    public void excluirReservaSemAutorizacao() {

        String token = "";
        int id = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");

        deleteBookingRequest.deleteBooking(id, token)
                .then()
                .statusCode(403);
    }
}
