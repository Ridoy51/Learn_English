package com.example.eng3k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class PartActivity extends AppCompatActivity implements View.OnClickListener{
    private Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    public static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);

        mContext=this.getBaseContext();


        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        c=findViewById(R.id.c);
        d=findViewById(R.id.d);
        e=findViewById(R.id.e);
        f=findViewById(R.id.f);
        g=findViewById(R.id.g);
        h=findViewById(R.id.h);
        i=findViewById(R.id.i);
        j=findViewById(R.id.j);
        k=findViewById(R.id.k);
        l=findViewById(R.id.l);
        m=findViewById(R.id.m);
        n=findViewById(R.id.n);
        o=findViewById(R.id.o);
        p=findViewById(R.id.p);
        q=findViewById(R.id.q);
        r=findViewById(R.id.r);
        s=findViewById(R.id.s);
        t=findViewById(R.id.t);
        u=findViewById(R.id.u);
        v=findViewById(R.id.v);
        w=findViewById(R.id.w);
        x=findViewById(R.id.x);
        y=findViewById(R.id.y);
        z=findViewById(R.id.z);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(PartActivity.this,Utils.class);

        switch (v.getId()) {
            case R.id.a:

                intent.putExtra("word",1);
                startActivity(intent);
                break;
            case R.id.b:

                intent.putExtra("word",2);
                startActivity(intent);
                break;
            case R.id.c:

                intent.putExtra("word",3);
                startActivity(intent);
                break;
            case R.id.d:

                intent.putExtra("word",4);
                startActivity(intent);
                break;
            case R.id.e:

                intent.putExtra("word",5);
                startActivity(intent);
                break;
            case R.id.f:

                intent.putExtra("word",6);
                startActivity(intent);
                break;
            case R.id.g:

                intent.putExtra("word",7);
                startActivity(intent);
                break;
            case R.id.h:

                intent.putExtra("word",8);
                startActivity(intent);
                break;
            case R.id.i:

                intent.putExtra("word",9);
                startActivity(intent);
                break;
            case R.id.j:

                intent.putExtra("word",10);
                startActivity(intent);
                break;
            case R.id.k:

                intent.putExtra("word",11);
                startActivity(intent);
                break;
            case R.id.l:

                intent.putExtra("word",12);
                startActivity(intent);
                break;
            case R.id.m:

                intent.putExtra("word",13);
                startActivity(intent);
                break;
            case R.id.n:

                intent.putExtra("word",14);
                startActivity(intent);
                break;
            case R.id.o:

                intent.putExtra("word",15);
                startActivity(intent);
                break;
            case R.id.p:

                intent.putExtra("word",16);
                startActivity(intent);
                break;
            case R.id.q:

                intent.putExtra("word",17);
                startActivity(intent);
                break;
            case R.id.r:

                intent.putExtra("word",18);
                startActivity(intent);
                break;
            case R.id.s:

                intent.putExtra("word",19);
                startActivity(intent);
                break;
            case R.id.t:

                intent.putExtra("word",20);
                startActivity(intent);
                break;
            case R.id.u:

                intent.putExtra("word",21);
                startActivity(intent);
                break;
            case R.id.v:

                intent.putExtra("word",22);
                startActivity(intent);
                break;
            case R.id.w:

                intent.putExtra("word",23);
                startActivity(intent);
                break;
            case R.id.x:

                intent.putExtra("word",24);
                startActivity(intent);
                break;
            case R.id.y:

                intent.putExtra("word",25);
                startActivity(intent);
                break;
            case R.id.z:

                intent.putExtra("word",26);
                startActivity(intent);
                break;

        }
    }
}