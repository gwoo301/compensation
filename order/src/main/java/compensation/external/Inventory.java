package compensation.external;

import java.util.Date;
import lombok.Data;

@Data
public class Inventory {

    private Long id;
    private Long stock;
    private String orderId;
}
