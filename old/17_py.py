lst = [1,2,3] 
#파이선은 numpy설치하지 않는한 list를 어레이 대용으로 사용합니다
#아래에 컴프리헨션(List Comprehension)[직관적으로 리스트를 생성하는 방법] 자료구조를 만듭니다 lst의 각 요소를 키로 그값의 2배를 값으로 
#하는 딕셔너리를 만듭니다
dst = {i: i * 2 for i in lst}
s = set(dst.values()) #4개

lst[0] = 99 #각각에 색인에 값을 변경
dst[2] = 7
#변수 s에 dst에 값들을 모아서 집합으로 만듬
s.add(99)
print(len(s & set(dst.values())))
'''
& 교집합 
2,4,6,99 
2,4,7
'''
'''
i = 1 * 2 => 2
i = 2 * 2 => 4
i = 3 * 2 => 6
'''