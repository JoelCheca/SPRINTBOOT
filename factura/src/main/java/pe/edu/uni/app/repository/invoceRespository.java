package pe.edu.uni.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.model.invoceModel;

@Repository

public interface invoceRespository extends JpaRepository<invoceModel, Integer> {

	//@Query(nativeQuery = true, value = "select * from fat_prefactura_agrupado_201212 where numero_otorgante =:numero_otorgante")
	List<invoceModel> findBynumeroOtorgante(String numeroOtorgante);
	
	@Query(nativeQuery = true, value ="select id,numero_Otorgante,cve_netsuite,consultas,precio,cve_descuento,cve_region,fec_creacion from invoice_beans where (convert(VARCHAR(20),fec_creacion)) between :fecha1  and  :fecha2 ")
	 List<invoceModel>findByfecha(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
	
}
