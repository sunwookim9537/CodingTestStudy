import java.util.*;
class Solution {
    static class q {
        int weight;
        int outTime;

        q(int weight, int outTime) {
            this.weight = weight;
            this.outTime = outTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        /*
            일차선 다리를 정해진 순으로 건넘
            모든 트럭이 다리를 건너려면 최소 몇 초가 걸릴지
            다리에는 트럭-> bridge_length대 올라갈 수 있음
            다리는 weight 이하까지의 무게를 건딜 수 있음
            단 다리에 완전히 오르지 않은 트럭의 무게는 무시
            
            ex. 트럭 2대가 올라갈 수 있고, 무게 10kg까지 견딜 수 있음
            무게가 [7,4,5,6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건넌다
            1초 -> 다리 위에 있고 3ㅇ초엔 내려옴 / 3초에 다리 위에 올라가고 4초에 다리위에 있다가 5초/
            무게가 감당되면 바로 올라감 -> 4초에 올라가서 5초에 있다가 내려감 / 5초에있다가 7초까지 있고, 8초엔 내려감  
            queue쓰고 
        */
        Queue<q> truck= new LinkedList<>();
        int idx = 0;
        int totalWeight = 0;


        //무게 
            int tmp=0; //초
        while(!truck.isEmpty() || idx<truck_weights.length){
            tmp++; //시간 추가 
            if(!truck.isEmpty() && truck.peek().outTime==tmp){
                totalWeight-=truck.peek().weight;
                truck.poll(); // 시간 지나면 나가쇼

            }
            
            if(idx < truck_weights.length && truck.size()<bridge_length &&totalWeight+truck_weights[idx]<=weight){
                //트럭 n대가 올라가 있지 않고, 무게가 크지 않으면
                truck.offer(new  q(truck_weights[idx],tmp+bridge_length));
                totalWeight+=truck_weights[idx];
                idx++;
            }
        }
       
        return tmp;
    }
}