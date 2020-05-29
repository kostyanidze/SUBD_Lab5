package SUBD.service.implementation;

import SUBD.entity.Orders;
import SUBD.repository.OrdersRepository;
import SUBD.service.serviceInterfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImplementation implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders addOrders(Orders orders) {
        Orders savedOrders = ordersRepository.saveAndFlush(orders);
        return savedOrders;
    }

    @Override
    public void delete(int id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Optional<Orders> getById(int id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders editOrders(Orders orders) {
        return ordersRepository.saveAndFlush(orders);
    }

    @Override
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }
}
