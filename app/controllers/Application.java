package controllers;

import com.google.inject.Inject;

import interfaces.IHello;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller
{

	private IHello sayHello;

	@Inject
	public Application(IHello sayHello)
	{
		this.sayHello = sayHello;
	}

	public Result index()
	{
		String message = sayHello.getHello();
		play.Logger.info("index message: " + message);
		return ok(views.html.index.render(message));
	}

}
