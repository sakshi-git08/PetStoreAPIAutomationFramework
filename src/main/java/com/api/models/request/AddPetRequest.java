package com.api.models.request;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPetRequest {

    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;




//    public static class AddRequestBuilder {
//        private Integer id;
//        private Category category;
//        private String name;
//        private List<String> photoUrls;
//        private List<Tag> tags;
//        private String status;
//
//        public AddRequestBuilder id(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public AddRequestBuilder category(Category category) {
//            this.category = category;
//            return this;
//        }
//
//        public AddRequestBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public AddRequestBuilder photoUrls(List<String> photoUrls) {
//            this.photoUrls = photoUrls;
//            return this;
//        }
//
//        public AddRequestBuilder tags(List<Tag> tags) {
//            this.tags = tags;
//            return this;
//        }
//
//        public AddRequestBuilder status(String status) {
//            this.status = status;
//            return this;
//        }
//
//        public AddPetRequest build() {
//            AddPetRequest addPetRequest = new AddPetRequest(id, category, name, photoUrls, tags, status);
//            return addPetRequest;
//        }
//    }
}
