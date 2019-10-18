package server;

import java.util.HashMap;

import dominio.Conversor;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class ConversorController {
	public String otra(Request req, Response res) {
		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		
		viewModel.put("otra", "Otra cosa. :)");

		ModelAndView modelAndView = new ModelAndView(viewModel, "otra.hbs");

		return new HandlebarsTemplateEngine().render(modelAndView);
	}

	public String convertirAMillas(Request req, Response res) {
		String km = req.queryParams("km");
		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		Boolean hayKilometros = km!=null && !km.isEmpty();
		Double unasMillas = hayKilometros?calcularMillas(km):0.0;
		
		viewModel.put("km", km);
		viewModel.put("millas", unasMillas.toString());

		ModelAndView modelAndView = new ModelAndView(viewModel, "conversor.hbs");

		return new HandlebarsTemplateEngine().render(modelAndView);

		// return unasMillas.toString();

	}

	private Double calcularMillas(String km) {
		Double kms = Double.parseDouble(km);
		Double unasMillas = new Conversor().convertirAMillas(kms);
		return unasMillas;
	}
}
