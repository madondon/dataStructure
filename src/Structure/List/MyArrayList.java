package Structure.List;

public class MyArrayList<T> {
        private int size;
        private Object[] elementData;

        public MyArrayList() {
            this.size = 0;
            this.elementData = new Object[10]; // 初始容量为10
        }

        // 获取顺序表的元素个数
        public int getSize() {
            return size;
        }

        // 获取顺序表中指定索引的元素
        public T getIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return (T) elementData[index];
        }


        // 向顺序表中添加元素
        public void add(T e) {
            // 如果当前容量不够，需要扩容
            if (size == elementData.length) {
                int newCapacity = elementData.length * 2; // 扩容为原来的两倍
                Object[] newElementData = new Object[newCapacity];
                System.arraycopy(elementData, 0, newElementData, 0, size);
                elementData = newElementData;
            }
            elementData[size++] = e;
        }

        // 在指定索引处插入元素
        public void insert(int index, T e) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            // 如果当前容量不够，需要扩容
            if (size == elementData.length) {
                int newCapacity = elementData.length * 2; // 扩容为原来的两倍
                Object[] newElementData = new Object[newCapacity];
                System.arraycopy(elementData, 0, newElementData, 0, size);
                elementData = newElementData;
            }
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = e;
            size++;
        }

        // 删除指定索引处的元素
        public T remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            T oldValue = (T) elementData[index];
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
            elementData[--size] = null; // 将最后一个元素置为null，便于垃圾回收
            return oldValue;
        }

        // 判断顺序表是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        // 清空顺序表
        public void clear() {
            for (int i = 0; i < size; i++) {
                elementData[i] = null;
            }
            size = 0;
        }


        // 重写toString方法，便于输出顺序表内容
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i]);
            }
            sb.append("]");
            return  sb.toString();
        }


    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.remove(2);
        System.out.println(myArrayList.toString());
    }

}
