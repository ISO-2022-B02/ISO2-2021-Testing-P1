package ISO2_2021.Testing_P1;

public class Caso {
	
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
	
	//constructor
	public Caso() {
	}

	public  String recomendacion(boolean sana,boolean sintomas,boolean contacto_infectados,
			boolean pasado_covid,boolean vacunacion,int temperatura,double humedad,
			boolean precipitaciones,boolean supera_aforo,boolean nublado,
			boolean restricciones_confinamiento) {
		
		if (sana & !sintomas & !contacto_infectados & pasado_covid & vacunacion) {
			
			if (temperatura<0 & humedad < 15) {
				
				if (precipitaciones) return "Quedate en casa";
				
				else if (!precipitaciones&!supera_aforo) return "Se puede ir a esquiar";
				
				
			}else if (temperatura>=0&temperatura<=15 & !precipitaciones&!supera_aforo) {
				
				return "Se puede ir a hacer senderismo";
				
			}else if(temperatura>=15&temperatura<=25&!precipitaciones&!nublado &
					humedad<=60 & !restricciones_confinamiento) {
				
				return "Turismo al aire libre";
				
			}else if (temperatura>=25&temperatura<=35&!precipitaciones&!supera_aforo) {
				
				if (temperatura>30) return "Ir a la playa o a la piscina";
				
				return "Ir de canias";
				
			}
		}
		else {
			return "No puedes salir de casa";
		}
		return null;
	}
	
}
