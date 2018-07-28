class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        if (tasks.size() == 0)
            return 0;
        int count[26];
        memset(count, 0, sizeof count);
        for (int i = 0; i < tasks.size(); i++) {
            count[tasks[i] - 'A']++;
        }
        int maxnum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxnum)
                maxnum = count[i];
        }
        int timesMax = 0;
        int restTasks = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == maxnum)
                timesMax++;
            else
                restTasks += count[i];
        }
        if (maxnum == 1) {
            return timesMax + restTasks;
        }
        int cur_cost = max(n + 1, timesMax) * (maxnum - 1) + timesMax;
        int remained_gap = max(0, n + 1 - timesMax);
        int fullStacks = restTasks / (maxnum - 1);
        cout << fullStacks;
        if (fullStacks < remained_gap)
            return cur_cost;
        else
            return cur_cost + restTasks - remained_gap * (maxnum - 1);
    }
};
