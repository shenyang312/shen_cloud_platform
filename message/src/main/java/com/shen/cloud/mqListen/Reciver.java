package com.shen.cloud.mqListen;

import com.shen.cloud.QueueCode;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues= QueueCode.TEST_ONE)
//@RabbitListener(queuesToDeclare = @Queue("queue"))
//@RabbitListener(bindings=@QueueBinding(value=@Queue("queue"),exchange=@Exchange("exchange")));
public class Reciver {

    @RabbitHandler
    public void process(String hello){
        System.out.print("reciver:"+hello);
    }
}
