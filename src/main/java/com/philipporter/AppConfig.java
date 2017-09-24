package com.philipporter;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import com.philipporter.character.FictionalCharacter;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Philip Porter
 * @version 0.0.0
 */
@Configuration
public class AppConfig {
    
    @Autowired
    HazelcastInstance hzInstance;
    
    @Bean
    public HazelcastInstance hzInstance(){
        return Hazelcast.newHazelcastInstance();
    }
    
    @Bean
    public IdGenerator idGenerator(){
        return hzInstance.getIdGenerator("id");
    }
    
    @Bean
    public Map<Long,FictionalCharacter> map(){
        return hzInstance.getMap("characters");
    }
}
