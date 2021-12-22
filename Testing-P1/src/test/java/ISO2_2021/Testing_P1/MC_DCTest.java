package ISO2_2021.Testing_P1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class MC_DCTest {
	
	@Parameters
	public static Iterable<Object[]> MC_DC(){
		return Arrays.asList(new Object[][] {
			{true,true,true,true,true,-5,5,false,false,false,false,"No puedes salir de casa"},
			{true,true,true,true,false,-5,5,false,false,false,false,"No puedes salir de casa"},
			{true,true,true,false,true,-1,40,false,false,false,false,"No puedes salir de casa"},
			{true,true,false,true,true,1,5,false,false,true,true,"No puedes salir de casa"},
			{true,false,true,true,true,-1,5,false,false,false,false,"No puedes salir de casa"},
			{false,true,true,true,true,1,16,false,true,false,true,"No puedes salir de casa"},
			{true,false,false,true,true,-5,5,false,false,false,false,"Se puede ir a esquiar"},
			{true,false,false,true,true,-1,40,false,false,false,false,null},
			{true,false,false,true,true,1,5,false,false,false,false,"Se puede ir a hacer senderismo"},
			{true,false,false,true,true,-1,40,false,true,false,false,null},
			{true,false,false,true,true,-5,5,true,true,true,true,"Quedate en casa"},
			{true,false,false,true,true,-1,14,false,true,false,false,"Quedate en casa"},
			{false,false,true,false,false,24,15,false,false,true,false,"No puedes salir de casa"},
			{true,false,false,true,true,14,14,false,true,true,false,null},
			{true,false,false,true,true,14,40,false,true,false,false,null},
			{true,false,false,true,true,1,14,false,false,true,false,null},
			{true,false,false,true,true,-1,14,false,true,true,false,"Quedate en casa"},
			{true,false,false,true,true,16,40,true,true,false,true,null},
			{true,false,false,true,true,16,40,true,true,false,false,null},
			{true,false,false,true,true,16,70,true,true,false,true,null},
			{true,false,false,true,true,16,40,true,false,false,true,null},
			{true,false,false,true,true,14,40,true,true,false,true,null},
			{true,false,false,true,true,26,40,false,false,false,false,"Ir de canias"},
			{true,false,false,true,true,26,40,false,false,true,false,null},
			{true,false,false,true,true,26,40,false,true,false,false,null},
			{true,false,false,true,true,24,40,false,false,false,false,"Turismo al aire libre"},
			{true,false,false,true,true,31,40,false,false,false,false,"Ir a la playa o a la piscina"}
			});
	}
	
	//condiciones de la persona
	
	boolean sana; 
	boolean sintomas;
	boolean contacto_infectados;
	boolean pasado_covid;
	boolean vacunacion;
	
	//condiciones meteorologicas
	
	int temperatura;
	int humedad;
	boolean nublado;
	boolean precipitaciones;
	
	//condiciones restricciones 
	boolean supera_aforo;
	boolean restricciones_confinamiento;
	
	//valor esperado
	
	String esperado;
	
	public MC_DCTest(boolean sana, boolean sintomas, boolean contacto_infectados, 
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
