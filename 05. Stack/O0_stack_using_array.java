
public class O0_stack_using_array {
    int arr[];
    int size;
    int top;

    O0_stack_using_array(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return ( top == size - 1);
    }

    public int peek() {
        if (!this.isEmpty())
            return arr[top];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public void push(int element) {
        if (!isFull()) {
            top++;
            arr[top] = element;
            System.out.println("Pushed element:" + element);
        } else {
            System.out.println("Stack is full !");
        }
    }

    public int pop() {

        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("Popped element :" + arr[returnedTop]);
            return arr[returnedTop];

        } else {
            System.out.println("Stack is empty !");
            return -1;
        }
    }


    public static void main(String[] args) {
        O0_stack_using_array st = new O0_stack_using_array(10);
        st.pop();
        System.out.println("=================");
        st.push(10);
        st.push(30);
        st.push(50);
        st.push(40);
        System.out.println("=================");
        st.pop();
        st.pop();
        st.pop();
        System.out.println("=================");
    }
}