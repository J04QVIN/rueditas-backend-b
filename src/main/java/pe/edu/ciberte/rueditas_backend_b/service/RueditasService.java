package pe.edu.ciberte.rueditas_backend_b.service;

import pe.edu.ciberte.rueditas_backend_b.dto.RueditasRequest;

import java.io.IOException;

public interface RueditasService {

    String[] buscarVehiculo(RueditasRequest rueditasRequest) throws IOException;

}
