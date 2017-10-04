import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.internal.configuration.injection.MockInjection;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ume.pareva.springboot.JsonObject.PayguruUnsubDTO;
import ume.pareva.springboot.controller.NotificationController;
import ume.pareva.springboot.models.BillingNotification;
import ume.pareva.springboot.other.IncompleteServiceRequestException;
import ume.pareva.springboot.service.BillingNotificationService;

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockInjection.class)
public class BillingNotificationTest extends AbstractTest {

	private BillingNotificationService mock;

	@InjectMocks
	private NotificationController nc;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mock = mock(BillingNotificationService.class);
		this.mockMvc = MockMvcBuilders.standaloneSetup(nc)
				.setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver()).build();
	}

	@Test
	public void testfindAll() {
		logger.info("Hello testfindAll");
		when(mock.findAll()).thenReturn(new ArrayList<BillingNotification>());
		List<BillingNotification> bnlist = (List<BillingNotification>) mock.findAll();
		assertEquals(0, bnlist.size());
	}

	@Test
	public void testExceptionMessage() {
		try {
			mockMvc.perform(get("/billing/BillingNotification").param("msisdn", "").param("txId", "test")
					.param("status", "test").param("operator", "test").param("order", "test").param("item", "test")
					.param("amount", "test").param("service", "test").param("error", "test").param("errorDesc", "test")
					.param("billingType", "test").param("subsId", "test").param("xxQSxx", "test"));
		} catch (Exception e) {
			if (e.getCause() instanceof IncompleteServiceRequestException) {
				assertEquals(e.getCause().getMessage(), "Compulsory arguments missing: "+ "msisdn");
			} else
				fail("incorrect expected exception");
		}

	}

	@Test
	public void allparameters() throws Exception {
		mockMvc.perform(get("/billing/BillingNotification").param("msisdn", "test").param("txId", "test")
				.param("status", "test").param("operator", "test").param("order", "test").param("item", "test")
				.param("amount", "test").param("service", "test").param("error", "test").param("errorDesc", "test")
				.param("billingType", "test").param("subsId", "test").param("xxQSxx", "test")).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testPayguruJson() throws Exception {
		mockMvc.perform(get("/billing/Unsubscription/{merchantId}/{serviceId}/{subscriptionId}", 802,1430,909090).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.response.status").value("0003"));
	}
	
}
