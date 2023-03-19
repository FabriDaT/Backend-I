package F4V.ClinicaDental;

import F4V.ClinicaDental.DAO.Impl.OdontologoDaoH2;
import F4V.ClinicaDental.Model.Domicilio;
import F4V.ClinicaDental.Model.Odontologo;
import F4V.ClinicaDental.Model.Paciente;
import F4V.ClinicaDental.Service.OdontologoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicaDentalApplication {

	public static void main(String[] args) {


		SpringApplication.run(ClinicaDentalApplication.class, args);

		Domicilio domicilio1 = new Domicilio(1,"av siempre viva","2134","capital","san  luis");
		Paciente paciente1 = new Paciente(1, "juancito","jimenez","38015159", LocalDate.now(),domicilio1);
		Odontologo odontologo1 = new Odontologo(1,"46241","Jose","Martinez");

		OdontologoService odonService = new OdontologoService();



	}

}
