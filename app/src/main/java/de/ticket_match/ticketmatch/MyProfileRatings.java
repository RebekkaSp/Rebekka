package de.ticket_match.ticketmatch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyProfileRatings extends AppCompatActivity {

    ArrayList<String> listitems_ratings = new ArrayList<String>(0);
    ArrayList<String> listitems_rating_text = new ArrayList<String>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_ratings);

        listitems_ratings.add("3.5");
        listitems_rating_text.add("Nils Z.|12.05.2016|Cinema");
        listitems_ratings.add("1");
        listitems_rating_text.add("Nils Z.|12.05.2016|Pick Nick");

        ((ListView) findViewById(R.id.myprofile_ratings)).setAdapter(new CustomAdapter(this, listitems_ratings, listitems_rating_text));
    }

    public static class CustomAdapter extends BaseAdapter {
        ArrayList<String> rating;
        ArrayList<String> rating_text;
        Context context;
        private static LayoutInflater inflater=null;

        public CustomAdapter(MyProfileRatings mainActivity, ArrayList<String> rating, ArrayList<String> rating_text) {
            this.rating = rating;
            this.rating_text = rating_text;
            context=mainActivity;
            inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return rating.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View rowView = inflater.inflate(R.layout.listitem_ratings, null);
            String text = rating_text.get(position);
            text = text.substring(0, text.indexOf("|")) + "\n" + text.substring(text.indexOf("|")+1,text.indexOf("|",text.indexOf("|")+1)) + "\n" + text.substring(text.indexOf("|",text.indexOf("|")+1)+1,text.length());
            ((RatingBar)rowView.findViewById(R.id.listitem_rating_stars)).setRating(new Float(rating.get(position)));
            ((TextView) rowView.findViewById(R.id.listitem_rating_text)).setText(text);
            return rowView;
        }

    }

    public void btn_tm_logo(View view) {

        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.change_password:
                        //ChangePasswordDialog cdp = new ChangePasswordDialog();
                        //cdp.show(getFragmentManager(), "cdp");
                        Intent changepassword =  new Intent(getApplicationContext(), ChangePassword.class);
                        startActivity(changepassword);
                        return true;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(),"logout",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popup.show();

    }

    public void btn_profile(View view) {
        Intent myprofile = new Intent(this, MyProfile.class);
        startActivity(myprofile);
    }

    public void btn_message(View view) {
        Intent message = new Intent(this, Message_Overview.class);
        startActivity(message);
    }

    public void btn_ticketoffer(View view) {
        Toast.makeText(getApplicationContext(),"btn_ticketoffer",Toast.LENGTH_SHORT).show();
    }

    public void btn_search(View view) {
        Toast.makeText(getApplicationContext(),"btn_search",Toast.LENGTH_SHORT).show();
        Intent inte = new Intent(this, ForeignProfile.class);
        startActivity(inte);
    }

    public void btn_makematch(View view) {
        Toast.makeText(getApplicationContext(),"btn_makematch",Toast.LENGTH_SHORT).show();
    }
}
