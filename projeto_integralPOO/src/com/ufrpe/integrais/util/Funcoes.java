package com.ufrpe.integrais.util;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcoes {
	private static Pattern pattern;
	private static Matcher matcher;
 
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static Rectangle centroDaTela(int largura, int altura) {
		Rectangle d = new Rectangle();
		d.x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - largura / 2; 
		d.y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - altura / 2;
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
	                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	            }
	            else {
	                hexString.append(Integer.toHexString(0xFF & hash[i]));
	            }
	        }

	        return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
    }
}
