package hu.elte.Szobaeloszto;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.elte.Szobaeloszto.Repositories.BeosztasRepository;
import hu.elte.Szobaeloszto.Repositories.DiakRepository;
import hu.elte.Szobaeloszto.Repositories.EpuletRepository;
import hu.elte.Szobaeloszto.Repositories.SzobaRepository;
import hu.elte.Szobaeloszto.Repositories.UserRepository;
import hu.elte.Szobaeloszto.Security.AuthenticatedUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest()
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
DiakRepository diakRepo;

@MockBean
EpuletRepository epuletRepo;

@MockBean
SzobaRepository szobaRepo;

@MockBean
UserRepository userRepo;

@MockBean
private BCryptPasswordEncoder passwordEncoder;


@Test
void whenValidInput_thenReturns200() throws Exception {
    mockMvc.perform(get("/diakok").contentType("application/json")).andExpect(status().is(200));
}

@Test
void usersTest() throws Exception {
    mockMvc.perform(get("/users").contentType("application/json")).andExpect(status().is(404));
}

@Test
void diakokTest() throws Exception {
    mockMvc.perform(get("/diakok").contentType("application/json")).andExpect(status().is(200));
}

@Test
void szobakTest() throws Exception {
    mockMvc.perform(get("/szobak").contentType("application/json")).andExpect(status().is(200));
}
}