package org.example.ishop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "strand_electro")
public class StrandElectro extends BaseEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @Column(name = "gauge")
    private String gauge;

    @Column(name = "country_origin")
    private String countryOrigin;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    public StrandElectro() {
    }

    public StrandElectro(String id) {
        this.id = id != null ? id : UUID.randomUUID().toString();
    }

    public StrandElectro(String gauge, String countryOrigin, String description) {
        this.id = UUID.randomUUID().toString();
        this.gauge = gauge;
        this.countryOrigin = countryOrigin;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGauge() {
        return gauge;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "StrandElectro{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", gauge='" + gauge + '\'' +
                ", countryOrigin='" + countryOrigin + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
