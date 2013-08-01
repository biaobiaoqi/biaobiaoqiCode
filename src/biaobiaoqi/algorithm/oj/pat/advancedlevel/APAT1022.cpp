/*http://pat.zju.edu.cn/contests/pat-a-practise/1022
 ��ģ���⣬

 1.mapӳ���ʹ����һ�����ɵķ�ʽ������ģ�����1-5�Ĳ�ѯ��������趨�����ӳ�䣬��map<queryClass, map<char *, priorityqueue>>��
 ʵ���ϣ���ȫ������һ��map<char *, priorityqueue>��ʵ�֣�����char*�ַ�������1-5�ı�Ǽ��ɡ�
 2.priority_queueʹ��priority_queue<string, vector<string>, greater<string>> ���Խ�������������ת��Ϊ��С�ѡ�
*/
#include<map>
#include<string>
#include<iostream>
#include<queue>
using namespace std;

int main()
{
	int n;
	map<string, priority_queue<string, vector<string>, greater<string>>> map;

	cin >> n;
	getchar();
	string id, title, author, keywords, publisher, year;
	for (int i = 0; i != n; ++ i) {
		getline(cin, id);
		getline(cin, title);
		getline(cin, author);
		getline(cin, keywords);
		getline(cin, publisher);
		getline(cin, year);
		int si = 0;
		while ((si =  keywords.find(" ")) != -1) {
			map["3: " + keywords.substr(0, si)].push(id);
			keywords = keywords.substr(si + 1, keywords.length() - si);
		}
		if (keywords != "")
			map["3: " + keywords].push(id);
		map["1: " + title].push(id);
		map["2: " + author].push(id);
		map["4: " + publisher].push(id);
		map["5: " + year].push(id);
	}

	cin >> n;
	getchar();
	string query;
	while( --n >= 0 ){
		getline(cin, query);
		cout << query << endl;
		if (map.count(query) != 0) {
			while(!map[query].empty()){
				cout << map[query].top() << endl;
				map[query].pop();
			}
		} else cout << "Not Found" << endl;
	}
}
