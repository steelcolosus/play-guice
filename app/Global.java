import interfaces.Hello;
import interfaces.IHello;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings
{
	private Injector injector;

	@Override
	public void onStart(Application application)
	{
		injector = Guice.createInjector(new AbstractModule()
		{
			@Override
			protected void configure()
			{
				bind(IHello.class).to(Hello.class);
			}
		});
	}

	@Override
	public <T> T getControllerInstance(Class<T> aClass) throws Exception
	{
		return injector.getInstance(aClass);
	}
}
