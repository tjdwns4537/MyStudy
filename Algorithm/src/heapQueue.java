import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heapQueue {
    public static void main(String[] args) {
        String[] b = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        String resultArr = Arrays.toString(solution(b));
        System.out.println(resultArr);
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();

        for (String operation : operations) {
            String[] splitOrder = operation.split(" ");

            if (splitOrder[0].equals("I")) {
                // 일단 두 큐에 뒤에 숫자를 넣어준다.
                priorityQueueMax.add(Integer.parseInt(splitOrder[1]));
                priorityQueueMin.add(Integer.parseInt(splitOrder[1]));
            }

            if (splitOrder[0].equals("D")) {
                if (!priorityQueueMax.isEmpty()) {
                    // 우선순위 큐가 비지 않을경우만 동작
                    if (splitOrder[1].equals("1")) {
                        // 1이면 최대값을 삭제한다.
                        int max = priorityQueueMax.peek();
                        priorityQueueMax.remove(max);
                        priorityQueueMin.remove(max);
                        // 삭제는 max,min 큐 둘다 해준다.
                    }
                    else {
                        // -1 이면 최솟값을 삭제한다.
                        int min = priorityQueueMin.peek();
                        priorityQueueMax.remove(min);
                        priorityQueueMin.remove(min);
                    }
                }
            }
        }

        if (!priorityQueueMax.isEmpty()) {
            answer[0] = priorityQueueMax.peek();
            answer[1] = priorityQueueMin.peek();
        }

        return answer;
    }
}
