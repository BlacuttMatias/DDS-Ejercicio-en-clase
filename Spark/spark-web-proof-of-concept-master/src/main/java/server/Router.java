package server;

import dominio.Conversor;
import spark.Spark;

public class Router {

	static Router _instance;
	
	private Router() {
		
	}
	
	public static  Router instance() {
		if(_instance == null) {
			_instance = new Router();
		}
		return _instance;
	}
	/*
	public void configurar() {
		Spark.get("/conversor/millas", (req, res) -> {
			return new ConversorController().convertirAMillas(req, res);
		});*/
	public void configurar() {
		Spark.staticFileLocation("/public");
		ConversorController controller = new ConversorController();
		//Spark.get("/conversor/millas", controller::convertirAMillas);
		Spark.get("/", controller::convertirAMillas);
		Spark.get("/otra", controller::otra);
}
}
/*
Spark.post("/guardarropas/:id/prendas", prendaController::crear))

#PrendaController
>>crear(rew,res){
	req.params("id")
	Categoria categoria = Cstegoria.valueOf(req.body().get("categoria"))
	-
	-
	withTransaction(()->{
		Prenda p = new Prenda(...)
		//en.persist(p)
		 //repoPrendas.agregar(p)
		 guardarropa.agregar(p)		 
	})
}

<input name="_" type = "hidden" value={{categoria}}/>
	

*/