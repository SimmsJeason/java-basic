package DataStructure.Algorithom.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("天津");
        hashSet4.add("上海");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("大连");
        allAreas.add("成都");
        allAreas.add("杭州");

        List<String> selects = new ArrayList<String>();

        //定义一个临时集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和没有覆盖地区的交集
        HashSet<String> tmpSet = new HashSet<String>();

        //定义一个maxKey, 保存一次遍历中，能够覆盖最大未覆盖地区的电台的key
        //如果maxKey不为null, 则将对应的电台放入selects中
        String maxKey = null;
        while (allAreas.size() != 0){
            for(String key : broadcasts.keySet()){
                HashSet<String> areas = broadcasts.get(key);
                tmpSet.addAll(areas);

                //求出tmpSet 和 allAreas 集合的交集， 交集会赋给tmpSet
                tmpSet.retainAll(allAreas);

                //maxKey指向的结合与未覆盖的交集个数
                HashSet<String> maxKeySet = new HashSet<String>();
                maxKeySet.addAll(broadcasts.get(maxKey));
                maxKeySet.retainAll(allAreas);
                //如果当前未覆盖的数量多余maxKey指向的集合数量，需要重置maxKey
                if(tmpSet.size() > 0 &&(maxKey == null || tmpSet.size() > maxKeySet.size())){
                    maxKey = key;
                }
            }
        }
    }
}
