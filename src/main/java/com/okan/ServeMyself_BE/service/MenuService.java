package com.okan.ServeMyself_BE.service;

import com.okan.ServeMyself_BE.exception.UserNotFoundException;
import com.okan.ServeMyself_BE.model.Menu;
import com.okan.ServeMyself_BE.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class MenuService {


    private final MenuRepository menuRepository;

    public Menu create(Menu item)
    {
        return menuRepository.save(item);
    }


    public Menu update(Menu item)
    {
        Menu existing = findItemByID(item.getId());
        existing.setName(item.getName());
        existing.setDescription(item.getDescription());
        existing.setCategory(item.getCategory());
        existing.setPrice(item.getPrice());

        return menuRepository.save(item);
    }

    public Menu findItemByID(Long id)
    {
        return menuRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Item Not Found!"));
    }

    public Menu findItemByName(String name)
    {
        return menuRepository.findItemByName(name)
                .orElseThrow(() -> new UserNotFoundException("Item Not Found!"));
    }


    public List<Menu> getMenu()
    {
        return menuRepository.findAll();
    }


    public boolean doesItemExistByID(Long id)
    {
        return menuRepository.findById(id).isPresent();
    }

    public void deleteItem(Long id) {
        if (doesItemExistByID(id)) {
            menuRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Item Not Found!");
        }
    }

}

