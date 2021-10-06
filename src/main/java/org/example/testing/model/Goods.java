package org.example.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
@JsonIgnoreProperties
public class Goods {

    String ok;

    Good[] goods;

    public Goods() {
    }

//    public Goods(String ok, Good[] goods) {
//        this.ok = ok;
//        this.goods = goods;
//    }
//
    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public Good[] getGoods() {
        return goods;
    }

    public void setGoods(Good[] goods) {
        this.goods = goods;
    }

  public static class Good {
        int id;
        String name;
        String category;
        long timestamp;
        double price;

       public Good() {
       }

//       public Good(int id, String name, String category, long timestamp, double price) {
//           this.id = id;
//           this.name = name;
//           this.category = category;
//           this.timestamp = timestamp;
//           this.price = price;
//       }
//
       public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Good{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", timestamp=" + timestamp +
                    ", price=" + price +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "ok='" + ok + '\'' +
                ", goods=" + Arrays.toString(goods) +
                '}';
    }
}
