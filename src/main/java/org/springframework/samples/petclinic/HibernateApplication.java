package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.dao.BillDAO;
import org.springframework.samples.petclinic.dao.PetDAO;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.LineasdeFacturas;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	
	@Autowired 
	private BillRepository billRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	@Autowired
	private PetRepository petRepository;
	
    @Autowired
    private BillDAO billDAO;

	@Autowired
	private PetDAO petDAO;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");
		Pet p = petRepository.findById(8);
		List<Visit> visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
		
		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas visitas
		 */
		Bill b = new Bill();
		b.setIdNumber(1234567890);
		b.setMoney(1.0);
		b.setPaymentDate(new Date());
		List<Bill> listaFacturas = new ArrayList<Bill>();
		listaFacturas.add(b);
		listaFacturas = billRepository.save(listaFacturas);
		visits.get(0).setBill(b);
		visitRepository.save(visits.get(0));

		p = petRepository.findById(8);
		visits = visitRepository.findByPetId(p.getId());
		for(Visit v : visits) {
			// Imprimir todas as visitas a pet id =8
			System.out.println(v.toString());
			
	/*
	 * Criar um detalhes
	 */
		/* LineasdeFacturas  lf = new LineasdeFacturas();	
		 int id=
		 lf.getDetalhes()*/ 
		}
		
		
		
		LineasdeFacturas lf = new LineasdeFacturas();
		lf.setDetalhes("Hola Joao");
		lf.setBill(b);
		
		ArrayList<LineasdeFacturas> arrayLineas = new ArrayList<LineasdeFacturas>();
		arrayLineas.add(lf);
		b.setLineasdefactura(arrayLineas);
		billRepository.save(b);
		
		
		//buscar la bill con ID 7 y borrarla. Si se borra tambien la lineaFActura asociada lo has hecho bien
		
		
		// billRepository.delete(billRepository.findById(8));

		// Criar uma bill e persistir

		Bill b1 = new Bill();
		b1.setIdNumber(1234567);
		b1.setMoney(1.0);
		b1.setPaymentDate(new Date());
		List<Bill> listaFactura = new ArrayList<Bill>();
		billDAO.create(b1);

		for (Bill bill : billDAO.findAll()) {

			System.out.println(bill);
		}

		// Imprimir todas as visitas a pet id =8
		Pet pet = petDAO.findOne(8);
		List<Visit> visits2 = pet.getVisits();
		System.out.println("////////////////////////////////////");
		for (Visit visit : visits2) {
			System.out.println(visit);
		}
		// Imprimir as faturas associadas a si e se nao imprimir erro "Não existe"

		// Criar uma fatura e por na visita 2

		// Pesistir os dados na BD

		// Comprovar q os dados estao la
		
		
		
	}
}
