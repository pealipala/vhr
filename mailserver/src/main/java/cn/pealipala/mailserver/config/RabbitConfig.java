package cn.pealipala.mailserver.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/23 23:25
 */
@Configuration
public class RabbitConfig {

    @Bean
    Queue queue(){
        return new Queue("mail");
    }
}
