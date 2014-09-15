public class TestInt{
  public static void main(String[] args){
   ExpandableIntArray a = new ExpandableIntArray();
   int n =1000000;
   long start =System.currentTimeMillis();
   for (int i=1;i<n;++i){
    a.addToEnd(i+1);
    if(i%100000==0){
     long now=System.currentTimeMillis();
     System.out.println(i+" elapsed time " + (now-start));
    }
   }
    
  }

}