package marcato.product.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;


@Jacksonized
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    @Size(max=80)
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    @Size(max=80)
    private String culture;

    @NotBlank
    @Column(nullable = false)
    private String area_size;
}
