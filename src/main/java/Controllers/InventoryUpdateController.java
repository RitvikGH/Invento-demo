package Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Application.DTO.InventoryUpdate;
import ports.IN.ProcessInventoryUpdateUseCase;

@RestController
@RequestMapping("/api/inventory")
public class InventoryUpdateController {
    private final ProcessInventoryUpdateUseCase processInventoryUpdateUseCase;

    public InventoryUpdateController(ProcessInventoryUpdateUseCase processInventoryUpdateUseCase) {
        this.processInventoryUpdateUseCase = processInventoryUpdateUseCase;

}

@PostMapping("/update")
public ResponseEntity<Void> handleInventoryUpdate (@RequestBody InventoryUpdate command){
    processInventoryUpdateUseCase.processUpdate(command.productID(), command.NewStockQuantity());
        return ResponseEntity.ok().build();
}
}//end of inventory update controller



