package marcato.budget.dto;

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
public class CustomerDTO {

    @NotBlank
    @Size(max=80)
    private String name;

    @NotBlank
    @Size(max=50)
    private String email;

    @NotBlank
    @Size(max=11)
    private String phone;
}
