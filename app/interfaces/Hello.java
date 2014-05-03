package interfaces;

public class Hello implements IHello
{

	@Override
	public String getHello()
	{
		return "Hola a todos :D desde Guice!!";
	}

}
