package entity;

import java.util.*;

public class StudentManager {
    static Scanner input = new Scanner(System.in);
    static HashMap<Integer, Student> students = new HashMap<Integer, Student>();


    public void App() {

        while (true) {
            System.out.print(
                    "请选择操作：\n"
                            + "1 插入\n"
                            + "2 查找\n"
                            + "3 删除\n"
                            + "4 修改\n"
                            + "5 输出\n"
                            + "6 退出\n"
            );
            String str = input.next();
            switch (str) {
                case "1":
                    add();
                    break;
                case "2":
                    select();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    update();
                    break;
                case "5":
                    out();
                    break;
                case "6":
                    exit();
            }
        }
    }

    //退出
    private static void exit() {
        System.out.print("已退出\n");
        System.exit(0);
    }


    //修改
    private static void update() {
        System.out.print("修改操作\n");
        System.out.println("输入要修改学生的ID：");
        int id = input.nextInt();
        Student s = students.get(id);
        System.out.println("输入要修改为的出生日期：");
        s.setBirthDate(input.next());

        students.put(s.getId(), s);
        System.out.println("修改成功");
    }

    //删除
    private static void delete() {
        System.out.print("删除操作\n");
        System.out.println("输入要删除学生的ID：");
        int id = input.nextInt();
        Student s = new Student();
        s.setId(id);

        students.remove(s.getId());
        System.out.println("删除成功");
        //Student.Max--;
    }

    private static void select() {
        System.out.print("查询操作\n");
        System.out.println("输入要查询学生的ID：");
        Integer id = input.nextInt();
        int cnt = 0;
        for (Map.Entry<Integer,Student> entry : students.entrySet()) {
            if (id.equals(entry.getKey()))//比较内容是否存在，是的话打印
            {
                cnt++;
                System.out.print("学生ID：" + entry.getValue().getId()
                        + ", 学生姓名 ： " + entry.getValue().getName()
                        + ", 学生出生日期 ： " + entry.getValue().getBirthDate()
                );
                if (entry.getValue().getGender()) {
                    System.out.println(", 学生性别 ： 男");
                } else {
                    System.out.println(", 学生性别 ： 女");
                }
                System.out.println("查询成功");
            }
        }
            if (cnt==0)
            {
                System.out.println("没有匹配到相关内容！");
            }


    }

    //输出
    private static void out() {
        System.out.print("输出操作\n");
        if (students.isEmpty()) {
            System.out.println("没有学生！");
        }
        else {
            ArrayList<Map.Entry<Integer,Student>> list= new ArrayList<Map.Entry<Integer,Student>>(students.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Integer,Student>>() {

                public int compare(Map.Entry<Integer,Student> o1, Map.Entry<Integer,Student> o2) {
                    return (o1.getKey() - o2.getKey());
                }
            });
            for(Map.Entry<Integer,Student> entry : list) {
                System.out.print("学生ID：" + entry.getValue().getId()
                        + ", 学生姓名 ： " + entry.getValue().getName()
                        + ", 学生出生日期 ： " + entry.getValue().getBirthDate()
                );
                if(entry.getValue().getGender()){
                    System.out.println(", 学生性别 ： 男");
                }
                else{
                    System.out.println(", 学生性别 ： 女");
                }
            }
            //因为Map这个类没有继承Iterable接口所以不能直接通过map.iterator来遍历，所以就只能先转化为set类型，用entrySet()方法，其中set中的每一个元素值问就是map中的一个键值对，也就是Map.Entry<K,V>了，然后就可以遍历了。
            System.out.println("输出成功");
        }
    }

    //添加
    private static void add() {
        System.out.print("添加操作\n");
        System.out.print("请依次输入学生ID 姓名 性别(男为true，女为false) 出生年月\n");
        int id = input.nextInt();
        String name = input.next();
        boolean gender = input.nextBoolean();
        String birth = input.next();
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setBirthDate(birth);
        s.setGender(gender);
        //Integer i = (Integer) id;
        students.put(s.getId(), s);
        System.out.println("添加成功");
        //Student.Max++;

    }

}




