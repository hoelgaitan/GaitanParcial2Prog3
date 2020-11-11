package ar.edu.undec.plantas.controller.dto;

public class Response {
    private int estado;
    private String message;
    private Object data;

    public Response() {
        this.estado = 0;
        this.message = "";
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
