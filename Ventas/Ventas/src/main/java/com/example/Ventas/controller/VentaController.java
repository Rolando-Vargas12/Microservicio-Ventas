package com.example.Ventas.controller;

import com.example.Ventas.service.VentaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")

public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody VentaService.VentaRequest request) {
        try {
            VentaService.VentaResponse resp = ventaService.registrar(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public List<VentaService.VentaResponse> listar() {
        return ventaService.listarTodas();
    }
}