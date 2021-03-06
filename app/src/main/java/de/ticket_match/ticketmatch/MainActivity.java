package de.ticket_match.ticketmatch;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        ((EditText)findViewById(R.id.login_mail)).setText("");
        ((EditText)findViewById(R.id.login_password)).setText("");
        super.onPause();
    }
/*public void btn_tm_logo(View view) {

        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.change_password:
                        ChangePasswordDialog cdp = new ChangePasswordDialog();
                        cdp.show(getFragmentManager(), "cdp");
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

    }*/

    public void btn_login (View view){

        String email = ((EditText)findViewById(R.id.login_mail)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_password)).getText().toString();

        if(email.equals("") | password.equals("")){
            Toast.makeText(getApplicationContext(),"Please fill out the requiered information!",Toast.LENGTH_SHORT).show();
        } else if(!email.contains("@")) {
            Toast.makeText(getApplicationContext(), "Please provide an email adress!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),email+password, Toast.LENGTH_SHORT).show();
            Intent myprofile =  new Intent(this, MyProfile.class);
            startActivity(myprofile);
        }



    }

    public void tv_forgot_account(View view){

        Intent forgotAccount =  new Intent(this, ForgotAccount.class);
        startActivity(forgotAccount);


    }

    public void btn_activity_register(View view){

        Intent register =  new Intent(this, Register.class);
        startActivity(register);

    }

    public void btn_profile(View view) {
        Toast.makeText(getApplicationContext(),"btn_profile",Toast.LENGTH_SHORT).show();
    }

    public void btn_message(View view) {
        Toast.makeText(getApplicationContext(),"btn_message",Toast.LENGTH_SHORT).show();
    }

    public void btn_ticketoffer(View view) {
        Toast.makeText(getApplicationContext(),"btn_ticketoffer",Toast.LENGTH_SHORT).show();
    }

    public void btn_search(View view) {
        Toast.makeText(getApplicationContext(),"btn_search",Toast.LENGTH_SHORT).show();
    }

    public void btn_makematch(View view) {
        Toast.makeText(getApplicationContext(),"btn_makematch",Toast.LENGTH_SHORT).show();
    }


    /*public static class ChangePasswordDialog extends DialogFragment{
        public Dialog onCreateDialog (Bundle savedInstanceState){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.dialog_change_password, null));

            builder.setPositiveButton("Change", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id ){
                    Toast.makeText(getActivity(),"Change Password",Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id ){
                    dialog.cancel();

                }
            });
            return builder.create();
        }
    }*/

}
