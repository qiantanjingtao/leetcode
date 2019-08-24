//
//  niuke
//
//  Created by 朱锦涛 on 2019/8/22.
//  Copyright © 2019 朱锦涛. All rights reserved.
//


struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
    val(x), next(nullptr) {
    }
};


class Solution {
public:
    ListNode* deleteDuplication(ListNode* pHead)
    {
        ListNode* cur = pHead;
        if (pHead == nullptr) {
            return nullptr;
        }
        
        ListNode* store = pHead;
        
        while (cur->next != nullptr) {
            cur = cur->next;
            
            if(cur->val != store->val) {
                store = store->next;
            } else {
                cur = cur->next;
                while (cur != nullptr) {
                    if (cur->val == store->val) {
                        cur = cur->next;
                    } else {
                        break;
                    }
                }
                
                if (cur == nullptr) {
                    ListNode* findend = store->next;
                    ListNode* help = findend;
                    while (findend != nullptr) {
                        findend = help->next;
                        delete help;
                        help = findend;
                    }
                    store->next = nullptr;
                    return pHead;
                } else {
                    ListNode* tmp = store->next;
                    if (tmp->next == cur) {
                        store->next = cur;
                        store = cur;
                        delete tmp;
                        continue;
                    }
                    while (tmp->next != cur) {
                        ListNode *del = tmp;
                        tmp = tmp->next;
                        delete del;
                    }
                    
                    store->next = tmp->next;
                    store = store->next;
                    delete tmp;
                }
            }
        }
        
        return pHead;
    }
};

int main(int argc, const char * argv[]) {
    Solution s;
    return 0;
}
