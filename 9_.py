lol = [[1,2,3],[4,5],[6,7,8,9]]#[[0][1][2]]
print(lol[0]) #123
print(lol[2][1]) #7
for sub in lol:
 for item in sub: #각 리스트의 원소를 순서대로 출력함
  print(item, end ='')
print()#각 서브 뒤에 print()가 있어서 줄바꿈이 발생함

'''
정답은
[1,2,3]
7
123
45
6789
'''
