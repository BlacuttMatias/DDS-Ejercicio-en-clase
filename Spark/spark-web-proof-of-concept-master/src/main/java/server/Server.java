package server;

import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		//Router.instance().configurar();
		Spark.get("/cookie", (req,res)->{
			return req.cookie("builder");
			
		});
		Spark.get("/cookie/:id", (req,res)->{
			String id = req.params("id");
			res.cookie("builder",  id);
			return "ASDF";
		});
		
		
		Spark.get("/session/:nombre", (req,res)->{
			req.session(true); //inicia una nueva session
			req.session().attribute("prenda", new Prenda(req.params("nombre")));
			return "set session";
		});
		
		Spark.get("/session/show", (req,res)->{
			return req.session().attribute("prenda");
		});
		
		Spark.init();
	}

}
