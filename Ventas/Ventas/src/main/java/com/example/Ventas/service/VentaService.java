package com.example.Ventas.service;

import java.time.LocalDateTime;
import java.util.List;

public interface VentaService {
    VentaResponse registrar(VentaRequest request);
    List<VentaResponse> listarTodas();

    class VentaRequest {
        private String cliente;
        private Double total;

        public VentaRequest() {}

        public VentaRequest(String cliente, Double total) {
            this.cliente = cliente;
            this.total = total;
        }

        public String getCliente() { return cliente; }
        public void setCliente(String cliente) { this.cliente = cliente; }
        public Double getTotal() { return total; }
        public void setTotal(Double total) { this.total = total; }
    }

    class VentaResponse {
        private Long id;
        private String cliente;
        private Double total;
        private LocalDateTime fecha;

        public VentaResponse() {}

        public VentaResponse(Long id, String cliente, Double total, LocalDateTime fecha) {
            this.id = id;
            this.cliente = cliente;
            this.total = total;
            this.fecha = fecha;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getCliente() { return cliente; }
        public void setCliente(String cliente) { this.cliente = cliente; }
        public Double getTotal() { return total; }
        public void setTotal(Double total) { this.total = total; }
        public LocalDateTime getFecha() { return fecha; }
        public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    }
}