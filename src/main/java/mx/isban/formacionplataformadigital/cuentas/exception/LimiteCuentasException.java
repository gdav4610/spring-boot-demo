package mx.isban.formacionplataformadigital.cuentas.exception;

/**
 * Clase del tipo exception de negocio
 * @author Transformacion Digital
 */
public class LimiteCuentasException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    

    /**
     * Constructor
     * @param message Mensaje de error
     */
    public LimiteCuentasException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message Mensaje de error
     * @param causa Causa completa del error
     */
    public LimiteCuentasException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     */
    public LimiteCuentasException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     * @param causa Causa completa del error
     */
    public LimiteCuentasException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}