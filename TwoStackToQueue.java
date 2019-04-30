import java.util.Stack;

public class NiuKeThree {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        int size = stack2.size();
        if(size > 0) {
            for(int i=0;i < size; i++) {
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
    }

    public int pop() {
        int size = stack1.size();
        if(size > 0) {
            for(int i=0;i < size; i++) {
                stack2.push(stack1.pop());
            }
        }


        return stack2.pop();
    }

    public static void main(String[] args) {
        NiuKeThree nkt = new NiuKeThree();
        nkt.push(1);
        nkt.push(2);
        nkt.push(3);
        System.out.println(nkt.pop());
        System.out.println(nkt.pop());
        nkt.push(4);
        System.out.println(nkt.pop());
        nkt.push(5);
        System.out.println(nkt.pop());
        System.out.println(nkt.pop());
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    