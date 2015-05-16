package com.thecookiezen.one2manyexample.boundary;

import com.thecookiezen.one2manyexample.unidirectional.sort.control.GameService;
import com.thecookiezen.one2manyexample.unidirectional.sort.entity.Game;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/entities")
public class GameResource {

    @Inject
    GameService service;

    @POST
    public void createNewTestEntity(@PathParam("name") String name) {
        service.saveNewEntity(name);
    }

    @GET
    public List<Game> getAll() {
        return service.getAll();
    }


}
