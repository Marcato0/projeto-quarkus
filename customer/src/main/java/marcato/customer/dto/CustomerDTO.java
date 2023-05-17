package marcato.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
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
