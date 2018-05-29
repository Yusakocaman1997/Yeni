package com.medipol.yazilimaraclari.SpringBootOrnek;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTServisiOrnek {

	private List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
	private List<Ogrenci> ogrenci;

	public RESTServisiOrnek() {
		
	}
	/**
	 * Ogrenci ekler ve aynı zamanda ekledigi ogrencilerin
	 * listesini sunar.
	 * 
	 * @param ogrenciler
	 */
	
	public RESTServisiOrnek(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}
	
	class Ogrenci {
		String ad, soyad;
		public String getAd() { return ad;}
		public String getSoyad() { return soyad;}
	}

	/** http://localhost:8085/ogrenci/listele */
	@RequestMapping("/ogrenci/listele")
	public List<Ogrenci> ogrenciListele() {
		return ogrenciler;
	}

	/** http://localhost:8085/ogrenci/olustur?ad=Mehmet&soyad=Kara4  */
	@RequestMapping(value="/ogrenci/olustur",method = RequestMethod.GET)
	public synchronized Ogrenci ogrenciOlustur(String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ad, soyad);
	}
	
	@RequestMapping(value="/ogrenci/olustur/post",method = RequestMethod.POST)
	public synchronized Ogrenci ogrenciOlusturPost(String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ad, soyad);
	}
	
	protected Ogrenci ogrenciEkle(List<Ogrenci> liste, String ad, String soyad) {
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.ad=ad;
		ogrenci.soyad=soyad;
		liste.add(ogrenci);
		return ogrenci;
	}
	public void silogrenci(int ad) {
		ogrenci = null;
		ogrenci.remove(ad);
	}
	/** http://localhost:8085/ogrenci/sil?ad=Mehmet&soyad=Kara4  */
	@RequestMapping(value="/ogrenci/sil",method = RequestMethod.GET)
	public synchronized Ogrenci silogrenci(String ad, String soyad) {
		return silogrenci(ad, soyad);
	}
	@RequestMapping(value="/ogrenci/sil/post",method = RequestMethod.POST)
	public synchronized Ogrenci silogrenciPost(String ad, String soyad) {
		return silogrenci(ad, soyad);
	}
}
