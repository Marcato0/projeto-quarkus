package marcato.budget.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import marcato.budget.client.CustomerClient;
import marcato.budget.client.ProductClient;
import marcato.budget.dto.BudgetDTO;
import marcato.budget.dto.CustomerDTO;
import marcato.budget.entity.BudgetEntity;
import marcato.budget.repository.BudgetRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BudgetService {

    @Inject
    BudgetRepository budgetRepository;

    @Inject
    @RestClient
    CustomerClient customerClient;

    @Inject
    @RestClient
    ProductClient productClient;


    public List<BudgetDTO> getAllBudgets(){

        List<BudgetDTO> budgets = new ArrayList<>();

        budgetRepository.findAll().stream().forEach(item->{
            budgets.add(mapEntityToDTO(item));
        });

        return budgets;
    }

    public void saveNewBudget(BudgetDTO budgetDTO){

        CustomerDTO customerDTO = customerClient.getCustomerById(budgetDTO.getCustomer_id());

        if(customerDTO.getName().equals(budgetDTO.getCustomer_name())
                && productClient.getProductById(budgetDTO.getProduct_id()) != null){
            budgetRepository.persist(mapDTOToEntity(budgetDTO));
        } else {
            throw new NotFoundException();
        }

    }

    private BudgetDTO mapEntityToDTO(BudgetEntity item) {

        BudgetDTO budgetDTO = new BudgetDTO();

        budgetDTO.setCustomer_id(item.getCustomer_id());
        budgetDTO.setCustomer_name(item.getCustomer_name());
        budgetDTO.setProduct_id(item.getProduct_id());
        budgetDTO.setProduct_name(item.getProduct_name());

        return budgetDTO;
    }

    private BudgetEntity mapDTOToEntity(BudgetDTO item) {

        BudgetEntity budget = new BudgetEntity();

        budget.setCustomer_id(item.getCustomer_id());
        budget.setCustomer_name(item.getCustomer_name());
        budget.setProduct_id(item.getProduct_id());
        budget.setProduct_name(item.getProduct_name());

        return budget;
    }




}
