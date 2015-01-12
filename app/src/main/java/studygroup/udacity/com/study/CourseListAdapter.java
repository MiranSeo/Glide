package studygroup.udacity.com.study;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import studygroup.udacity.com.study.data.Courses;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import studygroup.udacity.com.study.data.CourseDummy;
import studygroup.udacity.com.study.data.Courses;

public class CourseListAdapter extends ArrayAdapter<Courses.Course> {
    private Courses courses;

    public CourseListAdapter(Context context, ArrayList<Courses.Course> courses) {
        super(context, R.layout.course_list_item, R.id.course_title);
    }

    public void setData(Courses courses){

        this.courses = courses;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.course_list_item, parent, false);
        } else {
            view = convertView;
        }


        ImageView iv = (ImageView) view.findViewById(R.id.course_image);
        Glide.with(getContext())
                .fromString()
                .load(courses.courses.get(position).image)
                //adapter에 이미 순서대로 내용 들어가있으므로 해당 위치에 해당하는 것들을 불러와야함.
                .fitCenter()
                .error(R.drawable.ic_launcher)
                .into(iv);

        TextView titleView = (TextView) view.findViewById(R.id.course_title);
        TextView subtitleView = (TextView) view.findViewById(R.id.course_subtitle);

        titleView.setText(courses.courses.get(position).title);
        subtitleView.setText(courses.courses.get(position).subtitle);

        return view;
    }
}
