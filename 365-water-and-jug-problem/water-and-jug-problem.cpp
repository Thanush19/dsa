class Solution {
public:
    bool canMeasureWater(int x, int y, int z) {
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        
        if(x + y < z) 
            return false;
        if(x == z or y == z or x + y == z)
            return true;
        
        // property of Bézout's identity
        return (z % __gcd(x,y) == 0);
    }
};