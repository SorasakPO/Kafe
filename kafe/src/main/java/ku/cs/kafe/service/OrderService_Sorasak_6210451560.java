package ku.cs.kafe.service;

import ku.cs.kafe.common.Status_Sorasak_6210451560;
import ku.cs.kafe.entity.Menu_Sorasak_6210451560;
import ku.cs.kafe.entity.OrderItem_Sorasak_6210451560;
import ku.cs.kafe.entity.OrderItemKey_Sorasak_6210451560;
import ku.cs.kafe.entity.PurchaseOrder_Sorasak_6210451560;
import ku.cs.kafe.model.AddCartRequest_Sorasak_6210451560;
import ku.cs.kafe.repository.MenuRepository_Sorasak_6210451560;
import ku.cs.kafe.repository.OrderItemRepository_Sorasak_6210451560;
import ku.cs.kafe.repository.PurchaseOrderRepository_Sorasak_6210451560;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class OrderService_Sorasak_6210451560 {


    @Autowired
    private PurchaseOrderRepository_Sorasak_6210451560 orderRepository;


    @Autowired
    private OrderItemRepository_Sorasak_6210451560 itemRepository;


    @Autowired
    private MenuRepository_Sorasak_6210451560 menuRepository;


    private UUID currentOrderId;


    public PurchaseOrder_Sorasak_6210451560 getCurrentOrder() {
        if (currentOrderId == null)
            createNewOrder();
        return orderRepository.findById(currentOrderId).get();
    }


    public void submitOrder() {
        PurchaseOrder_Sorasak_6210451560 currentOrder =
                orderRepository.findById(currentOrderId).get();
        currentOrder.setTimestamp(LocalDateTime.now());
        currentOrder.setStatus(Status_Sorasak_6210451560.CONFIRM);
        orderRepository.save(currentOrder);
        currentOrderId = null;
    }


    public void createNewOrder() {
        PurchaseOrder_Sorasak_6210451560 newOrder = new PurchaseOrder_Sorasak_6210451560();
        newOrder.setStatus(Status_Sorasak_6210451560.ORDER);
        PurchaseOrder_Sorasak_6210451560 record = orderRepository.save(newOrder);
        currentOrderId = record.getId();
    }


    public void order(UUID menuId, AddCartRequest_Sorasak_6210451560 request) {
        if (currentOrderId == null)
            createNewOrder();


        PurchaseOrder_Sorasak_6210451560 currentOrder =
                orderRepository.findById(currentOrderId).get();
        Menu_Sorasak_6210451560 menu = menuRepository.findById(menuId).get();


        OrderItem_Sorasak_6210451560 item = new OrderItem_Sorasak_6210451560();
        item.setId(new OrderItemKey_Sorasak_6210451560(currentOrderId, menuId));
        item.setPurchaseOrder(currentOrder);
        item.setMenu(menu);
        item.setQuantity(request.getQuantity());
        itemRepository.save(item);
    }

    public List<PurchaseOrder_Sorasak_6210451560> getAllOrders() {
        return orderRepository.findAll();
    }

    public PurchaseOrder_Sorasak_6210451560 getById(UUID orderId) {
        return orderRepository.findById(orderId).get();
    }

    public void finishOrder(UUID orderId) {
        PurchaseOrder_Sorasak_6210451560 record = orderRepository.findById(orderId).get();
        record.setStatus(Status_Sorasak_6210451560.FINISH);
        orderRepository.save(record);
    }
}
