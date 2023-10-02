package ku.cs.kafe.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import ku.cs.kafe.common.Status_Sorasak_6210451560;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Entity
public class PurchaseOrder_Sorasak_6210451560 {
    @Id
    @GeneratedValue
    private UUID id;


    private LocalDateTime timestamp;
    private Status_Sorasak_6210451560 status;


    @OneToMany(mappedBy = "purchaseOrder")
    private List<OrderItem_Sorasak_6210451560> items = new ArrayList<>();

    public double getTotal() {
        double total = 0;
        for (OrderItem_Sorasak_6210451560 item : items)
            total += item.getSubtotal();
        return total;
    }

}
