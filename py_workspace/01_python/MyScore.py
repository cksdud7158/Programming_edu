def getSum(data):
    total=0
    for i in data:
        total += i
    return total

def getMean(data):
    total=0
    for i in data:
        total += i
    mean = total/len(data)
    return mean

def getMax(data):
    maxNum=data[1]
    for i in data[1:]:
        if(i>maxNum):
            maxNum=i
    return maxNum
        

def getMin(data):
    minNum=data[1]
    for i in data[1:]:
        if(i<minNum):
            minNum=i
    return minNum

def getTwoSum(num2, num1=1): # num1 이 더큰값이 왔을 때
    total=0
    if num2<num1:
        num1, num2 = num2, num1
    for i in range(num1, num2+1):
        total += i
    return total

