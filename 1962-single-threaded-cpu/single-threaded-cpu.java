class Solution {
    public int[] getOrder(int[][] tasks) {
             int n = tasks.length;

        // Step 1: Create a combined array with [index, enqueueTime, processingTime]
        int[][] allTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            allTasks[i][0] = i;           // original index
            allTasks[i][1] = tasks[i][0]; // enqueue (available) time
            allTasks[i][2] = tasks[i][1]; // processing time
        }

        // Step 2: Sort tasks by their enqueue time (ascending)
        Arrays.sort(allTasks, (a, b) -> a[1] - b[1]);

        // Step 3: Min-heap based on processing time, then index
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]
        );

        int i = 0;          // pointer for tasks
        int index = 0;      // result index
        int curTime = 0;    // current CPU time
        int[] result = new int[n];

        // Step 4: Process all tasks
        while (i < n) {
            // Add all tasks that are now available to the heap
            while (i < n && allTasks[i][1] <= curTime) {
                minHeap.add(allTasks[i++]);
            }

            // If heap empty → jump time to next task’s start
            if (minHeap.isEmpty()) {
                curTime = allTasks[i][1];
                continue;
            }

            // Get task with smallest processing time
            int[] curTask = minHeap.poll();
            result[index++] = curTask[0];  // store original index
            curTime += curTask[2];         // advance current time
        }

        // Process any remaining tasks
        while (!minHeap.isEmpty()) {
            int[] curTask = minHeap.poll();
            result[index++] = curTask[0];
        }

        return result;
    }
}