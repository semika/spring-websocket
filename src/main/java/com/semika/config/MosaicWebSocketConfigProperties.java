package com.semika.config;

import com.semika.constant.MosaicWebSocketConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = MosaicWebSocketConstant.Application.MOSAIC_WEBSOCKET_PROPERTY_PREFIX)
public class MosaicWebSocketConfigProperties {

    private UrlInfo url = new UrlInfo();

    @Data
    public static class UrlInfo {
        private String dest;
        private String handshake;
        private String connector;
    }
}
