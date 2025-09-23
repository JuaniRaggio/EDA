package com.primeros_parciales.gordo.primerc_2024;

import java.util.Arrays;

/**
 * @author dpenaloza
 *
 */
public class IndexWithDuplicates  {

	final static private int chunksize= 5;

	private int[] indexedData;
	private int cantElems;
	
	
	public IndexWithDuplicates() {
		indexedData= new int[chunksize];
		cantElems= 0;
	}

	public void initialize(int[] unsortedElements) {

		if (unsortedElements == null)
			throw new RuntimeException("Problem: null data collection");

		indexedData= unsortedElements;
		Arrays.sort(indexedData);
		cantElems= indexedData.length;
	}


	public int[] getIndexedData() {
		return indexedData;
	}

	public void print() {
		System.out.print("[");
		for (int i : indexedData)
			System.out.print(i + " ") ;
		System.out.println("]");
		
	}

	public void merge(IndexWithDuplicates other) {
		if (other == null || other.cantElems == 0) {
			return; // Nada que fusionar
		}

		// Crear nuevo arreglo con capacidad para todos los elementos
		int[] newArray = new int[this.cantElems + other.cantElems];

		// Fusionar los dos arreglos ordenados usando algoritmo merge de merge sort
		int i = 0; // Índice para this.indexedData
		int j = 0; // Índice para other.indexedData
		int k = 0; // Índice para newArray

		// Mientras haya elementos en ambos arreglos
		while (i < this.cantElems && j < other.cantElems) {
			if (this.indexedData[i] <= other.indexedData[j]) {
				newArray[k] = this.indexedData[i];
				i++;
			} else {
				newArray[k] = other.indexedData[j];
				j++;
			}
			k++;
		}

		// Copiar elementos restantes de this.indexedData
		while (i < this.cantElems) {
			newArray[k] = this.indexedData[i];
			i++;
			k++;
		}

		// Copiar elementos restantes de other.indexedData
		while (j < other.cantElems) {
			newArray[k] = other.indexedData[j];
			j++;
			k++;
		}

		// Actualizar el estado del objeto receptor
		this.indexedData = newArray;
		this.cantElems = this.cantElems + other.cantElems;
	}

}

