package com.example.designer2.moviesapp.model;

import java.util.List;




public class VideosModel {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {

        private VolumeInfoBean volumeInfo;

        public VolumeInfoBean getVolumeInfo() {
            return volumeInfo;
        }


        public static class VolumeInfoBean {

            private String title;
            private String publisher;
            private String publishedDate;
            private ImageLinksBean imageLinks;


            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPublisher() {
                return publisher;
            }

            public void setPublisher(String publisher) {
                this.publisher = publisher;
            }

            public String getPublishedDate() {
                return publishedDate;
            }

            public void setPublishedDate(String publishedDate) {
                this.publishedDate = publishedDate;
            }


            public ImageLinksBean getImageLinks() {
                return imageLinks;
            }

            public void setImageLinks(ImageLinksBean imageLinks) {
                this.imageLinks = imageLinks;
            }


            public static class ImageLinksBean {
                private String smallThumbnail;
                private String thumbnail;

                public String getSmallThumbnail() {
                    return smallThumbnail;
                }

                public void setSmallThumbnail(String smallThumbnail) {
                    this.smallThumbnail = smallThumbnail;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }
            }
        }


    }
}
