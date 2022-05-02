package com.java.Collection;

public class TowerOfHanoi {

    public static void doTowerOfHanoi(int n, char source, char dest, char aux){
        //base condition//
        if(n==1){
            System.out.println("Move disk "+n+" from "+source+" to "+dest);
            return;
        }
        doTowerOfHanoi(n-1, source, aux, dest); //n-1 disks will move from A to B
        System.out.println("Move disk"+n+" from Source "+source+" to "+dest);
        doTowerOfHanoi(n-1, aux, dest, source);


    }

    public static void main(String[] args) {
        char sourceRod = 'A';
        char auxillaryRod = 'B';
        char destRod = 'C';
        int numberOfDisk = 3;
        doTowerOfHanoi(numberOfDisk, sourceRod, destRod, auxillaryRod);
    }
}



//* Only  one disk u can move at a time
//** Each move consists of taking the upper disk from one of the rods and sliding it onto another rod, on top of the
//other disks that may already be present on that rod
//
//
//I'm considering that I have 3 disks.
//
//Step 1 : Move the 3rd disk from A to c
//Step 2 : Move the 2nd disk from A to B //
//Step 3: Move the 3rd disk from C to B
//Step 4: Move the 1st disk from A to C
//Step 5: Move the
//
//
//
//1 . Move n-1 disk from source to auxillary rod.
//2. Move the nth disk from source to destination.
//3.
//
//
//
//toh(source, auxillary, dest){
//     //   Move n-1 disk from source to auxillary rod.
//        // Move the nth disk from source to destination.
//        //toh(auxillary, source, destination
//        }

