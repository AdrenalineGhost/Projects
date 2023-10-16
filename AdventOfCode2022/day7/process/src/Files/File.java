package Files;

public class File implements IFile{
    public Integer size;
    public String name;
    public File(String name, int size){
        this.size = size;
        this.name = name;
    }
    public Integer size() {
        return this.size;
    }
    @Override
    public String toString(){
        return String.format("- (file){0} {1}", this.name, this.size);
    }
    
    
    
}
