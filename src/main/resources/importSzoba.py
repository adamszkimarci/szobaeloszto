base = "insert into Szoba(iD, epulet_Nev, emelet_Szama, szoba_Szama, fero_Hely) values ("
id = 1
with open("import.txt", "w+") as f:
    for x in range(11):
        for y in range(40):
            base += str(id) + ", 'A', " + str(x+1) + ", " + str(y+1) + ", 2)\n" 
            id = id + 1
            f.write(base)
            base = "insert into Szoba(iD, epulet_Nev, emelet_Szama, szoba_Szama, fero_Hely) values ("
f.close()
        
        
        
        
     


