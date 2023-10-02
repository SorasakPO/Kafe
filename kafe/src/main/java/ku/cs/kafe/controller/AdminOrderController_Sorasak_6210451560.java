package ku.cs.kafe.controller;


import ku.cs.kafe.service.OrderService_Sorasak_6210451560;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.UUID;


@Controller
@RequestMapping("/admin/orders")
public class AdminOrderController_Sorasak_6210451560 {


    @Autowired
    private OrderService_Sorasak_6210451560 orderService;


    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-all_Sorasak_6210451560";
    }

    @GetMapping("/{orderId}")
    public String getAllOrders(@PathVariable UUID orderId, Model model) {
        model.addAttribute("order", orderService.getById(orderId));
        return "order-view_Sorasak_6210451560";
    }


    @PostMapping("/{orderId}/finish")
    public String finishOrder(@PathVariable UUID orderId, Model model) {
        orderService.finishOrder(orderId);
        return "redirect:/admin/orders";
    }

}
