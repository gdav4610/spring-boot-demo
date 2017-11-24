package mx.isban.formacionplataformadigital.cuentas.exception;

/**
 * The Enum ErrorEnum.
 * @author Transformacion Digital 
 */
public enum ErrorEnum {

	CTAS_GENERICO("CTAS.000", "Error de consulta", "Error de consulta de cuentas", "Error", ""),
	
	CTAS_NO_ENCONTRADA("CTAS.001", "Cuenta no encontrada", "La cuenta no fue encontrada", "Error", ""),

	CTAS_LIMITE_ALCANZADO("CTAS.002", "Limite de cuentas", "El limite de cuentas fue alcanzado", "Error", "");

	
    private final String code;
    
    private final String message;

	private final String description;

    private final String level;

    private final String moreInfo;

    
    private ErrorEnum(final String code, final String message, 
    		final String description, final String level, final String moreInfo ) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.level = level;
        this.moreInfo = moreInfo;
    }


	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public String getDescription() {
		return description;
	}


	public String getLevel() {
		return level;
	}


	public String getMoreInfo() {
		return moreInfo;
	}



}
