package com.example.fragments2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class ListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        Button button=view.findViewById(R.id.update_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return view;
    }

    //описываем интерфейс-слушатель сигналов от фрагмента, он нужен для того, чтобы
    //фрагмент не зависил от конкретной активити и мог использваться как самостоятельная еденица
    /*
    фрагменты созданы для того, чтобы меньше писать кода - подразумевается, что каждый фрагмент может быть
    использован неоднократно в разных местах. И код надо писать так, чтобы он работал не только в ситуации,
    когда на странице есть оба фрагмента, но и в ситуации, когда на странице есть только один фрагмент.
    А если обращаться напрямую из одного в другой, будет exception.
     */
    interface OnFragmentInteractionListener{
        void onFragmentInteraction(String link);
    }

    //данный метод вызывается при присоединении фрагмента к активности
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            //вытаскиваем из контекста (т.е. активити) наш объект интерфейса, и если
            //активность не реализует метод интерфейса обработается инсключение

            mListener=(OnFragmentInteractionListener)context;} //теперь в объекте mListener хранится экземпляр интерфейса из активити
        catch (ClassCastException e){                           //и при вызове метода OnFragmentInteraction выполниться то, что прописано в activity
            throw new ClassCastException(context.toString()+" должен реализовывать интерфейс OnFragmentInteractionListener");

        }
    }
    public void updateDetail(){
        //генерируем некоторые данные
        String curDate= new Date().toString();
        //посылаем данные Activity
        mListener.onFragmentInteraction(curDate); //вызов метода интефейса, т.е. произошел сигнал о том, что фрагмент желает что то отправить activity
    }
}
