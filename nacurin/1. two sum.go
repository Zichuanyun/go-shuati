func twoSum(nums []int, target int) []int {
    temp := make(map[int]int)
    for i,v := range(nums) {
        j,ok := temp[target - v]
        if ok {
            return []int{j, i}
        }else {
            temp[v] = i
        }
    }
    return nil
}