package com.ufrpe.integrais.util;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class Funcoes {

	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static Rectangle centroDaTela(int largura, int altura) {
		Rectangle d = new Rectangle();
		d.x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - largura
				/ 2;
		d.y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - altura
				/ 2;
		d.width = largura;
		d.height = altura;

		return d;
	}

	public static boolean validarEmail(String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);

		matcher = pattern.matcher(hex);
		return matcher.matches();
	}

	public static String criptografar(String texto) {
		if (texto == null || texto.length() == 0) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		}

		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance("MD5");

			digester.update(texto.getBytes());
			byte[] hash = digester.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String formatarDataExtenso(Date data) {
		DateFormat dfmt = new SimpleDateFormat("EEEE, d MMMM yyyy '�s' H:m:s");  
		return dfmt.format(data);
	}
	
	public static String tempoPassado(Date inicio){
		return tempoPassado(inicio, new Date());
	}
	
	public static String tempoPassado(Date inicio, Date fim){
		 
		//milliseconds
		long diferenca = fim.getTime() - inicio.getTime();
 
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
 
		long elapsedDays = diferenca / daysInMilli;
		diferenca = diferenca % daysInMilli;
 
		long elapsedHours = diferenca / hoursInMilli;
		diferenca = diferenca % hoursInMilli;
 
		long elapsedMinutes = diferenca / minutesInMilli;
		diferenca = diferenca % minutesInMilli;
 
		long elapsedSeconds = diferenca / secondsInMilli;
 
		if (elapsedDays > 0) {
			return elapsedDays + " dias atr�s";
		} else if (elapsedHours > 0) {
			return elapsedHours + " horas atr�s";
		} else if (elapsedMinutes > 0) {
			return elapsedMinutes + " minutos atr�s";
		} else {
			return elapsedSeconds + " segundos atr�s";
		}
	}

	public static boolean campoPreenchido(Map<JTextField, Boolean> mapa,
			int limiteCampos) {

		boolean resultado = true;

		if (mapa.size() >= limiteCampos) {
			for (JTextField v : mapa.keySet()) {
				if (!mapa.get(v)) {
					resultado = false;
				}
			}

		} else {
			resultado = false;
		}

		return resultado;
	}

}
