package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.runners.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de Reservas")
public class GetBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostBookingRequest postBookingRequest = new PostBookingRequest();


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar ids de reservas")
    public void validaListagemDeIdsDasReservas() {
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(8));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o schema de retorno da listagem de reservas")
    public void validaSchemaDaListagemDeReservas() {

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class, AcceptanceTests.class})
    @DisplayName("Garantir o schema de retorno de reserva especifica")
    public void validaSchemaDeReservaEspecifica() {

        int id = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");


        getBookingRequest.bookingReturnId(id)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "booking"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar uma reserva especifica")
    public void validaReservaEspecifica() {

        int id = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");


        getBookingRequest.bookingReturnId(id)
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar reservas pelo firstname")
    public void listaReservaPeloFirstname() {

        String firstname = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("booking.firstname");

        getBookingRequest.filterByFirstName(firstname)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar reservas pelo lastname")
    public void listaReservaPeloLastname() {

        String lastname = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("booking.lastname");

        getBookingRequest.filterByLastName(lastname)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar reservas pela Data de Checkin")
    public void listaReservaPelaDataDeCheckin() {

        String datein = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("booking.bookingdates.checkin");

        getBookingRequest.filterByDateCheckin(datein)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar reservas pela Data de Checkout")
    public void listaReservaPelaDataDeCheckout() {

        String dateout = postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .extract()
                .path("booking.bookingdates.checkout");

        getBookingRequest.filterByDateCheckout(dateout)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Listar reservas pela Data de Checkin e Checkout")
    public void listaReservaPelaDataDeCheckinCheckout() {

        postBookingRequest.createBooking()
                .then()
                .statusCode(200);


        getBookingRequest.filterByDateCheckinAndCheckout("2018-01-01", "2018-01-02")
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Listar reservas pelo Nome Completo, Data de Checkin e Checkout")
    public void listaReservaPeloNomeCompletoDataDeCheckinCheckout() {

        postBookingRequest.createBooking()
                .then()
                .statusCode(200);

        getBookingRequest.filterByFullNameDateCheckinAndCheckout(
                        "Cristiano",
                        "Ronaldo",
                        "2018-01-01",
                        "2018-01-02"
                )
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Fazer consulta de reservas enviando filtro mal formatado ")
    public void filtroDataMalFormatado() {


        getBookingRequest.filterByDateCheckin("69-54-256")
                .then()
                .statusCode(500);

        getBookingRequest.filterByDateCheckout("69-54-256")
                .then()
                .statusCode(500);
    }
}
