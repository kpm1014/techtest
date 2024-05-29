package com.sintad.techtest.dto;

public class EntidadDTO {
    private Long idEntidad;
    private Long idTipoDocumento;
    private Long idTipoContribuyente;
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private Boolean estado;
    
    public Long getIdEntidad() {
        return idEntidad;
    }
    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }
    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }
    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    public Long getIdTipoContribuyente() {
        return idTipoContribuyente;
    }
    public void setIdTipoContribuyente(Long idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }
    public String getNroDocumento() {
        return nroDocumento;
    }
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getNombreComercial() {
        return nombreComercial;
    }
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
