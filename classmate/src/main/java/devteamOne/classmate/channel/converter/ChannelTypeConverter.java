package devteamOne.classmate.channel.converter;

import org.springframework.core.convert.converter.Converter;

public class ChannelTypeConverter implements Converter<String, ChannelType> {

    @Override
    public ChannelType convert(String value) {
        return ChannelType.of(value);
    }
}
