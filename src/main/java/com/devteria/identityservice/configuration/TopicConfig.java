package com.devteria.identityservice.configuration;

import com.devteria.identityservice.constants.KafkaConstant;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class TopicConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConstant.class);

    private static final int DEFAULT_PARTITION = 1;
    private static final int DEFAULT_REPLICAS = 3;
    private static final Map<String, String> DEFAULT_CONFIGS = new HashMap<>();

    public KafkaAdmin admin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.URL);
        return new KafkaAdmin(configs);
    }
    private NewTopic CreateNewTopic(String topic, int partition, int replicas, Map<String, String> configs){
        TopicBuilder builder = TopicBuilder.name(topic)
                .partitions(partition)
                .replicas(replicas);
        configs.forEach(builder::config);

        return builder.build();
    }
    private NewTopic CreateDeafaultTopic(String topic){
        return CreateNewTopic(topic, DEFAULT_PARTITION,DEFAULT_REPLICAS,DEFAULT_CONFIGS);
    }

    public List<NewTopic> topics() {

        List<NewTopic> topics = new ArrayList<>();
        topics.add(CreateDeafaultTopic("TRANSFER_DATA"));
        for (int i = 0; i < topics().size() ; i++) {
            logger.info("CREATE NEW TOPIC: {}",topics.get(i));
        }
        return topics;
    }
}
