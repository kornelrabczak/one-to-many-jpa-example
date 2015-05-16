package com.thecookiezen.one2manyexample.boundary;

import com.thecookiezen.one2manyexample.unidirectional.order.control.GameOrderService;
import com.thecookiezen.one2manyexample.unidirectional.order.entity.GameOrder;
import com.thecookiezen.one2manyexample.unidirectional.sort.control.GameSortService;
import com.thecookiezen.one2manyexample.unidirectional.sort.entity.GameSort;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/entities")
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
    @Path("/sort")
    public List<GameSort> getSortAll() {
        return gameSortService.getAll();
    }

    @GET
    @Path("/order")
    public List<GameOrder> getOrderAll() {
        return gameOrderService.getAll();
    }


}
