package com.ufrpe.integrais.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;

import com.ufrpe.integrais.dados.entidades.Entidade;

public abstract class Repositorio<E extends Entidade> {
	
	protected LinkedList<E> lista;
	
	private String nomeRepositorio;

	public Repositorio(String nome) {
		this.nomeRepositorio = nome;
		this.lista = this.lerDoArquivo();
	}

	@SuppressWarnings("unchecked")
	private LinkedList<E> lerDoArquivo() {
		LinkedList<E> repositorioLocal = null;

		File file = new File(this.nomeRepositorio + ".dat");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {

			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();

			repositorioLocal =  (LinkedList<E>) object;
		} catch (Exception exception) {
			repositorioLocal = new LinkedList<>();
		} finally {
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					/* Silent exception */
				}
			}
		}

		return repositorioLocal;
	}

	private void salvarNoArquivo() {
		File file = new File(this.nomeRepositorio + ".dat");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(lista);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (Exception e) {
					/* Silent exception */
				}
			}
		}
	}

	public LinkedList<E> getLista() {
		return this.lista;
	}

	public void cadastrar(E entidade) {
		if (lista.size() > 0) {
			entidade.setId(lista.get(lista.size() - 1).getId() + 1);
		} else {
			entidade.setId(1);
		}
		
		entidade.setDataCriacao(new Date());
			
		lista.add(entidade);
		salvarNoArquivo();
	}

	public void remover(E entidade) {
		lista.remove(entidade);
		salvarNoArquivo();
	}

	public E procurar(int id) {
		E aux = null;

		for (E entidade: lista) {
			if (entidade.getId() == id) {
				aux = entidade;
				break;
			}
		}

		return aux;
	}

	public E atualizar(E entidade) {
		E aux = null;
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == entidade.getId()) {
				lista.set(i, entidade);				
				aux = lista.get(i);
				
				break;
			}
		}
		
		salvarNoArquivo();
		
		return aux;
	}
}
