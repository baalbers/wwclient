package org.gvsig.sos.lib.impl.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/**
 * This class contains an implementation of both input and output stream for reading/writing 
 * files that contain observations and an index at the end of the file. The file written 
 * has the following structure, in order inside the file:
 * 1. The position of the index in a the file.  
 * 2. A list of observations.
 * 3. The index of the observations. This is used for keeping the observations 
 *    in a certain order. The order is the order in which the observations is written 
 *    to the index.
 * @author lrodriguez
 *
 */
class RandomAccessStream {
	
	/**
	 * Class implementing a random access policy for writing elements on a random access file.
	 * @author lrodriguez
	 *
	 */
	static class RAOutputStream extends OutputStream {
		RandomAccessFile file;

		public RAOutputStream(RandomAccessFile fa) throws IOException {
			this.file = fa;
			writeIndexPosition(0L, false);
		}

		/**
		 * Writes or updates the index position in the output. As mentioned before 
		 * this index position is written at the very beginning of the file. 
		 * @param indexPosition the position of the index in the file.
		 * @param restorePosition true of the current file position needs to 
		 * 		  be restored after writing the index position.
		 * @throws IOException raised by the RandomAccessFile
		 */
		public void writeIndexPosition(long indexPosition,
				boolean restorePosition) throws IOException {
			long restorablePosition = file.getFilePointer();
			try {
				seek(0L);
				file.writeLong(indexPosition);
			} finally {
				if (restorePosition) {
					seek(restorablePosition);
				}
			}
		}
		
		/**
		 * Moves the position in the random access file.
		 * @param position
		 * @throws IOException
		 */
		private void seek(long position) throws IOException{
			file.seek(position);
		}

		/**
		 * Writes the current file pointer position in the space reserved for the index 
		 * position at the beginning of the file. 
		 * @throws IOException raised by the write operation in the random access file.
		 */
		public void writeFilePointer() throws IOException {
			long indexPosition = file.getFilePointer();
			writeIndexPosition(indexPosition, true);
		}

		/**
		 * Gives the current file pointer (i.e. the position in the file)
		 * @return the current position in the file.
		 * @throws IOException raised by the operation getFilePointer on 
		 *         a random access file.
		 */
		public long getFilePointer() throws IOException {
			return file.getFilePointer();
		}
		
		@Override
		public void write(int b) throws IOException {
			file.write(b);
		}

		@Override
		public void close() throws IOException {
			file.close();
			super.close();
		}
		
		/**
		 * Writes a string in the stream.
		 * @param s the string to be written.
		 * @throws IOException raised by the write operation in the random access file.
		 */
		
		public void writeString(String s) throws IOException {
			file.writeUTF(s);
		}
		
		public void writeLong(long lon) throws IOException{
			file.writeLong(lon);
		}

	}
	
	/**
	 * Class implementing an input stream providing functions for 
	 * reading the index position. 
	 * @author lrodriguez
	 *
	 */
	static class RAInputStream extends InputStream {
		RandomAccessFile file;

		/**
		 * Builds the input stream based on the specified random access file.
		 * @param fa the random access file.
		 * @throws IOException 
		 */
		public RAInputStream(RandomAccessFile fa){
			this.file = fa;
		}

		/**
		 * Retrieves the index position stored in the first bytes of the random access file.
		 * @param restorePosition true if the previous file position should be restored.
		 * @return the index position in the file.
		 * @throws IOException 
		 */
		public long readIndexPosition(boolean restorePosition) throws IOException {
			long position = file.getFilePointer();
			long indexPosition = -1L;
			try {
                seek(0L);
				indexPosition = file.readLong();
			} finally {
				if (restorePosition) {
					seek(position);
				}
			}
			return indexPosition;
		}
		
		/**
		 * Moves the file pointer to a certain position specified by that parameter.
		 * @param position the position to move to.
		 * @throws IOException 
		 */
		public void seek(long position) throws IOException{
			file.seek(position);
		}

		/**
		 * Closes the stream.
		 */
		@Override
		public void close() throws IOException {
			file.close();
			super.close();
		}

		@Override
		public int read() throws IOException {
			return file.read();
		}

		/**
		 * Reads a string from the stream. 
		 * @return the read string.
		 * @throws IOException a exception if something happens during the read operation 
		 *         on the file.
		 */
		public String readString() throws IOException{
			return file.readUTF();
		}
		
		public long readLong() throws IOException{
			return file.readLong();
		}
		
	}

}