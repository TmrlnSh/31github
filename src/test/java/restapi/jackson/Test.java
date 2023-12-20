package restapi.jackson;

public class Test {
    public static void main(String[] args) {
        //Написать функцию, которая будет возвращать true,
        // если поданный на ввод массив int содержит 3 и
        // более последовательных числа в любом месте.
        Test test = new Test();
        System.out.println(test.intSequence(new int[]{4, 3, 2,4,4,6}));
    }
    public boolean intSequence(int[] nums){
        int count = 0;
        for (int i =1; i < nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                count++;
                if (count>=3){
                    return true;
                }
            }else {
                count = 1;
            }
        }
        return false;
        //gooooo1232231rfds
    }
}
