#include <iostream>
#include <vector>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    for (int i = 0; i < nums.size(); i++) {
        for (int j = i + 1; j < nums.size(); j++) {
            if (nums[i] + nums[j] == target) {
                return vector<int>{i, j};
            }
        }
    }
    return {};
}

int main() {
    vector<int> arr = {2,7,11,15};
    int target = 9;
    for (int i : twoSum(arr, target)) {
        cout << i;
    }
    return 0;
}
