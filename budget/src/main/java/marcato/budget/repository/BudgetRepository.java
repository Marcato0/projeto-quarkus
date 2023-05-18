package marcato.budget.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import marcato.budget.entity.BudgetEntity;
import marcato.budget.service.BudgetService;


@ApplicationScoped
public class BudgetRepository implements PanacheRepository<BudgetEntity> {


}
