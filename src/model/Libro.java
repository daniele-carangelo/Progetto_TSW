package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class Libro {
	private String isbn;
	private String numberisbn;
	private String titolo;
	private String descrizione;
	private int prezzo;
	private String tipo;
	private int anno_pubblicazione;
	private int numero_pagine;
	private int numero_disponibili;
	private String autore;
	private String path;
	private List<Categoria> categorie;
	private String sdescrizione;
	private String ssDescrizione;
	private int quantitaCarrello;
	private String categoriestring;
	private int acquisti=0;

	public int getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(int acquisti) {
		this.acquisti = acquisti;
	}

	public List<Categoria> getCategorie(){
		return categorie;
	}

	public void setCategorie(List<Categoria> c){
		categorie=c;
		categoriestring = "";
		for(int i=0;i<c.size();i++){
			categoriestring = categoriestring + c.get(i).getNome();
			if (i != c.size() -1)
			categoriestring = categoriestring + ",";
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public String getCategoriestring() {
		return categoriestring;
	}

	public String getNumberisbn() {
		return numberisbn;
	}

	public void setIsbn(String isbn) {
		numberisbn = isbn.replace("-", "");
		if(isbn.contains("-")== false){
			String a = isbn.substring(0,3);
			String b = isbn.substring(3);
			this.isbn = a+"-"+ b;
		}else{
			this.isbn = isbn;
		}
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String getSdescrizione() {
		return sdescrizione;
	}

	public String getSSDescrizione() {
		return ssDescrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		if(descrizione.length() > 250) {
			sdescrizione = descrizione.substring(0,250) + "...";
			ssDescrizione = descrizione.substring(0,130) + "...";
		} else if(descrizione.length() > 130) {
			sdescrizione = descrizione;
			ssDescrizione = descrizione.substring(0,130) + "...";;
		}else {
			sdescrizione = descrizione;
			ssDescrizione = descrizione;
		}
	}

	public String getPrezzoEuroNo(){return String.valueOf(((float)prezzo/100));}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public String getprezzoEuro() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		return nf.format(((float)prezzo/100));
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}

	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}

	public int getNumero_pagine() {
		return numero_pagine;
	}

	public void setNumero_pagine(int numero_pagine) {
		this.numero_pagine = numero_pagine;
	}

	public int getNumero_disponibili() {
		return numero_disponibili;
	}

	public void setNumero_disponibili(int numero_disponibili) {
		this.numero_disponibili = numero_disponibili;
	}

	public void setQuantitaCarrello(int quantitaCarrello) {
		this.quantitaCarrello = quantitaCarrello;
	}

	public int getQuantitaCarrello() {
		return quantitaCarrello;
	}

	@Override
	public String toString() {
		return "Libro{" +
				"isbn=" + isbn +
				", titolo='" + titolo + '\'' +
				", descrizione='" + descrizione + '\'' +
				", prezzo=" + prezzo +
				", tipo='" + tipo + '\'' +
				", anno_pubblicazione=" + anno_pubblicazione +
				", numero_pagine=" + numero_pagine +
				", numero_disponibili=" + numero_disponibili +
				", descrizione='" + descrizione + '\'' +
				", autore='" + autore + '\'' +
				", path='" + path + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Libro)) return false;
		Libro libro = (Libro) o;
		return  getPrezzo() == libro.getPrezzo() &&
				getAnno_pubblicazione() == libro.getAnno_pubblicazione() &&
				getNumero_pagine() == libro.getNumero_pagine() &&
				getNumero_disponibili() == libro.getNumero_disponibili() &&
				getTitolo().equals(libro.getTitolo()) &&
				getDescrizione().equals(libro.getDescrizione()) &&
				getTipo().equals(libro.getTipo()) &&
				getDescrizione().equals(libro.getDescrizione()) &&
				getAutore().equals(libro.getAutore()) &&
				getPath().equals(libro.getPath());
	}
}
