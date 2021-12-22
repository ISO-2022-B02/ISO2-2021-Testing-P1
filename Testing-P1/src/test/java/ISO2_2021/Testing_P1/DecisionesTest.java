package ISO2_2021.Testing_P1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value= Parameterized.class)
public class DecisionesTest {

	

	@Parameters
	public static Iterable<Object[]> decisiones(){
		return Arrays.asList(new Object[][] {
			{true,false,false,true,true,-5,5,false,false,false,false,"Se puede ir a esquiar"},
			{true,true,false,true,true,-1,2,false,false,false,false,"No puedes salir de casa"},
			{true,false,false,true,true,1,5,false,false,false,false,"Se puede ir a hacer senderismo"},
			{true,false,false,true,true,-3,5,true,true,false,false,"Quedate en casa"},
			{true,false,false,true,true,12,5,true,false,false,true,"Se puede ir a hacer senderismo"},
			{true,false,false,true,true,30,5,true,false,false,true,"Ir de canias"},
			{true,false,false,true,true,20,40,false,false,false,false,"Turismo al aire libre"},
			{true,false,false,true,true,20,70,false,false,false,false,null},
			{true,false,false,true,true,31,70,false,false,false,false,"Ir a la playa o a la piscina"},
			{true,false,false,true,true,40,70,false,false,false,false,null}
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
	
	
	public DecisionesTest(boolean sana, boolean sintomas, boolean contacto_infectados, 
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
