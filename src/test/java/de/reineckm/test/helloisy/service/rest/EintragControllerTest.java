package de.reineckm.test.helloisy.service.rest;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/app-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@DatabaseSetup("eintraege.xml")
@WebAppConfiguration
public class EintragControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @ExpectedDatabase(value = "neuerEintrag.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testErstelleEintrag() throws Exception {
        String neuerEintragJson = ("{\"verfasser\":\"Autor3\",\"text\":\"Kommentar3\"}");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/eintrag").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(neuerEintragJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @ExpectedDatabase("eintraege.xml")
    public void testLeseEintraege() throws Exception {
        String expectedContent = "[{\"verfasser\":\"Autor1\",\"text\":\"Kommentar1\",\"datum\":\"2017-01-10T11:00Z\"},{\"verfasser\":\"Autor2\",\"text\":\"Kommentar2\",\"datum\":\"2017-01-10T12:00Z\"}]";

        mockMvc.perform(
                MockMvcRequestBuilders.get("/eintrag").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
