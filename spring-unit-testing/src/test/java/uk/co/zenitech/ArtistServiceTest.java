package uk.co.zenitech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import uk.co.zenitech.domain.Genre;
import uk.co.zenitech.factory.ArtistFactory;
import uk.co.zenitech.repository.ArtistRepository;
import uk.co.zenitech.service.ArtistService;

@SpringBootTest()
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ArtistServiceTest {

    @MockBean
    ArtistRepository artistRepository;

    @Autowired
    ApplicationContext context;

    @Test
    void springTest1() {
        var artist = ArtistFactory.createArtist("artist", Genre.jazz);
        Mockito.when(artistRepository.find(Mockito.anyString())).thenReturn(artist);

        var artistService = context.getBean(ArtistService.class);
        var savedArtist = artistService.find("artist");

        Assertions.assertEquals(artist, savedArtist);
    }

    @Test
    void springTest2() {
        var artist = ArtistFactory.createArtist("artist2", Genre.jazz);
        Mockito.when(artistRepository.find(Mockito.anyString())).thenReturn(artist);

        var artistService = context.getBean(ArtistService.class);
        var savedArtist = artistService.find("artist2");

        Assertions.assertEquals(artist, savedArtist);
    }
}
