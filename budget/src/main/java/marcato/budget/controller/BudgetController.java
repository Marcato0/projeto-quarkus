package marcato.budget.controller;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import marcato.budget.dto.BudgetDTO;
import marcato.budget.service.BudgetService;


import java.util.List;

@Path("/api/budgets")
public class BudgetController {

    @Inject
    private BudgetService budgetService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BudgetDTO> getAllBudgets(){
        return budgetService.getAllBudgets();
    }

    @POST
    @Transactional
    public Response saveNewBudget(BudgetDTO budget){

        try {
            budgetService.saveNewBudget(budget);
            return Response.ok().build();
        }

        catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    }



}
