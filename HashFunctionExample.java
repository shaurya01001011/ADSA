
public class HashFunctionExample {
    // Simple hash table class
    static class HashTable {
        private String[] table;
        private int size;

        public HashTable(int size) {
            this.size = size;
            this.table = new String[size];
        }

        // Hash function for strings
        public int hashFunction(String key) {
            int hash = 0;
            // Sum the ASCII values of characters multiplied by their position
            for (int i = 0; i < key.length(); i++) {
                hash += key.charAt(i) * (i + 1);
            }
            // Use modulo to fit within table size
            return hash % size;
        }

        // Insert key into hash table using linear probing
        public void insert(String key) {
            int index = hashFunction(key);
            int originalIndex = index;

            // Linear probing for collision resolution
            while (table[index] != null) {
                index = (index + 1) % size; // Move to next slot
                if (index == originalIndex) {
                    System.out.println("Hash table is full!");
                    return;
                }
            }
            table[index] = key;
            System.out.println("Inserted '" + key + "' at index " + index);
        }

        // Search for a key in the hash table
        public int search(String key) {
            int index = hashFunction(key);
            int originalIndex = index;

            while (table[index] != null) {
                if (table[index].equals(key)) {
                    return index;
                }
                index = (index + 1) % size; // Move to next slot
                if (index == originalIndex) {
                    break;
                }
            }
            return -1; // Key not found
        }

        // Display the hash table
        public void display() {
            System.out.println("Hash Table Contents:");
            for (int i = 0; i < size; i++) {
                System.out.println("Index " + i + ": " + (table[i] != null ? table[i] : "empty"));
            }
        }
    }

    public static void main(String[] args) {
        // Create a hash table of size 10
        HashTable hashTable = new HashTable(10);

        // Insert some keys
        hashTable.insert("Shaurya");
        hashTable.insert("banana");
        hashTable.insert("orange");
        hashTable.insert("grape");
        hashTable.insert("apple");
        // Display the hash table
        hashTable.display();

        // Search for keys
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
