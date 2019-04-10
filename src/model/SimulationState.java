package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import immobile.StructureParts;

public class SimulationState {
	
	private int step;
	private Cell[][] grid;
	
	//Constructor
	
	public SimulationState(int step, int lineNb, int columnNb, StructureParts structureParts) {
		super();
		this.step = step;
		this.grid = new Cell[lineNb][columnNb];
		this.grid = structureParts.getStructGrid();
	}
	
	
	/**
	 * Generation of every element's position and parameter at this step in the simulation. Filling up every grid's cell.
	 * 
	 * @param previousState
	 * @return true if a termination case presents itself
	 */
	public boolean generate(SimulationState previousState) {
		//Updating grid 
		return true; //true return statement only here for testing
	}
	
	@Override
	public String toString() {
		String table = "";
		for(int i=0; i<grid.length-1; i++) {
			String line = "[";
			for(int j=0; j<grid[0].length-1; j++) {
				if (grid[i][j] != null) {
					line += grid[i][j].getContainedRoad()+" ";
				}
				else {
					line += grid[i][j]+" ";
				}
			}
			line += "]\n";
			table += line;
		}
		return table;
	}
	
	
	/**
	 * Write raw content of every cell to file
	 */
	public void writeToFile(String fileName) {
		Path File = Paths.get(fileName);
		
		if (!Files.exists(File)) {
			try {
				Files.createFile(File);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		try (BufferedWriter writer = Files.newBufferedWriter(File, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) { // buffer en ecriture (ecrase l’existant), encodage UTF8
			
					writer.write(this.toString());
					writer.close();
			} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * Getters
	 */
	public Cell getGridValue(int i, int j) {
		return grid[i][j];
	}
	
}