package com.example.cubatouristguide.ui.cities.photos.models;

import java.util.List;

//CuratedResponseListener
public class CuratedApiResponse {
        public int page;
        public int per_page;
        public List<Photo> photos;
        public String nextPage;

        public CuratedApiResponse(int page, int per_page, List<Photo> photos, String nextPage) {
            this.page = page;
            this.per_page = per_page;
            this.photos = photos;
            this.nextPage = nextPage;
        }



    public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public List<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Photo> photos) {
            this.photos = photos;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
            this.nextPage = nextPage;
        }

}
