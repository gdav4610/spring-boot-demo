package mx.isban.formacionplataformadigital.cuentas.exception.model;

import java.io.Serializable;

import mx.isban.formacionplataformadigital.cuentas.exception.ErrorEnum;


/**
 * La clase ErrorBean, usada para indicar los errores que sucedieron durante la ejecucion.
 * @author Transformacion Digital 
 */
public class DefaultError implements Serializable {

    /** Variable para serializar la clase. */
    private static final long serialVersionUID = 1L;

	/** La variable code. */
    private String code;
    
    /** La variable message. */
    private String message;

    /** La variable level. */
    private String level;

    /** La variable description. */
    private String description;
    
    /** La variable more info. */
    private String moreInfo;

    /**
     * @param code Un codigo de error unico, el cual pueda ser identificado y localizado para mas detalles. Debe ser human readable, por tanto no deberia ser un codigo numerico, sino alfanumerico.
     * @param message Un mensaje de error claro: Por consideraciones de seguridad estos mensajes de error no deben contener informacion interna que pudiera implicar un riesgo a la seguridad e integridad.
     * @param level  Un nivel de error: info, warning, error.
     * @param description Una descripcion detallada.
     * @param moreInfo Un link a la documentacion del codigo de error.
     */
    public DefaultError(String code, String message, String level, 
    		String description, String moreInfo) {
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
		this.moreInfo = moreInfo;
	}

    /**
     * @param errorEnum 
     */
    public DefaultError(ErrorEnum errorEnum) {
		this.code = errorEnum.getCode();
		this.message = errorEnum.getMessage();
		this.level = errorEnum.getLevel();
		this.description = errorEnum.getDescription();
		this.moreInfo = errorEnum.getMoreInfo();
	}


    /**
     * Obtiene el valor de la variable code.
     *
     * @return el code
     */
    public String getCode() {
        return code;
    }

    /**
     * Coloca el valor de code.
     *
     * @param code es el nuevo valor de code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtiene el valor de la variable message.
     *
     * @return el message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Coloca el valor de message.
     *
     * @param message es el nuevo valor de message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtiene el valor de la variable nivel.
     *
     * @return el level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Coloca el valor de level.
     *
     * @param level es el nuevo valor del nivel
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Obtiene el valor de la variable description.
     *
     * @return el description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Coloca el valor de description.
     *
     * @param description es el nuevo valor de description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el valor de la variable more info.
     *
     * @return el more info
     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * Coloca el valor de more info.
     *
     * @param moreInfo es el nuevo valor de more info
     */
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

}
