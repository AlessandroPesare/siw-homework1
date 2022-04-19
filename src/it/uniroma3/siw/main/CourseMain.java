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
� memorizzato il nome, la data di inizio e la durata in mesi. A ogni corso sono iscritti pi� allievi. Gli allievi sono
dipendenti di societ� esterne: per ogni allievo sono di interesse il nome e il cognome, la data e il luogo di
nascita, il numero di matricola, l�indirizzo di posta elettronica. Ogni allievo � dipendente di una ed una sola
societ� e pu� essere iscritto ad uno o pi� corsi. Per ogni azienda sono di interesse la ragione sociale, l�indirizzo
della sede (via, numero civico, comune, cap, provincia), il numero di telefono. Ogni corso � tenuto da uno ed
un solo docente; ogni docente pu� tenere pi� corsi. I docenti sono consulenti: per ogni docente sono di
interesse il nome e il cognome, la data e il luogo di nascita, il numero di partita iva.
Ipotizzando che i casi d�uso prevedano che l�associazione tra allievo e societ� di consulenza sia
monodirezionale (da allievo a societ�), che l�associazione tra docente e corso sia bidirezionale, e che
l�associazione tra corso e allievo sia bidirezionale, scrivere il codice delle entit� JPA Corso, Docente, Societa,
Allievo specificando e motivando con ipotesi opportune (in massimo 2 righe di commento Java) politiche di
fetch e di cascade per le associazioni.
 */
/*--------------------------*/
/* STRATEGIA DI FETCH
 * Il default delle strategie di fetch � stato modificato solo nella
 * classe Course, in particolare � ragionevole che nell'accedere alle informazioni di un corso vengano caricate
 * anche le informazioni degli studenti iscritti a tale corso.
 */
/*--------------------------*/
/* STRATEGIA DI CASCADE
 * Poich� un corso � costituito da studenti o "contiene" studenti, dunque
 * c'� una relazione di composizione tra queste due classi ha senso avere
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
