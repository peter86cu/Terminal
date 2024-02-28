package com.ayalait.terminal.util;

public class Constants {
	public static final String CLAVE="1234";
	public static final long TIEMPO_VIDA = 860_500_000; // 1 dia
	public static final String ENCABEZADO = "Authorization";
	public static final String PREFIJO_TOKEN = "Bearer ";
	public static final String PREFIJO_AUTH = "Basic Auth ";
	
	public static final String RESULTADO_OK="Datos guardados correctamente.";
	public static final String RESULTADO_NOK="A ocurrido un error guardando los datos. Intente de nuevo.";
	public static final String CAJA_OK="Día abierto correctamente.";
	public static final String CAJA_NOK="La caja ya esta abierta. Contacte a un administrador.";
	
	public static final String DELETE_USUARIO_OK="Usuario eliminado correctamente.";
	
	
	
	/*public static void main(String[] args) {
		Roles rol = new Roles();
		rol.setIdRol("123");
		rol.setDescripcion("Prueba");
		
		List<Modulos> modulos = new ArrayList<Modulos>();
		
		Modulos mod= new Modulos();
		mod.setId(12);
		mod.setEstado(1);
		mod.setModulo("modulo1");
		modulos.add(mod);
		
		rol.setModulos(modulos);
		RequestAddRoles roles= new RequestAddRoles();
		roles.setRoles(rol);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
		try {
			json = ow.writeValueAsString(roles);
			RequestAddRoles request = new Gson().fromJson(json, RequestAddRoles.class);
			System.out.println(json);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}*/
}
