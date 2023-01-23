package com.okan.ServeMyself_BE.service;

import com.okan.ServeMyself_BE.exception.UserNotFoundException;
import com.okan.ServeMyself_BE.model.Orders;
import com.okan.ServeMyself_BE.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class OrderService {

    private final OrdersRepository ordersRepository;

    public Orders create(Orders tray){
        return ordersRepository.save(tray);
    }




    public List<Orders> getOrders()
    {
        return ordersRepository.findAll();
    }



    public Orders update(Orders tray){
        Orders existing = findOrderByID(tray.getId());
        existing.setOrdertable(tray.getOrdertable());
        existing.setOrderstatus(tray.getOrderstatus());
        existing.setOrderlist(tray.getOrderlist());

        return ordersRepository.save(tray);
    }
    public Orders updateStatus(Orders tray){
        Orders existing = findOrderByID(tray.getId());
        existing.setOrderstatus(tray.getOrderstatus());

        return ordersRepository.save(tray);
    }

    public Orders findOrderByID(Long id){
        return ordersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Order Not Found!"));
    }
//    public Orders findOrderByUserID(Long id){
//        return orderRepository.findOrderByUserID(id)
//                .orElseThrow(() -> new UserNotFoundException("Order Not Found!"));
//    }

    public boolean doesOrderExistByID(Long id)
    {
        return ordersRepository.findById(id).isPresent();
    }

    public void deleteOrder(Long id) {
        if (doesOrderExistByID(id)) {
            ordersRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Order Not Found!");
        }
    }

}
