package SUBD.repository;

import SUBD.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("Select new SUBD.repository.OrdersBetweenTwoDates(ord.id, ord.dateOfIssuance, t.country, t.cost) " +
            "from Orders ord JOIN Tour t on ord.tour = t where ord.dateOfIssuance >='2020-12-03' " +
            "and ord.dateOfIssuance <= '2020-12-20'")
    List<OrdersBetweenTwoDates> findOrders();
}
