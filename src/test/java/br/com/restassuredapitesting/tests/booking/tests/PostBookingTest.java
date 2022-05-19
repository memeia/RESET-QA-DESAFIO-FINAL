package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Criar Reservas")
public class PostBookingTest extends BaseTest {
   PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o schema de retorno da reserva")
    public void validaSchemaDaReserva(){

        postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","booking"))));
    }
}
