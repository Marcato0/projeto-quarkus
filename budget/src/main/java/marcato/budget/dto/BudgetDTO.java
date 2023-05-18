package marcato.budget.dto;

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
public class BudgetDTO {


    private Long customer_id;

    @NotBlank
    @Size(max=80)
    private String customer_name;

    private Long product_id;

    @NotBlank
    @Size(max=80)
    private String product_name;
}
