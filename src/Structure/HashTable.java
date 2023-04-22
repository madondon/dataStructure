package Structure;

/**
 * Created by max on 17-5-3.
 */
public class HashTable {

    private static final int DEFAULT_INITAL_CAPACITY = 5;//定义的是默认长度

    private static final float LOAD_FACTOR = 0.75f;//扩容因子

    private Entry[] table = new Entry[DEFAULT_INITAL_CAPACITY];//初始化
    private int size =0;//哈系表大小
    private int use =0;//使用的地址数量

    private class Entry{
        int key;//关键字
        int value;
        Entry next;//链表

        public Entry(int key,int value ,Entry entry)//构造函数
        {
            super();
            this.key = key;
            this.value = value;
            this.next = entry;
        }
    }

    public void put(int key,int value){//压入内容
        int index =hash(key);//通过hash方法转换，采用的是直接法

        if (table[index]==null)//说明位置未被使用
        {
            table[index] = new Entry(-1,-1,null);
        }

        Entry tmp = table[index];
        if (tmp.next == null)//说明位置未被使用
        {
            table[index].next = new Entry(key,value,null);
            size++;
            use++;
            if (use >= table.length*LOAD_FACTOR)//判断是否需要扩容
            {
                resize();//扩容方法
            }
        }else{//已被使用，则直接扩展链表
            for (tmp = tmp.next;tmp!=null;tmp = tmp.next) //判断键是否相同，相同则更新
            {
                if(tmp.key==key)
                {
                    tmp.value = value;
                    return;
                }
            }

            Entry temp = table[index].next;
            table[index].next = new Entry(key,value,temp);
            size++;
        }

    }
    public void remove(int key) //删除，链表的中间值删除方法
    {
        int index =hash(key);
        Entry e = table[index];
        Entry pre = table[index];
        if (e!=null&& e.next!=null)
        {
            for (e=e.next;e!=null;pre =e,e =e.next)
            {
                int k =e.key;
                if(k==key)
                {
                    pre.next = e.next;
                    size--;
                    return;
                }
            }
        }
    }

    public int get(int key)//通过key提取value
    {
        int index = hash(key);
        Entry e =table[index];
        if (e!=null&&e.next!=null)
        {
            for (e=e.next;e!=null;e=e.next)
            {
                int k = e.key;
                if (k ==key)
                {
                    return e.value;
                }
            }
        }
        return -1;
    }

    public int size(){//返回元素个数
        return size;
    }

    public int getLength(){//哈系表大小
        return table.length;
    }


    private void resize() {
        int newLength = table.length*2;
        Entry[] oldTable = table;
        table = new Entry[newLength];
        use = 0;
        for(int i =0 ;i<oldTable.length;i++)
        {
            if (oldTable[i]!=null&&oldTable[i].next !=null)
            {
                Entry e = oldTable[i];
                while(null!=e.next)
                {
                    Entry next = e.next;
                    int index =hash(next.key);
                    if (table[index]==null)
                    {
                        use++;
                        table[index] = new Entry(-1,-1,null);
                    }
                    Entry temp = table[index].next;
                    Entry newEntry =new Entry(next.key,next.value,temp);
                    table[index].next = newEntry;

                    e = next;
                }
            }
        }

    }

    private int hash(int key) {//哈希方法
        return key%table.length;
    }
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(11, 10);
        ht.put(21, 20);
        ht.put(33, 30);
        ht.put(44, 40);
        ht.put(55, 50);
        ht.put(66, 60);
        System.out.println(ht.get(11));
        System.out.println(ht.get(21));
        System.out.println(ht.get(33));
        System.out.println(ht.get(44));
        System.out.println(ht.get(55));
        System.out.println(ht.get(6));
        System.out.println(ht.size());
    }
}
