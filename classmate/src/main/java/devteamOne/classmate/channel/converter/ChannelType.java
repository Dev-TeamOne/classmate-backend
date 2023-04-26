package devteamOne.classmate.channel.converter;

import lombok.Getter;

@Getter
public enum ChannelType {
    ME("me", "내가만든채널"), 
    PARTICIPATED("participated", "내가참여한채널");

    private final String type;
    private final String description;

    ChannelType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static ChannelType of(String type) {
        if (type == null) {
            throw new IllegalArgumentException();
        }

        for (ChannelType channelType : ChannelType.values()) {
            if (channelType.type.equals(type.toLowerCase())) {
                return channelType;
            } 
        }

        throw new IllegalArgumentException();
    }
}
