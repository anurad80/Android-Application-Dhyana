package com.example.android.dhyanaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * This app displays a menu for how-to meditate, benefits and links of meditation.
 * There is a button for the settings related to meditation. A help menu is also provided
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assert getSupportActionBar() != null;
        getSupportActionBar().setLogo(R.drawable.logo);
    }

    /**
     * This method is called when the 'Benefits' button is clicked.
     */
    public void Benefits(View v) {
        Intent intent = new Intent(this, BenefitsActivity.class);
        startActivity(intent);
    }

    /**
     * This method is called when the 'meditate now' button is clicked.
     */
    public void MeditateNow(View v) {
        Intent intent = new Intent(this, SettingsDoneActivity.class);
        startActivity(intent);
    }

    /**
     * This method creates a menu bar for the app.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This method is called when the menu options are clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.howto_id:
                Intent intent1 = new Intent(this, HowtoActivity.class);
                startActivity(intent1);
                break;
            case R.id.benefits_id:
                Intent intent2 = new Intent(this, BenefitsActivity.class);
                startActivity(intent2);
                break;
            case R.id.help_id:
                Intent intent3 = new Intent(this, HelpActivity.class);
                startActivity(intent3);
                break;
            case R.id.links_id:
                Intent intent4 = new Intent(this, LinksActivity.class);
                startActivity(intent4);
                break;
            case R.id.share_id:
                Intent intent_share = new Intent(Intent.ACTION_SEND);
                intent_share.setType("text/plain");
                intent_share.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                intent_share.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_body));
                startActivity(Intent.createChooser(intent_share, getString(R.string.choose_one)));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
