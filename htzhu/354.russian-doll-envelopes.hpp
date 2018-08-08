class Solution {
public:
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
      sort(envelopes.begin(), envelopes.end(), [](const auto &lhs, const auto &rhs) {
          return lhs.first < rhs.first || lhs.first == rhs.first && lhs.second > rhs.second;
        });
      auto e = envelopes.begin();
      for(auto & doll: envelopes) {
        int height = doll.second;
        auto it = lower_bound(envelopes.begin(), e, height, [](const auto &envelope, int h) {
                                                           return envelope.second < h;
                                                         });
        if(it == e) {
          (e++)->second = height;
        } else {
          it->second = height;
        }
      }
      return e - envelopes.begin();
    }
};
