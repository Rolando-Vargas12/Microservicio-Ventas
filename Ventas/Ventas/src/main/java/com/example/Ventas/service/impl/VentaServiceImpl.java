package com.example.Ventas.service.impl;

import com.example.Ventas.entity.Venta;
import com.example.Ventas.repository.VentaRepository;
import com.example.Ventas.service.VentaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VentaServiceImpl implements VentaService {

    private final VentaRepository repository;

    public VentaServiceImpl(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public VentaService.VentaResponse registrar(VentaService.VentaRequest request) {
        if (request.getTotal() != null && request.getTotal() < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo");
        }
        Venta v = new Venta();
        v.setCliente(request.getCliente());
        v.setTotal(request.getTotal());
        v.setFecha(LocalDateTime.now());
        Venta saved = repository.save(v);
        return toResponse(saved);
    }

    @Override
    public List<VentaService.VentaResponse> listarTodas() {
        return repository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    private VentaService.VentaResponse toResponse(Venta v) {
        return new VentaService.VentaResponse(v.getId(), v.getCliente(), v.getTotal(), v.getFecha());
    }
}