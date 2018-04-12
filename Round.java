import java.util.*;
class Round
{
            Scanner sc=new Scanner(System.in);
            int[] bur,rem,wai,ta,at,ct,ta1,tb;
            int size,q,b=0,t=0,flag=0,x=0,f=0;
            String pn[],rq[],tn[];
            double s=0.0,s1=0.0;
            Round(int siz)
            {
                        size=siz;
                        bur=new int[size];
                        wai=new int[size];
                        ta=new int[size];
                        rem=new int[size];
                        pn=new String[size];
                        at=new int[size];
                        rq=new String[size*size];
                        ct=new int[size*size];
	      tn=new String[size];			
		ta1=new int[size];
		tb=new int[size];
            }
            void get()
            {
                        for(int i=0;i<size;i++)
                        {
                                      System.out.println("Enter Process name:");
                                     pn[i]=sc.next();
		tn[i]=pn[i];
                                    System.out.println("Enter Arival time:");
                                    at[i]=sc.nextInt();
		ta1[i]=at[i];
                                      System.out.println("Enter burst time:");
                                    rem[i]=bur[i]=sc.nextInt();
		tb[i]=bur[i];
                        }
                        System.out.print("Enter quantum time:");
                        q=sc.nextInt();
            }
void sort()
{
          for(int i=0;i<size;i++)
{
for(int j=i+1;j<size;j++)
{
   if(at[i]>at[j])
{
 int t=at[j];
at[j]=at[i];
at[i]=t;
int z=bur[j];
bur[j]=bur[i];
bur[i]=z;
String s=pn[j];
pn[j]=pn[i];
pn[i]=s;

int o;
o=rem[j];
rem[j]=rem[i];
rem[i]=o;
}
}
}
}
            void round1()
            { 
                rq[0]=pn[0];
x++;
                t=at[0];

for(int j=0;j<(size*size);j++)
{

 for( int i=0;i<(size);i++)
{

if(rq[j]==pn[i])
{

if(rem[i]>=q)
{
t=t+q;
rem[i]=rem[i]-q;
ct[j]=t;
}
else 
{
t=t+rem[i];
ct[j]=t;
rem[i]=0;
}


}

}


for(int k=0;k<(size);k++)
{
if(at[k]<=ct[j]&&rem[k]>0)
{

for(int y=j+1;y<(x);y++)
{
if(pn[k]==rq[y])
f=1;
}
if(pn[k]==rq[j])
{
f=0;
continue;
}
if(f==0)
{
rq[x]=pn[k];
x++;
}
f=0;


}
}

}
}


void display()
            { System.out.println("READY QUEUE"+"\t"+"COMPLITION TIME");
                        for(int i=0;i<(size*size);i++)
                        {       if(rq[i]!="null"&&ct[i]!=0)
                                    System.out.println(rq[i] + "\t"+"\t"+ct[i]);
                                    
                        }
                     
            }
void cla()
{
int p[]=new int[size];     
for(int j=0;j<size;j++)  
{ 
 for(int i=x;i>0;i--)
{
    if(rq[i]==tn[j])
    {
    p[j]=ct[i];
break;
}
}  }  
System.out.println("PROCESS"+"\t"+"COMPLETION TIME"+"\t"+"TURNAROUND TIME"+"\t"+"WAITING TIME");
for(int i=0;i<size;i++)
{
int f,g;
f=p[i]-ta1[i];
s=s+f;
g=f-tb[i];
s1=s1+g;
System.out.println(tn[i]+"\t"+"\t"+p[i]+"\t"+"\t"+f+"\t"+"\t"+g);     
}  
System.out.println("AVERAGE TURNAROUND TIME="+(s/size)); 
System.out.println("AVERAGE WAITING TIME="+(s1/size));          
}
}



class Roundrobin
{

           public static void main(String args[])
            {
                        Scanner s=new Scanner(System.in);
                        System.out.print("Enter the no of process:");
                        int n=s.nextInt();
                        Round obj = new Round(n);
                        obj.get();
                        obj.sort();
                        obj.round1();
                        obj.display();
                       obj.cla();


            }
}             
              