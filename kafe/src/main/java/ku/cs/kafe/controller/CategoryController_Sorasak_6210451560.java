package ku.cs.kafe.controller;


import ku.cs.kafe.model.CategoryRequest_Sorasak_6210451560;
import ku.cs.kafe.service.CategoryService_Sorasak_6210451560;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/categories")
public class CategoryController_Sorasak_6210451560 {


    @Autowired
    private CategoryService_Sorasak_6210451560 categoryService;

    @GetMapping("/add")
    public String getCategoryForm(Model model) {
        return "category-add_Sorasak_6210451560";
    }


    @PostMapping("/add")
    public String createCategory(@ModelAttribute CategoryRequest_Sorasak_6210451560 request,
                                 Model model) {
        categoryService.createCategory(request);
        return "redirect:/menus";
    }
}
