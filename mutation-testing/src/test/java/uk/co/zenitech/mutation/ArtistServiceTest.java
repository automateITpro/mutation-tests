package uk.co.zenitech.mutation;

import static java.time.Month.*;
import static uk.co.zenitech.Constants.ARTIST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.zenitech.ArtistService;
import uk.co.zenitech.domain.Genre;
import uk.co.zenitech.factory.ArtistFactory;

public class ArtistServiceTest {
    private final ArtistService artistService = new ArtistService();

    @Test
    void givenZeroAlbumsReleasedInJanuary_whenCheckingIfEverReleasedInAutumn_thenReturnFalse() {
        var artist = ArtistFactory.createArtist(ARTIST, Genre.minimal, JANUARY, 0);
        Assertions.assertFalse(artistService.hasAlbumReleasedInAutumn(artist));
    }

    @Test
    void givenOneAlbumReleasedInAugust_whenCheckingIfEverReleasedInAutumn_thenReturnFalse() {
        var artist = ArtistFactory.createArtist(ARTIST, Genre.minimal, AUGUST, 1);
        Assertions.assertFalse(artistService.hasAlbumReleasedInAutumn(artist));
    }

    @Test
    void givenOneAlbumReleasedInSeptember_whenCheckingIfEverReleasedInAutumn_thenReturnTrue() {
        var artist = ArtistFactory.createArtist(ARTIST, Genre.minimal, SEPTEMBER, 1);
        Assertions.assertTrue(artistService.hasAlbumReleasedInAutumn(artist));
    }

    @Test
    void givenOneAlbumReleasedInNovember_whenCheckingIfEverReleasedInAutumn_thenReturnTrue() {
        var artist = ArtistFactory.createArtist(ARTIST, Genre.minimal, NOVEMBER, 1);
        Assertions.assertTrue(artistService.hasAlbumReleasedInAutumn(artist));
    }

    @Test
    void givenOneAlbumReleasedInDecember_whenCheckingIfEverReleasedInAutumn_thenReturnFalse() {
        var artist = ArtistFactory.createArtist(ARTIST, Genre.minimal, DECEMBER, 1);
        Assertions.assertFalse(artistService.hasAlbumReleasedInAutumn(artist));
    }
}
