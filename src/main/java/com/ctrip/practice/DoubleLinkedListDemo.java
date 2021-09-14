package com.ctrip.practice;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/2/20
 * @备注:
 */
public class DoubleLinkedListDemo {
    class DoubleLinkedList{
        private HeroNode2 head = new HeroNode2(0,"","");

        public HeroNode2 getHead(){
            return head;
        }

        //添加
        public void add(HeroNode2 heroNode2){
            HeroNode2 temp = head;
            while(true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode2;
            heroNode2.pre = temp;
        }

        //修改
        public void update(HeroNode2 newHeroNode){
            if(head.next == null){
                System.out.println("is empty");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;//是否找到该节点
            while(true){
                if(temp == null){
                    break;
                }
                if(temp.no == newHeroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if(flag){
                temp.name = newHeroNode.name;
                temp.nikcname = newHeroNode.nikcname;
            }else{
                System.out.println("没有该节点");
            }
        }

        public void del(int no){
            if(head.next == null){
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;
            while(true){
                if(temp == null){
                    break;
                }

                if(temp.no == no){
                    flag = true;
                    break;
                }

                temp = temp.next;
            }
            if(flag){
                //temp.next = temp.next.next;
                temp.pre.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
            }else{
                System.out.println("没有该节点");
            }
        }

        //show
        public void list(){
            if(head.next == null){
                System.out.println("is empty");
                return;
            }

            HeroNode2 temp = head.next;

            while(true){
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    class HeroNode {
        public int no;
        public String name;
        public String nikcname;
        public HeroNode next;

        public HeroNode(int no, String name, String nikcname) {
            this.no = no;
            this.name = name;
            this.nikcname = nikcname;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"no\":")
                    .append(no);
            sb.append(",\"name\":\"")
                    .append(name).append('\"');
            sb.append(",\"nikcname\":\"")
                    .append(nikcname).append('\"');
            sb.append(",\"next\":")
                    .append(next);
            sb.append('}');
            return sb.toString();
        }
    }

    class HeroNode2 {
        public int no;
        public String name;
        public String nikcname;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no, String name, String nikcname) {
            this.no = no;
            this.name = name;
            this.nikcname = nikcname;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"no\":")
                    .append(no);
            sb.append(",\"name\":\"")
                    .append(name).append('\"');
            sb.append(",\"nikcname\":\"")
                    .append(nikcname).append('\"');
            sb.append(",\"next\":")
                    .append(next);
            sb.append(",\"pre\":")
                    .append(pre);
            sb.append('}');
            return sb.toString();
        }
    }
}
