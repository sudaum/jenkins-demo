package net.sudau.samples.jenkins.domain.endpoints;

import static org.assertj.core.api.Assertions.assertThat;

import net.sudau.samples.jenkins.domain.services.SomeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SomeRestControllerTest {

    @Mock
    private SomeService someService;

    @InjectMocks
    private SomeRestController unitUnderTest;

    @Test
    void test () {
        assertThat(unitUnderTest).isInstanceOf(SomeRestController.class);
    }

}
