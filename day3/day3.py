import re;print(sum(int(m.split(',')[0][4:])*int(m.split(',')[1][:-1]) for m in re.findall(r'mul\(\d+,\d+\)',open('1.in').read().strip())),sum([sum(int(m.split(',')[0][4:])*int(m.split(',')[1][:-1]) for m in re.findall(r'mul\(\d+,\d+\)',tx)) for tx in [ss.split("don't()",1)[0] for ss in open('1.in').read().split('do()')]]),end='\n')
