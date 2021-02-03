package uk.co.zenitech;

import org.springframework.boot.SpringApplication;
import uk.co.zenitech.service.ArtistService;

public class Application {
    public static void main(String[] args) {
        var context = SpringApplication.run(Configuration.class, args);
        context.getBean(ArtistService.class).find("artist");
    }
}
