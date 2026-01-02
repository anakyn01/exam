TestList = [1,2,3,4,5]
TestList = list(map(lambda num: num + 100, TestList))
#TestList 각요소의 lambda 함수를 적용 결과는 map객체(아직리스트가 아님)

print(TestList)