class RandomizedSet {
    unordered_map<int,int> mpp; // [val, ind] // nums[ind] = val
    vector<int> nums;

public:
    RandomizedSet() {
    }
    
    bool insert(int val) {
        if( mpp.count(val) ) return false;
        
        nums.push_back(val);
        mpp[val] = nums.size()-1;
        return true;
    }
    
    bool remove(int val) {
        if( !mpp.count(val) ) return false;

        // copy last value of nums to val's index
        int ind = mpp[val];
        nums[ind] = nums[nums.size()-1];
        mpp[nums[ind]] = ind;
        
        // erase last from nums
        nums.pop_back();
        mpp.erase(val);
        return true;
    }
    
    int getRandom() {
        return nums[rand() % nums.size()];
    }
};