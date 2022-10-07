package models;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class NoHeaderObjectOutputStream extends ObjectOutputStream{

	public NoHeaderObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	public NoHeaderObjectOutputStream() throws IOException {
		super();
	}

	protected void writeStreamHeader() throws IOException{
        // No hacer nada.
    }
}
