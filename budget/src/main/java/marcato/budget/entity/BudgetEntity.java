package marcato.budget.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "budget")
public class BudgetEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;

    @Column(nullable = false, length = 80)
    private String customer_name;

    private Long product_id;

    @Column(nullable = false, length = 80)
    private String product_name;
}
