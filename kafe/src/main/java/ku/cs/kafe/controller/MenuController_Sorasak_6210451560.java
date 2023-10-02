package ku.cs.kafe.controller;


import ku.cs.kafe.entity.Menu_Sorasak_6210451560;
import ku.cs.kafe.model.MenuRequest_Sorasak_6210451560;
import ku.cs.kafe.service.CategoryService_Sorasak_6210451560;
import ku.cs.kafe.service.MenuService_Sorasak_6210451560;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/menus")
public class MenuController_Sorasak_6210451560 {


    @Autowired
    private MenuService_Sorasak_6210451560 menuService;


    @Autowired
    private CategoryService_Sorasak_6210451560 categoryService;


    @GetMapping
    public String getAllMenus(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("menus", menuService.getAllMenus());
        return "menu-all_Sorasak_6210451560";
    }

    @GetMapping("/{id}")
    public String getOneMenu(@PathVariable UUID id, Model model) {
        Menu_Sorasak_6210451560 menu = menuService.getOneById(id);
        model.addAttribute("menu", menu);
        return "menu-view_Sorasak_6210451560";
    }



    @GetMapping("/add")
    public String getMenuForm(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "menu-add_Sorasak_6210451560";
    }


    @PostMapping("/add")
    public String createMenu(@ModelAttribute MenuRequest_Sorasak_6210451560 menu, Model model) {
        menuService.createMenu(menu);
        return "redirect:/menus";
    }
}
