package game_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**<b>EXTENSION</b>:
 * new class for handling score and text file(score board) to store scores
 */
public class ScoreHandler {
	private int[] record;
	private int rounds; 
	private FileWriter board;
	private FileReader readboard;
	private BufferedWriter writescore;
	private BufferedReader readscore;
	
//***********************************************************CONTROLLER*********************************************************************
	/**Construct handler for recording score permanently and to read score in text file
	 * @param filepath : text file directory string 
	 */
	public ScoreHandler ( String filepath) {
		setRecord(new int[5]);
		setRounds(0);
		try {
			setBoard(new FileWriter(filepath,true));
			setWritescore(new BufferedWriter(getBoard()));
			setReadboard(new FileReader(filepath));
			setReadscore(new BufferedReader(getReadboard()));
			}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

//************************************************************************MODEL***************************************************
	public int[] getRecord() {
		return record;
	}
	
	public void setRecord(int[] record) {
		this.record = record;
	}
	
	public int getRounds() {
		return rounds;
	}
	
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	public void addRounds(int rounds) {
		this.rounds += rounds;
	}

	public FileWriter getBoard() {
		return board;
	}

	public void setBoard(FileWriter board) {
		this.board = board;
	}

	public FileReader getReadboard() {
		return readboard;
	}

	public void setReadboard(FileReader readboard) {
		this.readboard = readboard;
	}

	public BufferedWriter getWritescore() {
		return writescore;
	}

	public void setWritescore(BufferedWriter writescore) {
		this.writescore = writescore;
	}

	public BufferedReader getReadscore() {
		return readscore;
	}

	public void setReadscore(BufferedReader readscore) {
		this.readscore = readscore;
	}
}
