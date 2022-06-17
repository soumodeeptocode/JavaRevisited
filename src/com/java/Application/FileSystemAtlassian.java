package com.java.Application;

import java.util.*;

    class FileSystem {
        Map<String, FileSystemAttributes> directoryDetailsMap;
        PriorityQueue<Directory> directoryHeap;
        HashSet<Directory> isDirectoryPresentInHeap;
        int allFileSize;

        public FileSystem() {
            this.directoryDetailsMap = new HashMap<>();
            this.directoryHeap = new PriorityQueue<>((a,b) -> b.directorySize - a.directorySize);
            this.isDirectoryPresentInHeap = new HashSet<>();
            this.allFileSize = 0;
        }

        public int getAllFileSize(){
            System.out.println(directoryDetailsMap.toString());
            return this.allFileSize;
        }

        public List<Directory> getNCollection(int n) {
            if(directoryHeap.size() < n) return new ArrayList<>();

            List<Directory> output = new ArrayList<>();
            PriorityQueue<Directory> tempDirectoryHeap = new PriorityQueue<>((a,b) -> b.directorySize - a.directorySize);

            for(int i=0; i < n; i++){
                Directory d = directoryHeap.poll();
                output.add(d);
                tempDirectoryHeap.add(d);
            }

            for(int i=0; i < n; i++){
                directoryHeap.add(tempDirectoryHeap.poll());
            }
            return output;
        }

//        public void printInterimData(){
//
//            for(Map.Entry<String, FileSystemAttributes> iterateMap : directoryDetailsMap.entrySet()){
//                System.out.println("Key :: "+iterateMap.getKey()+" "+"Values :: "+iterateMap.getValue().toString());
//            }
//        }


        public void addFileToDirectory(String fileName, int size, String dName) {
            File file;
            if(dName.equals("")){
                file = new File(fileName, size);
                directoryDetailsMap.put(fileName, file);
            }else{
                Directory directory = (Directory) directoryDetailsMap.getOrDefault(dName, new Directory(dName));
                file = new File(fileName, size, directory);

                directory.directorySize += size;
                directory.listOfFiles.add(file);

                if(!isDirectoryPresentInHeap.contains(directory)){
                    System.out.println("For which fileName :: " +fileName);
                    directoryHeap.add(directory);
                    isDirectoryPresentInHeap.add(directory);
                }
                directoryDetailsMap.put(dName, directory);
            }
            Iterator<Directory> iterate = directoryHeap.iterator();
            if(iterate.hasNext()){
                System.out.println("Printing from priority list :: "+iterate.next().directoryName);
            }
            //System.out.println(directoryHeap.toString());
            allFileSize += size;
        }
    }

    interface FileSystemAttributes{};

    class Directory implements FileSystemAttributes {
        String directoryName;
        int directorySize;
        List<File> listOfFiles;

        public Directory(String fileName) {
            this.directoryName = fileName;
            this.directorySize = 0;
            this.listOfFiles = new ArrayList<>();
        }

//        @Override
//        public String toString() {
//            return "Directory{" +
//                    "Directory Name='" + directoryName + '\'' +
//                    ", size=" + directorySize +
//                    ", List Of Files =" + listToString(listOfFiles) +
//                    '}';
//        }
//
//        private String listToString(List<File> files){
//            StringBuilder stringBuilder = new StringBuilder();
//            for(File xFile: files) {
//                stringBuilder.append("FileName");
//                stringBuilder.append("---->");
//                stringBuilder.append(xFile.filename);
//                stringBuilder.append(",\n");
//            }
//            return stringBuilder.toString();
//        }
    }

    class File implements FileSystemAttributes {
        String filename;
        int fileSize;
        Directory directory;

        public File(String fileName, int fileSize) {
            this.filename = fileName;
            this.fileSize = fileSize;
        }

        public File(String fileName, int fileSize, Directory directory) {
            this.filename = fileName;
            this.fileSize = fileSize;
            this.directory = directory;
        }

    }

public class FileSystemAtlassian {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        //Adding files to directory//
        fileSystem.addFileToDirectory("file6.txt", 1000, "");

        fileSystem.addFileToDirectory("file1.txt", 100, "Collection1");
        fileSystem.addFileToDirectory("file2.txt", 100, "Collection2");
        fileSystem.addFileToDirectory("file3.txt", 200, "Collection3");
        fileSystem.addFileToDirectory("file4.txt", 300, "Collection4");
        fileSystem.addFileToDirectory("file5.txt", 400, "Collection5");
        fileSystem.addFileToDirectory("file7.txt", 100, "Collection1");
        fileSystem.addFileToDirectory("file8.txt", 100, "Collection4");

        System.out.println("All File Size :: "+fileSystem.getAllFileSize());
        List<Directory> topNCollections = fileSystem.getNCollection(2);
        for(Directory collection: topNCollections){
            System.out.println(collection.directoryName+ " " + collection.directorySize + " ");
        }
        //fileSystem.printInterimData();
    }
}

