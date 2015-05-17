package com.thecookiezen.one2manyexample.boundary;

import com.thecookiezen.one2manyexample.unidirectional.order.control.GameOrderService;
import com.thecookiezen.one2manyexample.unidirectional.order.entity.GameOrder;
import com.thecookiezen.one2manyexample.unidirectional.sort.control.GameSortService;
import com.thecookiezen.one2manyexample.unidirectional.sort.entity.GameSort;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/entities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {

    @Inject
    GameOrderService gameOrderService;

    @Inject
    GameSortService gameSortService;

    @POST
    @Path("/order")
    public void createNewOrder(GameOrder game) {
        gameOrderService.saveNewEntity(game);
    }

    @POST
    @Path("/sort")
    public void createNewSort(GameSort game) {
        gameSortService.saveNewEntity(game);
    }

    @GET
    @Path("/order")
    public List<GameOrder> getOrderAll() {
        return gameOrderService.getAll();
    }

    @GET
    @Path("/sort")
    public List<GameSort> getSortAll() {
        return gameSortService.getAll();
    }


}
