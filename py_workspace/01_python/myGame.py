
import random

def makeLotto(num):
    for i in range(num):
        list1= list()
        while True:
            list1.append(random.randrange(1,46))
            if(len(list1)>6):
                break
        print('게임',i+1,list1)

def meanGrade(grade):
    grades = grade.split(',')
    total=0
    for i in grades:
        if i=='A+':
            total += 4.5
        elif i=='A':
            total += 4.3
        elif i=='A-':
            total += 4.0
        elif i=='B+':
            total += 3.5
        elif i=='B':
            total += 3.3
        elif i=='B-':
            total += 3.0
        elif i=='C':
            total += 2.5
        elif i=='D':
            total += 1.5
    print(total/len(grades))
        
    
