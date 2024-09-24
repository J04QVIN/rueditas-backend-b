package pe.edu.ciberte.rueditas_backend_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.ciberte.rueditas_backend_b.dto.RueditasRequest;
import pe.edu.ciberte.rueditas_backend_b.dto.RueditasResponse;
import pe.edu.ciberte.rueditas_backend_b.service.RueditasService;

@RestController
@RequestMapping("/vehiculos")
public class RueditasControlador {

    @Autowired
    RueditasService rueditasService;

    @PostMapping
    public RueditasResponse buscarVehiculo(@RequestBody RueditasRequest rueditasRequest) {
        try {
            String[] datosAutos = rueditasService.buscarVehiculo(rueditasRequest);
            if (datosAutos == null) {
                return new RueditasResponse("01", "Error: Auto no encontrado", "", "",
                        "", "", "");
            }
            return new RueditasResponse("00", "", datosAutos[0], datosAutos[1],
                    datosAutos[2], datosAutos[3], datosAutos[4]);
        } catch (Exception e) {
            return new RueditasResponse("99", "Error: Ocurrió un problema", "",
                    "", "", "", "");
        }
    }

}
