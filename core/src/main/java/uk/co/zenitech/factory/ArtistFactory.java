package uk.co.zenitech.factory;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.RandomUtils;
import uk.co.zenitech.domain.Album;
import uk.co.zenitech.domain.Artist;
import uk.co.zenitech.domain.Genre;

public class ArtistFactory {

    public Artist delegateCreateArtist(String name, Genre genre) {
        return createArtist(name, genre);
    }

    private static final int MAX_DAYS_IN_MONTH_EXCLUSIVE = 30;
    private static final int MAX_SONGS_EXCLUSIVE = 11;

    public static Artist createArtist(String name, Genre genre) {
        return createArtist(name, genre, Month.SEPTEMBER, 1);
    }

    public static Artist createArtist(String name, Genre genre, Month month, int albums) {
        return new Artist(name, genre, createAlbums(month, albums));
    }

    public static Set<Album> createAlbums(Month month, int albums) {
        if (albums > 0) {
            return IntStream.rangeClosed(1, RandomUtils.nextInt(1, albums)).mapToObj(
                    i -> new Album(String.format("album_%d", i),
                            LocalDate.of(2020, month.getValue(),
                                    RandomUtils.nextInt(1, MAX_DAYS_IN_MONTH_EXCLUSIVE)),
                            createSongs()))
                    .collect(Collectors.toSet());
        } else {
            return Collections.emptySet();
        }
    }

    public static List<String> createSongs() {
        return IntStream.rangeClosed(1, RandomUtils.nextInt(1, MAX_SONGS_EXCLUSIVE))
                .mapToObj(i  -> String.format("song_%d", i))
                .collect(Collectors.toList());
    }
}
