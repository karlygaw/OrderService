package kz.narxoz.rabbit.rabbitsender.sender;

import kz.narxoz.rabbit.rabbitsender.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    public OrderPublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    public void sendOrder(OrderDTO orderDTO) {
        String routingKey = "order." + orderDTO.getRegion().toLowerCase();
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, orderDTO);
        System.out.println("Order sent to region: " + orderDTO.getRegion());
    }
}
