package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Course;

/*
 * Sistemi Informativi su Web 2021/2022
Homework 1 (Persistenza: JPA)
Stiamo scrivendo il codice per il sistema informativo di un ente che eroga corsi di formazione. Per ogni corso
è memorizzato il nome, la data di inizio e la durata in mesi. A ogni corso sono iscritti più allievi. Gli allievi sono
dipendenti di società esterne: per ogni allievo sono di interesse il nome e il cognome, la data e il luogo di
nascita, il numero di matricola, l’indirizzo di posta elettronica. Ogni allievo è dipendente di una ed una sola
società e può essere iscritto ad uno o più corsi. Per ogni azienda sono di interesse la ragione sociale, l’indirizzo
della sede (via, numero civico, comune, cap, provincia), il numero di telefono. Ogni corso è tenuto da uno ed
un solo docente; ogni docente può tenere più corsi. I docenti sono consulenti: per ogni docente sono di
interesse il nome e il cognome, la data e il luogo di nascita, il numero di partita iva.
Ipotizzando che i casi d’uso prevedano che l’associazione tra allievo e società di consulenza sia
monodirezionale (da allievo a società), che l’associazione tra docente e corso sia bidirezionale, e che
l’associazione tra corso e allievo sia bidirezionale, scrivere il codice delle entità JPA Corso, Docente, Societa,
Allievo specificando e motivando con ipotesi opportune (in massimo 2 righe di commento Java) politiche di
fetch e di cascade per le associazioni.
 */
/*--------------------------*/
/* STRATEGIA DI FETCH
 * Il default delle strategie di fetch è stato modificato solo nella
 * classe Course, in particolare è ragionevole che nell'accedere alle informazioni di un corso vengano caricate
 * anche le informazioni degli studenti iscritti a tale corso.
 */
/*--------------------------*/
/* STRATEGIA DI CASCADE
 * Poiché un corso è costituito da studenti o "contiene" studenti, dunque
 * c'è una relazione di composizione tra queste due classi ha senso avere
 * la propagazione per l'operazione di persist(non per quella delete)
 */
public class CourseMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("course-unit");
		EntityManager em = emf.createEntityManager();
		Course course = new Course();
		

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(course);
		tx.commit();

		em.close();
		emf.close();
	}
}
