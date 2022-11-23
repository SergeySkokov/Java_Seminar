package Seminar05.TreeNode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] params) {
        ArrayList<Data> items = new ArrayList<>();

        items.add(new Data(1, 2, 0));
        items.add(new Data(2, 4, 1));
        items.add(new Data(5, 3, 0));
        items.add(new Data(6, 5, 5));
        items.add(new Data(7, 7, 2));
        items.add(new Data(8, 8, 2));
        items.add(new Data(9, 9, 2));
        items.add(new Data(10, 6, 5));

        DataNode tree = DataNode.makeTree(items, new TreeNode.TypeAdapter<Data, DataNode>() {
            @Override
            public DataNode newInstance() {
                return new DataNode();
            }

            @Override
            public boolean isChildOf(Data parentNodeData, Data childNodeData) {
                return parentNodeData.id == childNodeData.parentId;
            }

            @Override
            public boolean isTopLevelItem(Data data) {
                return data.parentId == 0;
            }
        });

        String names = tree.reduce((node, names1) -> {
            if (node.children == null || node.children.isEmpty()) {
                if (names1.length() > 0) {
                    names1 = names1 + ", ";
                }
                names1 = names1 + node.data.number;
            }
            return names1;
        }, "");

        System.out.println("Имена товаров: " + names);
    }

    static class DataNode extends TreeNode<Data, DataNode> {
        @Override
        public int toString() {
            return data.number;
        }
    }

    public static class Data {
        int id;
        int number;
        int parentId;

        public Data(int id, int number, int parentId) {
            this.id = id;
            this.number = number;
            this.parentId = parentId;
        }

        @Override
        public int toString() {
            return number;
        }
    }
}
