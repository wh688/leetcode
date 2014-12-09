package ArrayStructure;

public class ArrayStructures {

	private int[] theArray = new int[50]; // Creates an array with 50 indexes
	
	private int arraySize = 10; // Elements in theArray
	
	// Fills the Array with random values
	
	public void generateRandomArray(){			
		for(int i = 0; i < arraySize; i++){				
			// Random number 10 through 19
			// Math.random() return random number from 0.0 to 1.0				
			theArray[i] = (int)(Math.random()*10)+10;				
		}			
	}	
	
	// Prints the Array on the screen in a grid
	
	public void printArray(){			
		System.out.println("----------");			
		for(int i = 0; i < arraySize; i++){				
			System.out.print("| " + i + " | ");				
			System.out.println(theArray[i] + " |");				
			System.out.println("----------");				
		}			
	}
	
	// Gets value at provided index
		
	public int getValueAtIndex(int index){
		if(index < arraySize) return theArray[index];			
		return 0;			
	}
	
	// Returns true or false if a value is in the Array
	public boolean doesArrayContainThisValue(int searchValue){			
		boolean valueInArray = false;			
		for(int i = 0; i < arraySize; i++){				
			if(theArray[i] == searchValue){				
				valueInArray = true;					
			}			
		}		
		return valueInArray;			
	}

	public void deleteIndex(int index){		
		if(index < arraySize){			
			// Overwrite the value for the supplied index
			// and then keep overwriting every index that follows
			// until you get to the last index in the array			
			for(int i = index; i < (arraySize - 1); i++){				
				theArray[i] = theArray[i+1];
			}			
			arraySize--;			
		}		
	}
	
	public void insertValue(int value){		
		if(arraySize < 50){			
			theArray[arraySize] = value;			
			arraySize++;			
		}		
	}
	
	// Linear Search : Every index must be looked at
	
	public String linearSearchForValue(int value){		
		boolean valueInArray = false;			
		String indexsWithValue = "";
		System.out.print("The Value was Found in the Following Indexes: ");
		for(int i = 0; i < arraySize; i++){				
			if(theArray[i] == value) {
				valueInArray = true;
				System.out.print(i + " ");indexsWithValue+= i + " ";
			}
		}
		if(!valueInArray){
			indexsWithValue = "None";
			System.out.print(indexsWithValue);
		}
		System.out.println();
		return indexsWithValue;
	}
	
	public void printHorzArray(int i, int j){		
		for(int n = 0; n < 51; n++) 
			System.out.print("-");		
		System.out.println();		
		for(int n = 0; n < arraySize; n++){			
			System.out.print("| " + n + "  ");			
		}		
		System.out.println("|");		
		for(int n = 0; n < 51; n++) 
			System.out.print("-");		
		System.out.println();		
		for(int n = 0; n < arraySize; n++){			
			System.out.print("| " + theArray[n] + " ");			
		}		
		System.out.println("|");		
		for(int n = 0; n < 51; n++)
			System.out.print("-");		
		System.out.println();		
		// END OF FIRST PART
		// ADDED FOR BUBBLE SORT		
		if(j != -1){		
			// ADD THE +2 TO FIX SPACING			
			for(int k = 0; k < ((j * 5) + 2); k++)
				System.out.print(" ");			
			System.out.print(j);			
		}			
		// THEN ADD THIS CODE		
		if(i != -1){			
			// ADD THE -1 TO FIX SPACING			
			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");			
			System.out.print(i);			
		}		
		System.out.println();		
	}
	
	// This bubble sort will sort everything from smallest to largest
		
	public void bubbleSort(){
		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted		
		for(int i = arraySize - 1; i > 1; i--){				
			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped
			for(int j = 0; j < i; j++){				
				// To change sort to Descending change to <					
				if(theArray[j] > theArray[j + 1]){						
					swapValues(j, j+1);						
					printHorzArray(i, j);						
				}					
			}				
		}			
	}
	
	public void swapValues(int indexOne, int indexTwo){			
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;		
	}
	
	// The Binary Search is quicker than the linear search
	// because all the values are sorted. Because everything
	// is sorted once you get to a number larger than what
	// you are looking for you can stop the search. Also
	// you be able to start searching from the middle 
	// which speeds the search. It also works best when 
	// there are no duplicates

