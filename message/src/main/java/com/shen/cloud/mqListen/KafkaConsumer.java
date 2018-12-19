package com.shen.cloud.mqListen;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * 消费者 spring-kafka 2.0 + 依赖JDK8
 * @author 科帮网 By https://blog.52itstyle.com
 */
@Component
public class KafkaConsumer {
    /**
     * 监听seckill主题,有消息就读取
     * @param message
     */
    @KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "seckill", partitions = { "0" }) })
    public void receiveMessage(String message){
        //收到通道的消息之后执行秒杀操作
        System.out.println(message);
    }
}