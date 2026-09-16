package Application.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Application.DTO.SupplierDetailsDto;
import Models.Supplier;
import ports.IN.ManageSuppliersUseCase;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final ManageSuppliersUseCase manageSuppliersUseCase;

    public SupplierController(ManageSuppliersUseCase manageSuppliersUseCase) {
        this.manageSuppliersUseCase = manageSuppliersUseCase;
    }

public record CreateSupplierRequest(String name, String email) {}

    @PostMapping
    public ResponseEntity<SupplierDetailsDto> registerSupplier(@RequestBody CreateSupplierRequest request) {
        Supplier supplier = manageSuppliersUseCase.registerSupplier(request.name(), request.email());
        
        SupplierDetailsDto responseDto = new SupplierDetailsDto(
            supplier.getSupplierID(), 
            supplier.getSupplierName(), 
            supplier.getSupplierEmail()
        );
        
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{supplierId}/link-product/{productId}")
    public ResponseEntity<Void> linkProduct(@PathVariable String supplierId, @PathVariable String productId) {
        manageSuppliersUseCase.linkSupplierToProduct(supplierId, productId);
        return ResponseEntity.ok().build();
    }
}