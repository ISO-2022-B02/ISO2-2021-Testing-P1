package ISO2_2021.Testing_P1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value= Parameterized.class)
public class EachUseTest {
	
	@Parameters
	public static Iterable<Object[]> eachuse(){
		return Arrays.asList(new Object[][] {
			{true,	false,	false,	true,	true,	-5	,5	,true,	true,	true	,true,"Quedate en casa"},
			{true,	false,	false,	true	,true	,10,	-15,	true	,false,	false,	false,"Se puede ir a hacer senderismo"},
			{true,	false,	false	,true,	true,	20,	40,	false,	false	,false	,false,"Turismo al aire libre"},
			{true,	true,	false,	false	,false,	27,	70,	false,	false,	false,	false,"No puedes salir de casa"},
			{true,	true,	false,	true	,true,	32,	0,	true,	true	,false	,true,"No puedes salir de casa"},
			{true,	true,	false,	true	,false,	40,	15,	true,	false	,false,	false,"No puedes salir de casa"},
			{true,	false,	true,	false	,true,	0	,60,	false,	true,	true,	true,"No puedes salir de casa"},
			{true,	false,	true,	false	,false,	15	,-1,	false,	false,	true,	false,"No puedes salir de casa"},
			{true,	false,	true,	true	,true,	25,	1,	true,	true,	true,	true,"No puedes salir de casa"},
			{true,	false,	false,	true	,true,	30,	14,	false,	false,	false,	false,"Ir de canias"},
			{true,	false,	false,	true,	true,	35,	16	,false,	false,	false,	true, "Ir a la playa o a la piscina"},
			{true,	false,	false,	false,	false,	-1,	59,	false,	false,	false,	false,"No puedes salir de casa"},
			{false,	true	,true,	true,	true	,1,	61,	true,	true,	true,	true,"No puedes salir de casa"},
			{false	,true	,true,	true,	false,	14,	120,	true,	false,	true,	false,"No puedes salir de casa"},
			{false	,true,	true	,false,	true,	16,	-15,	false,	true,	true,	true,"No puedes salir de casa"},
			{false,	true,	false,	false,	false,	24,	5,	false,	false,	false,	false,"No puedes salir de casa"},
			{false	,true,	false,	true,	true,	26,	40,	true,	true,	false,	true,"No puedes salir de casa"},
			{false,	true	,false,	true,	false,	29,	70	,true,	false,	false,	false,"No puedes salir de casa"},
			{false,	false	,true	,false,	true,	31,	0,	false,	true,	true,	true,"No puedes salir de casa"},
			{false,	false	,true,	false,	false,	24,	15,	false,	false,	true,	false,"No puedes salir de casa"},
			{false,	false	,true,	true	,true,	36,	60	,true,	true,	true,	true,"No puedes salir de casa"},
			{true	,false	,false,	true	,true,	-100,	1,	false,	false,	false,	false,"Se puede ir a esquiar"},
			{false	,false	,false	,false,	true	,200,	-1,	false,	true,	false,	true,"No puedes salir de casa"}
		
		});
	}
	
	
	//condiciones de la persona
	
	boolean sana; 
	boolean sintomas;
	boolean contacto_infectados;
	boolean pasado_covid;
	boolean vacunacion;
	
	//condiciones meteorológicas
	
	int temperatura;
	int humedad;
	boolean nublado;
	boolean precipitaciones;
	
	//condiciones restricciones 
	boolean supera_aforo;
	boolean restricciones_confinamiento;
	
	//valor esperado
	
	String esperado;
	
	
	public EachUseTest(boolean sana, boolean sintomas, boolean contacto_infectados, 
			boolean pasado_covid, boolean vacunacion,int temperatura, int humedad, 
			boolean nublado, boolean precipitaciones, boolean supera_aforo,
			boolean restricciones_confinamiento,String esperado) {
		
		this.sana = sana;
		this.sintomas = sintomas;
		this.contacto_infectados = contacto_infectados;
		this.pasado_covid = pasado_covid;
		this.vacunacion = vacunacion;
		this.temperatura = temperatura;
		this.humedad = humedad;
		this.nublado = nublado;
		this.precipitaciones = precipitaciones;
		this.supera_aforo = supera_aforo;
		this.restricciones_confinamiento = restricciones_confinamiento;
		this.esperado=esperado;
	
	}


	@Test
	public void testing() {
		Caso caso = new Caso();
		String result= caso.recomendacion(sana, sintomas, contacto_infectados, pasado_covid, vacunacion, temperatura, humedad, precipitaciones, supera_aforo, nublado, restricciones_confinamiento);
		assertEquals(esperado, result);
		
	}

}
