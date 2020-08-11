package com.iyengarcoders.groceries.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name="id", length = 36, nullable = false)
    private UUID id;

    @Column(name="file_name")
    private String fileName;

    @Column(name="file_type")
    private String fileType;

    @Column(name="is_default")
    private boolean isDefault;

    @Lob
    private byte[] data;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Files() {

    }

    public Files(String fileName, String fileType, boolean isDefault, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.isDefault = isDefault;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Files files = (Files) o;
        return Objects.equals(id, files.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
