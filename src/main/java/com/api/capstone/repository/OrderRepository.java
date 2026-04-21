package com.api.capstone.repository;

import com.api.capstone.model.Order;
import com.api.capstone.model.Person;
import com.api.capstone.model.enums.OrderState;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.status = :status WHERE o.id = :id")
    void updateOrderStatus(@Param("id") Integer id, @Param("status") OrderState status);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.preparadorId = :preparador WHERE o.id = :id")
    void updateOrderPreparador(@Param("id") Integer id, @Param("preparador") Person preparador);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.entregadorId = :entregador WHERE o.id = :id")
    void updateOrderEntregador(@Param("id") Integer id, @Param("entregador") Person entregador);
}
