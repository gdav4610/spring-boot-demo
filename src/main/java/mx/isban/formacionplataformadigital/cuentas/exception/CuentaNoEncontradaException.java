package mx.isban.formacionplataformadigital.cuentas.exception;

/**
 * Clase del tipo exception de negocio
 * @author Transformacion Digital
 */
public class CuentaNoEncontradaException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    


    /**
     * Constructor
     * @param message Mensaje de error
     */
    public CuentaNoEncontradaException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message Mensaje de error
     * @param causa Causa completa del error
     */
    public CuentaNoEncontradaException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     */
    public CuentaNoEncontradaException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     * @param causa Causa completa del error
     */
    public CuentaNoEncontradaException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}