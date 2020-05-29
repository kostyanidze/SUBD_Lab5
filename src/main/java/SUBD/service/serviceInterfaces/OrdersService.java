package SUBD.service.serviceInterfaces;

import SUBD.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {
    Orders addOrders(Orders orders);
    void delete(int id);
    Optional<Orders> getById(int id);
    Orders editOrders(Orders Orders);
    List<Orders> getAll();
}
