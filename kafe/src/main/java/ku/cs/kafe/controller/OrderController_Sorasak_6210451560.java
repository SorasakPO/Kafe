package ku.cs.kafe.controller;


import ku.cs.kafe.model.AddCartRequest_Sorasak_6210451560;
import ku.cs.kafe.service.OrderService_Sorasak_6210451560;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@Controller
@RequestMapping("/orders")
public class OrderController_Sorasak_6210451560 {


    @Autowired
    private OrderService_Sorasak_6210451560 orderService;

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cart", orderService.getCurrentOrder());
        return "cart_Sorasak_6210451560";
    }


    @PostMapping
    public String submitOrder(Model model) {
        orderService.submitOrder();
        model.addAttribute("confirmOrder", true);
        return "home";
    }


    @PostMapping("/{menuId}")
    public String order(@PathVariable UUID menuId,
                        @ModelAttribute AddCartRequest_Sorasak_6210451560 request, Model model){
        orderService.order(menuId, request);
        return "redirect:/menus";
    }
}
