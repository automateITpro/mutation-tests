package uk.co.zenitech;

import static java.time.Month.OCTOBER;
import static uk.co.zenitech.Constants.ARTIST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.zenitech.domain.Genre;
import uk.co.zenitech.factory.ArtistFactory;

public class ArtistServiceTest {

    private final ArtistService artistService = new ArtistService();

    @Test
    void givenOneAlbumReleasedInOctober_whenCheckingIfEverReleasedInAutumn_thenReturnTrue() {
        var artist = ArtistFactory.createArtist(ARTIST, Genre.minimal, OCTOBER, 1);
        Assertions.assertTrue(artistService.hasAlbumReleasedInAutumn(artist));
    }
}
