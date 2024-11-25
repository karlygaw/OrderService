package kz.narxoz.rabbit.rabbitsender.api;

import kz.narxoz.rabbit.rabbitsender.dto.OrderDTO;
import kz.narxoz.rabbit.rabbitsender.sender.OrderPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class RabbitController {

    private final OrderPublisher orderPublisher;

    public RabbitController(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        orderPublisher.sendOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order sent to region: " + orderDTO.getRegion());
    }
}
