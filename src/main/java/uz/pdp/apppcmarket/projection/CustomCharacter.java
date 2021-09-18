package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;

import javax.xml.stream.events.Characters;

@Projection(types = Character.class)
public interface CustomCharacter {
    Integer getId();
    String getCharacterKey();
    String getCharacter();
}
