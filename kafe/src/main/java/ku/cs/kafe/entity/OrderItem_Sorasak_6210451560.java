package ku.cs.kafe.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class OrderItem_Sorasak_6210451560 {


    @EmbeddedId
    private OrderItemKey_Sorasak_6210451560 id;


    private int quantity;


    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private PurchaseOrder_Sorasak_6210451560 purchaseOrder;


    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name = "menu_id")
    private Menu_Sorasak_6210451560 menu;

    public double getSubtotal() {
        return menu.getPrice() * quantity;
    }

}
