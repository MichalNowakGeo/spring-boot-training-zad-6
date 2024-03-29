package pl.sda.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.sda.config.SecurityConfig;
import pl.sda.service.PersonService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
@Import(SecurityConfig.class)
class PersonControllerIT {

    @MockBean
    private PersonService personService;

    @Autowired
    private MockMvc mockMvc;

    String newUserJson = "{" +
            "        \"firstName\": \"Ania\",\n" +
            "        \"lastName\": \"Nowak\",\n" +
            "        \"age\": 20,\n" +
            "        \"pesel\": \"51101069339\",\n" +
            "        \"password\": \"$2a$12$Y3grN5uQ8jrSsNEj28NBgO2DhDJ4yCcNsLMQz0Z6wAdsoP3iDms/G\"" +
            " }";

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldCreatePersonWhenValidRequestBody() throws Exception {
        mockMvc.perform(
                        post("/persons")
                                .content(newUserJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldReturn400WhenInValidRequestBody() throws Exception {
        mockMvc.perform(
                        post("/persons")
                                .content("{}")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void should() throws Exception {
//        mockMvc.perform(
//
//                )
//                .andExpect(status().isOk());
    }

}
