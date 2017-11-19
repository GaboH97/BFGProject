package test;

import static spark.Spark.*;
import com.google.gson.Gson;
import models.dao.Manager;
import persistence.JsonUtil;

/**
 * This class handles incoming requests from a server using Spark Framework
 * using GET and POST methods for querying and adding data from the DB which
 * response is in JSON format.
 * 
 * @author Gabriel Huertas, Juan Molina, Cesar Cardozo
 */
public class SparkManager {

    public static void main(String[] args) {
        //Set port and IP address in which Spark server will be listening
        ipAddress("localhost");
        port(8181);
        
        //Create a manager and spark manager instance, plus set spark manager
        //response to JSON
        Manager mn = new Manager();
        SparkManager main = new SparkManager();
        main.corsFilter();
        
        get("/students", (req, res) -> mn.getAllStudents(), JsonUtil.json());
        get("/trainners", (req, res) -> mn.getAllTrainners(), JsonUtil.json());
        get("/movements", (req, res) -> mn.getAllMovements(), JsonUtil.json());
        post("/student", (req, res) -> mn.createStudent(req.queryParams("id"),
                req.queryParams("name"),
                req.queryParams("phone"),
                req.queryParams("email"),
                req.queryParams("img")), JsonUtil.json());
        post("/trainner", (req, res) -> mn.createTrainner(req.queryParams("id"),
                req.queryParams("name"),
                req.queryParams("phone"),
                req.queryParams("email"),
                req.queryParams("img"),
                req.queryParams("programs")), JsonUtil.json());
        post("/movement", (req, res) -> mn.createMovement(req.queryParams("id"),
                req.queryParams("tipo"),
                req.queryParams("date"),
                req.queryParams("value"),
                req.queryParams("description")), JsonUtil.json());
    }

    /**
     * Metodo encargado de adicionar los CorsFilters al servicio
     */
    public void corsFilter() {
        // Filtro para convertir la salida a formato JSON
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            String mensajeOk = "{'id':10,'cantidad':0}";
            return new Gson().toJson(mensajeOk).toString();
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        after((request, response) -> response.type("application/json"));
    }
}