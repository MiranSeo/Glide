package studygroup.udacity.com.study.data;

import java.util.ArrayList;

public class Courses {

    public ArrayList<Course> courses;

    public static class TeaserVideo {

        public String youtube_url;

        @Override
        public String toString() {
            return youtube_url;
        }
    }

    public static class Course {

        public String key;
        public String title;
        public String subtitle;
        public String summary;
        public String image;
        public String homepage;
        public TeaserVideo teaser_video;

        @Override
        public String toString() {
            return String.format("[%s] %s", key, title);
        }
    }
}