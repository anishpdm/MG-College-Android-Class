package com.example.mgcollegeapp;



    public class CourseModel {

        public String CourseTitle;
        public String CourseDesc;
        public String CourseDuration;
        public String CourseDate;
        public String CourseVenue;

        public CourseModel() {
        }

        public CourseModel(String courseTitle, String courseDesc, String courseDuration, String courseDate, String courseVenue) {
            CourseTitle = courseTitle;
            CourseDesc = courseDesc;
            CourseDuration = courseDuration;
            CourseDate = courseDate;
            CourseVenue = courseVenue;
        }

        public String getCourseTitle() {
            return CourseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            CourseTitle = courseTitle;
        }

        public String getCourseDesc() {
            return CourseDesc;
        }

        public void setCourseDesc(String courseDesc) {
            CourseDesc = courseDesc;
        }

        public String getCourseDuration() {
            return CourseDuration;
        }

        public void setCourseDuration(String courseDuration) {
            CourseDuration = courseDuration;
        }

        public String getCourseDate() {
            return CourseDate;
        }

        public void setCourseDate(String courseDate) {
            CourseDate = courseDate;
        }

        public String getCourseVenue() {
            return CourseVenue;
        }

        public void setCourseVenue(String courseVenue) {
            CourseVenue = courseVenue;
        }


}
