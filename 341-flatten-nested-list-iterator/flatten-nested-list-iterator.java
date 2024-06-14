public class NestedIterator implements Iterator<Integer> {
    List<Integer> flatList = null;
    int iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        flatList = new ArrayList<>();
        iterator = 0;
        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList){
        for(NestedInteger ele : nestedList){
            if(ele.isInteger()){
                flatList.add(ele.getInteger());
            }else{//recurse for the flatten list function
                flattenList(ele.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return flatList.get(iterator++);
        }else{
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return iterator < flatList.size();
    }
}