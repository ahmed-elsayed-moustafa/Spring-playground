import static org.junit.Assert.*;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.util.NestedServletException;

import ume.pareva.springboot.controller.NotificationController;
import ume.pareva.springboot.models.SubscriptionNotification;
import ume.pareva.springboot.other.IncompleteServiceRequestException;
import ume.pareva.springboot.service.SubscriptionNotificationService;

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockInjection.class)
public class SubscriptionNotificationTest extends AbstractTest {

	private SubscriptionNotificationService mock;

	@InjectMocks
	private NotificationController nc;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mock = mock(SubscriptionNotificationService.class);
		this.mockMvc = MockMvcBuilders.standaloneSetup(nc)
				.setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver()).build();
	}

	@Test
	public void testfindAll() {
		when(mock.findAll()).thenReturn(new ArrayList<SubscriptionNotification>());
		List<SubscriptionNotification> snlist = (List<SubscriptionNotification>) mock.findAll();
		assertEquals(0, snlist.size());
	}

	@Test
	public void testExceptionMessage() throws Exception {
		try {
			mockMvc.perform(get("/billing/SubscriptionNotification").param("msisdn", "").param("txId", "test")
					.param("status", "test").param("operator", "test").param("order", "test").param("service", "test")
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
		mockMvc.perform(get("/billing/SubscriptionNotification").param("msisdn", "test").param("txId", "test")
				.param("status", "test").param("operator", "test").param("order", "test").param("service", "test")
				.param("billingType", "test").param("subsId", "test").param("xxQSxx", "test")).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}
}
