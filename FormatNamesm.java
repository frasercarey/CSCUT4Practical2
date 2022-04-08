import java.io.*;
import java.util.*;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FormatNamesm {

	public static void main(String[] args) {

		String inputFileName = "";
		String output = "";
		String outputFile = "";
		boolean uppercase = false;

		// Input and Output filenames without all letters uppercase
		if(args.length == 2) {
			inputFileName = args[0];
			outputFile = args[1];
		}
		// Input and Output filenames with all letters uppercase
		else if(args.length == 3) {
			// Check to make sure user has specified that the letters should all be uppercase
			if(!args[0].equals("-u")) {
				System.out.println("Please use '-u' as the optional argument");
				System.exit(0);
			} else {
				inputFileName = args[1];
				outputFile = args[2];
				uppercase = true;
			}
		} else {
			System.out.println("Please enter the correct amount of arguments");
			System.exit(0);
		}

		// Open up specified input file
		try {
			File inputFile = new File(inputFileName) ;
			Scanner inFile = new Scanner(inputFile);

			// While file is still being read line by line
			while(inFile.hasNextLine()) {
				// Split up words line by line
				String[] words = inFile.nextLine().split(" ");
				// If a middle name is present
				if(words.length == 4) {
					if(!uppercase) {
						words[0] = words[0].substring(0,1).toUpperCase() + words[0].substring(1);
						words[1] = words[1].substring(0,1).toUpperCase() + words[1].substring(1) + ".";
						words[2] = words[2].substring(0,1).toUpperCase() + words[2].substring(1);
					} 
					// If letters are all uppercase
					else {
						words[0] = words[0].toUpperCase();
						words[1] = words[1].toUpperCase() + ".";
						words[2] = words[2].toUpperCase();
					}
					// Format the date
					words[3] = words[3].substring(0,2) + "/" + words[3].substring(2,4) + "/" + words[3].substring(4,8);
					output += words[0] + " " + words[1] + " " + words[2] + "\t\t" + words[3] + "\n";
				} else {
					// If no middle name is present
					if(!uppercase) {
						words[0] = words[0].substring(0,1).toUpperCase() + words[0].substring(1);
						words[1] = words[1].substring(0,1).toUpperCase() + words[1].substring(1);
					} else {
						// If letters are all uppercase
						words[0] = words[0].toUpperCase();
						words[1] = words[1].toUpperCase();
					}
					// Format the date
					words[2] = words[2].substring(0,2) + "/" + words[2].substring(2,4) + "/" + words[2].substring(4,8);
					output += words[0] + " " + words[1] + "\t\t" + words[2] + "\n";
				}	
			}
			inFile.close();
			System.out.println(output);
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage() 
			+ "not found");
		}

		// Write to output file
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 

} 