package Files;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Dir implements IFile, Iterator{
    public String name;
    public Dir(String name){
        this.name = name;
    }
    public Integer size(){
        return children.stream().map(Files.IFile::size).reduce(0,(x,y)->x+y);
    }
    List<IFile> children = new ArrayList<>();
    public List<IFile> getChildren() {
        return children;
    }
    public Dir findDir(String name){
        return (Dir)children.stream().filter(x->x.name == name).toArray()[0];
    }
    public void addChild(IFile file){
        children.add(file);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("- (Dir) {0} {1}",this.name, this.size()));
        for (IFile iFile : children) {
            sb.append(String.format("\n{0}",iFile.toString()));
        }
        return sb.toString();
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }
    @Override
    public Object next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
    
}
