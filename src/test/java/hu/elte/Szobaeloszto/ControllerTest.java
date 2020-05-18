package hu.elte.Szobaeloszto;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.elte.Szobaeloszto.Repositories.BeosztasRepository;
import hu.elte.Szobaeloszto.Repositories.EpuletRepository;
import hu.elte.Szobaeloszto.Repositories.SzobaRepository;
import hu.elte.Szobaeloszto.Repositories.UserRepository;
import hu.elte.Szobaeloszto.Security.AuthenticatedUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@MockBean
AuthenticatedUser authenticatedUser;

@MockBean
BeosztasRepository beoRepo;

@MockBean
EpuletRepository epuletRepo;

@MockBean
SzobaRepository szobaRepo;

@MockBean
UserRepository userRepo;

@MockBean
private BCryptPasswordEncoder passwordEncoder;

@WithMockUser(value = "MVCtestprofile")
@Test
void whenValidInput_thenReturns200() throws Exception {
    mockMvc.perform(get("/szobak").contentType("application/json")).andExpect(status().is(200));
}

@WithMockUser(value = "MVCtestprofile")
@Test
void usersTest() throws Exception {
    mockMvc.perform(get("/users").contentType("application/json")).andExpect(status().is(404));
}

@WithMockUser(value = "MVCtestprofile")
@Test
void szobakTest() throws Exception {
    mockMvc.perform(get("/beosztas").contentType("application/json")).andExpect(status().is(200));
}
}