public class HashFunctionExample {
    static class HashTable {
        private String[] table;
        private int size;

        public HashTable(int size) {
            this.size = size;
            this.table = new String[size];
        }

        public int hashFunction(String key) {
            int hash = 0;
            for (int i = 0; i < key.length(); i++) {
                hash += key.charAt(i) * (i + 1);
            }
            return hash % size;
        }

        public void insert(String key) {
            int index = hashFunction(key);
            int originalIndex = index;
            while (table[index] != null) {
                index = (index + 1) % size;
                if (index == originalIndex) {
                    System.out.println("Hash table is full!");
                    return;
                }
            }
            table[index] = key;
            System.out.println("Inserted '" + key + "' at index " + index);
        }

        public int search(String key) {
            int index = hashFunction(key);
            int originalIndex = index;
            while (table[index] != null) {
                if (table[index].equals(key)) {
                    return index;
                }
                index = (index + 1) % size;
                if (index == originalIndex) {
                    break;
                }
            }
            return -1;
        }

        public void display() {
            System.out.println("Hash Table Contents:");
            for (int i = 0; i < size; i++) {
                System.out.println("Index " + i + ": " + (table[i] != null ? table[i] : "empty"));
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert("Shaurya");
        hashTable.insert("banana");
        hashTable.insert("orange");
        hashTable.insert("grape");
        hashTable.display();

        String searchKey = "banana";
        int index = hashTable.search(searchKey);
        System.out.println("\nSearching for '" + searchKey + "': " +
                (index != -1 ? "Found at index " + index : "Not found"));

        searchKey = "mango";
        index = hashTable.search(searchKey);
        System.out.println("Searching for '" + searchKey + "': " +
                (index != -1 ? "Found at index " + index : "Not found"));
    }
}
