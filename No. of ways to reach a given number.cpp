
#include<iostream>
using namespace std;
 
int countWays(int score)
{
    int i;
 
    //create an array to store the calculated results for smaller score
    int result[score+1];
 
    //result[i]=no. of ways to reach score i
 
    //initialization
      result[0]=1;
      cout<<"initial array:"<<endl;
   
      cout<<result[0]<<" ";
       //since, there is only one way to reach NIL score is to don't make any move
 
    //initialize result[0]=0 for all other values
    //cout<<"initial array:"<<endl;
    for(i=1;i<=score;i++)
    {
     result[i]=0;
        cout<<result[i]<<" ";
 
    }
    
    //First count the ways to reach the score i using only 3
    cout<<endl;
   
    cout<<"array of 3 is:"<<endl;
    for(i=3;i<=score;i++)
    {
        result[i]+=result[i-3];
        cout<<result[i]<<" ";
  // cout<<endl;
}
//cout<<result[i]<<endl;
  
  
    //Now, count the ways using move 5
    cout<<endl;
   
    cout<<"array of 5 is:"<<endl;
    for(i=5;i<=score;i++)
    {
        result[i]+=result[i-5];
         cout<<result[i]<<" ";
  }
   
    //now, the final result will be calculated
    cout<<endl;
   
    cout<<"array of 10 is:"<<endl;
    for(i=10;i<=score;i++)
    {
        result[i]+=result[i-10];
        cout<<result[i]<<" ";
   // cout<<endl;
    }
    cout<<endl;
   
 //cout <<result[i]<<endl;
    return result[score];
}
 
int main()
{
    int score;
 
    cout<<"Enter the score"<<endl;
    cin>>score;
 
    //cout<<countWays(score);
    //cout<<endl;
   
 cout<<"No. of ways to reach the given score are: "<<countWays(score)<<endl;
    
    cout<<endl;
    return 0;
}

