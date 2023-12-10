package СТР145;

import java.util.Scanner;
public class City {
        public static Scanner ob=new Scanner(System.in);
public info info;
public String city;
public City(){
        System.out.print("vvedite nazvanie goroda");
        setCity(ob.next());
        info=new info();
        }
public String getCity(){
        return city;
        }
        public void setCity(String city){
        this.city=city;
        }
        public class info{
        int pr,st,sq;
public info(){
        System.out.print("Кол-во проспектов в городе:");
        setPr(ob.nextInt());
        System.out.print("Количество улиц в городе:");
        setSt(ob.nextInt());
        System.out.print("кол-во площадей в городе:");
        setSq(ob.nextInt());
        }
        public int getPr(){
        return pr;
        }
        public void setPr(int pr){
        this.pr=pr;
        }
        public int getSt(){
        return st;
        }
        public void setSt(int st){
        this.st=st;
        }
        public int getSq(){
        return sq;
        }
        public void setSq(int sq){
        this.sq=sq;
        }
        public void print(){
        System.out.print("в городе"+getCity()+""+getPr()+"проспектов,"+getSt()+"улицы и"+getSq()+"площадей");
        }
        }
        static public void main(String[]args){
        City ct=new City();
        ct.info.print();
        }
        }