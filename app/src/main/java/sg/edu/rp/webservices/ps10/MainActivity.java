package sg.edu.rp.webservices.ps10;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment>al;
    MyFragmentAdapter adapter;
    ViewPager vPager;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);
        btnRead = findViewById(R.id.btnRead);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new frag1());
        al.add(new frag2());
        al.add(new frag3());

        adapter = new MyFragmentAdapter(fm,al);
        vPager.setAdapter(adapter);


        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnRead.getText().toString().equalsIgnoreCase("Read later")){
                    vPager.setVisibility(View.GONE);
                    btnRead.setText("Read now");
                }else{
                    vPager.setVisibility(View.VISIBLE);
                    btnRead.setText("Read later");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch(item.getItemId()){
            case R.id.previous:
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage,true);
                break;
            case R.id.next:
                int nextPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(nextPage,true);
                break;
            case R.id.random:
                Random r = new Random();
                int max = vPager.getChildCount();
                int randomPage = r.nextInt(max);
                vPager.setCurrentItem(randomPage,true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
