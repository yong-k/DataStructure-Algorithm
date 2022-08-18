package doit_algorithm.ch03;

// 실습 3C-3
public class p130 {
    static class GenericClass<T> {
        private T xyz;
        GenericClass(T t) {
            this.xyz = t;
        }

        T getXyz() {
            return xyz;
        }

        public static void main(String[] args) {
            GenericClass<String> s = new GenericClass<>("ABC");
            //GenericClass<int> x = new GenericClass<>(12);
            //-- 에러남. Integer로 써야한다.
            GenericClass<Integer> n = new GenericClass<>(12);

            System.out.println(s.getXyz());
            System.out.println(n.getXyz());
        }
    }
}
