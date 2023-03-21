package com.okan.ServeMyself_BE.service;

import com.okan.ServeMyself_BE.exception.UserNotFoundException;
import com.okan.ServeMyself_BE.model.Orders;
import com.okan.ServeMyself_BE.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class OrderService {

    private final OrderRepository orderRepository;

    public Orders create(Orders tray){
        return orderRepository.save(tray);
    }




    public List<Orders> getOrders()
    {
        return orderRepository.findAll();
    }



    public Orders update(Orders tray){
        Orders existing = findOrderByID(tray.getId());
        existing.setOrdertable(tray.getOrdertable());
        existing.setOrderstatus(tray.getOrderstatus());
        existing.setOrderlist(tray.getOrderlist());

        return orderRepository.save(tray);
    }
    public Orders updateStatus(Orders tray){
        Orders existing = findOrderByID(tray.getId());
        existing.setOrderstatus(tray.getOrderstatus());

        return orderRepository.save(tray);
    }

    public Orders findOrderByID(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Order Not Found!"));
    }

    public boolean doesOrderExistByID(Long id)
    {
        return orderRepository.findById(id).isPresent();
    }

    public void deleteOrder(Long id) {
        if (doesOrderExistByID(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Order Not Found!");
        }
    }

}
