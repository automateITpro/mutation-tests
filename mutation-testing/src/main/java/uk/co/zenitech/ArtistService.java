package uk.co.zenitech;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalQuery;
import uk.co.zenitech.domain.Artist;

public class ArtistService {

    public boolean hasAlbumReleasedInAutumn(Artist artist) {
        return !artist.getAlbums().isEmpty()
                && artist.getAlbums().stream().anyMatch(album -> album.getReleaseDate().query(AUTUMN_MONTH_QUERY));
    }

    private static final TemporalQuery<Boolean> AUTUMN_MONTH_QUERY = temporal -> {
        var month = LocalDate.from(temporal).getMonthValue();
        return month >= Month.SEPTEMBER.getValue() && month <= Month.NOVEMBER.getValue();
    };
}
