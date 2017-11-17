package models;

import static spark.Spark.*;
import com.google.gson.Gson;
import models.Logic.Manager;
import persistence.JsonUtil;
import spark.Request;
import spark.Response;

/**
 *
 * @author Cesar Cardozo
 */
public class SparkManager {

    public static void main(String[] args) {
        ipAddress("localhost");
        port(8181);

        Manager mn = new Manager();
        SparkManager main = new SparkManager();
        main.corsFilter();
        get("/ejemplo", (req, res) -> "Ejemplo");
        get("/users", (req, res) -> mn.getAllStudents(), JsonUtil.json());
        get("/trainners", (req, res) -> mn.getAllTrainners(), JsonUtil.json());
        get("/movements", (req, res) -> mn.getAllMovements(), JsonUtil.json());
        post("/user", (req, res) -> mn.createStudent(req.queryParams("id"),
                req.queryParams("name"),
                req.queryParams("phone"),
                req.queryParams("email"),
                req.queryParams("img")), JsonUtil.json());
        post("/trainner", (req, res) -> {
            System.out.println("body; "+req.scheme());
            return mn.createTrainner(req.queryParams("id"),
                req.queryParams("name"),
                req.queryParams("phone"),
                req.queryParams("email"),
                req.queryParams("img"),
                req.queryParams("programs"));}, JsonUtil.json());
        post("/transaction", (req, res) -> mn.createMovement(req.queryParams("id"),
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

    /**
     * Ejemplo de Spark
     */
//    public Persona ejemplo(Request req, Response res) {
//        Persona persona = new Persona();
//        persona.setApellido("Hernandez");
//        persona.setNombre("Edwin");
//        return persona;
//    }
}
