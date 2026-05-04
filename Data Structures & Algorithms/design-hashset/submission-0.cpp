class MyHashSet {
public:
    vector<bool> table;

    MyHashSet() {
        table.resize(1000001, false); // max range
    }
    
    void add(int key) {
        table[key] = true;
    }
    
    void remove(int key) {
        table[key] = false;
    }
    
    bool contains(int key) {
        return table[key];
    }
};