	public void binarySearchForValue(int value){			
		int lowIndex = 0;
		int highIndex = arraySize - 1;		
		while(lowIndex <= highIndex){					
			int middleIndex = (highIndex + lowIndex) / 2;			
			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;					
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;					
			else {						
				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);						
				lowIndex = highIndex + 1;		
				return;
			}					
			printHorzArray(middleIndex, -1);				
		}	
		System.out.println("NOT FOUND");
	}	

	// Selection sort search for the smallest number in the array
	// saves it in the minimum spot and then repeats searching
	// through the entire array each time
			
	public void selectionSort(){				
		for(int x = 0; x < arraySize; x++){
			int minimum = x;					  
			for(int y = x; y < arraySize; y++){					  
				// To change direction of sort just change 
				// this from > to <						  
				if(theArray[minimum] > theArray[y]){
					minimum = y;
				}
			}			  
			swapValues(x, minimum);			  
			printHorzArray(x, -1);
		}			
	}
	
	// The Insertion Sort is normally the best of 
	// the elementary sorts. Unlike the other sorts that
	// had a group sorted at any given time, groups are
	// only partially sorted here.
			
	public void insertionSort(){				
		for (int i = 1; i < arraySize; i++){
			int j = i;
			int toInsert = theArray[i];
			while ((j > 0) && (theArray[j-1] > toInsert)){
				theArray[j] = theArray[j-1];
				j--;						  
				printHorzArray(i, j);						  
			}
			theArray[j] = toInsert;			
			printHorzArray(i, j);			
			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");				  
		}
	}
	
	public void shellSort() {
		int inner, outer, temp;
		int interval = 1;
		while (interval <= arraySize / 3){
			// Define an interval sequence
			interval = interval * 3 + 1;
		}
		// Keep looping until the interval is 1
		// Then this becomes an insertion sort
		while (interval > 0) {
			// Continue incrementing outer until the end of the array is reached
			for (outer = interval; outer < arraySize; outer++) {
				// Store the value of the array in temp unless it has to be
				// copied to a space occupied by a bigger number closer to the
				// beginning of the array
				temp = theArray[outer];
				System.out.println("Copy " + theArray[outer] + " into temp");
				// inner is assigned the value of the highest index to check
				// against all values the proceed it. Along the way if a
				// number is greater than temp it will be moved up in the array
				inner = outer;
				System.out.println("Checking if " + theArray[inner - interval]
						+ " in index " + (inner - interval)
						+ " is bigger than " + temp);
				// While there is a number bigger than temp move it further
				// up in the array
				while (inner > interval - 1 && theArray[inner - interval] >= temp) {
					System.out.println("In While Checking if "
							+ theArray[inner - interval] + " in index "
							+ (inner - interval) + " is bigger than " + temp);
					printHorzArray(inner, outer, interval);
					// Make room for the smaller temp by moving values in the
					// array
					// up one space if they are greater than temp
					theArray[inner] = theArray[inner - interval];
					System.out.println(theArray[inner - interval]
						+ " moved to index " + inner);
					inner -= interval;
					System.out.println("inner= " + inner);
					printHorzArray(inner, outer, interval);
					System.out.println("outer= " + outer);
					System.out.println("temp= " + temp);
					System.out.println("interval= " + interval);
				}
				// Now that everything has been moved into place put the value
				// stored in temp into the index above the first value smaller
				// than it is
				theArray[inner] = temp;
				System.out.println(temp + " moved to index " + inner);
				printHorzArray(inner, outer, interval);
			}
			// Once we get here we have interval sorted our array
			// so we decrement interval and go again
			interval = (interval - 1) / 3;
		}					
	}
	
	public void printHorzArray(int i, int j, int h) {
		if (i == j)
			i = i - h;
		for (int n = 0; n < 51; n++)
			System.out.print("-");
		System.out.println();
		for (int n = 0; n < arraySize; n++) {
			System.out.print("| " + n + "  ");
		}
		System.out.println("|");
		for (int n = 0; n < 51; n++)
			System.out.print("-");
		System.out.println();
		for (int n = 0; n < arraySize; n++) {
			System.out.print("| " + theArray[n] + " ");
		}
		System.out.println("|");
		for (int n = 0; n < 51; n++)
			System.out.print("-");
		System.out.println();
		if (i != -1) {
			// Number of spaces to put before the F
			int spacesBeforeFront = 5 * i + 1;
			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");
			System.out.print("I");
			// Number of spaces to put before the R
			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;
			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");
			System.out.print("O");
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args){		
		ArrayStructures newArray = new ArrayStructures();		
		/*
		newArray.generateRandomArray();		
		
		
		System.out.println(newArray.getValueAtIndex(3));
		
		System.out.println(newArray.doesArrayContainThisValue(18));
		
		newArray.deleteIndex(4);
		newArray.printArray();
		
		newArray.insertValue(4);
		newArray.printArray();
		
		newArray.linearSearchForValue(17);
				
		newArray.generateRandomArray();		
		newArray.printHorzArray(-1,-1);
		
		newArray.linearSearchForValue(10);		
		newArray.bubbleSort();		
		// We must Sort first		
		newArray.binarySearchForValue(17);
		
		newArray.generateRandomArray();	
		newArray.selectionSort();
		
		*/
		newArray.generateRandomArray();	
		newArray.printArray();
		newArray.shellSort();
	}
}
