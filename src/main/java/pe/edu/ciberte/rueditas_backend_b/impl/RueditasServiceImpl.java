package pe.edu.ciberte.rueditas_backend_b.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.ciberte.rueditas_backend_b.dto.RueditasRequest;
import pe.edu.ciberte.rueditas_backend_b.service.RueditasService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class RueditasServiceImpl implements RueditasService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String[] buscarVehiculo(RueditasRequest rueditasRequest) throws IOException {
        String[] datosAutos = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (rueditasRequest.placa().equals(datos[1])) {
                    datosAutos = new String[5];
                    datosAutos[0] = datos[2];
                    datosAutos[1] = datos[3];
                    datosAutos[2] = datos[4];
                    datosAutos[3] = datos[5];
                    datosAutos[4] = datos[6];
                }
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
        return datosAutos;
    }

}
