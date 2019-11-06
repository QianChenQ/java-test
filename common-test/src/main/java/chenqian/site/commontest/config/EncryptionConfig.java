package chenqian.site.commontest.config;

import chenqian.site.commontest.service.AbstractEncryption;
import chenqian.site.commontest.service.RSAEncryption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@Configuration
public class EncryptionConfig {

    @Bean
    public AbstractEncryption encryption() {
        return new RSAEncryption();
    }
}
