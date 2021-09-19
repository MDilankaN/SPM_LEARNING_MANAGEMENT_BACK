package lk.spm.learning.management.model;

public class FileModel {
    private String name;
    private String uri;
    private String type;
    private long size;
    private String price;
    private String description;
    private String course;

    public FileModel(String name, String uri, String type) {
        this.name = name;
        this.uri = uri;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
