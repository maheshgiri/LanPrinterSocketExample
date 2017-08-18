package developergroup.android.simplesocket;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import developergroup.android.simplesocket.printer.Global;
import developergroup.android.simplesocket.printer.PrinterUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SocketPrinterClientAysn(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    public boolean printLine(String texttoPrint, boolean isBold,int fontsize, int scale ) {
        //if (WorkService.workThread.isConnected()) {
        int charset = 0, codepage = 0;
        String strEnglish = "~!@#$%^&*()_+`[]{}\\|;',./:\"<>?1234567890-=abcdefghijklmnopqrstuvwxyz\n";
        int nFontStyle  = PrinterUtils.FONTSTYLE_NORMAL;

        if(isBold)
            nFontStyle |= PrinterUtils.FONTSTYLE_BOLD;

        String text = "";
        String encoding = "US-ASCII";
        byte[] addBytes = new byte[0];

        Bundle dataCP = new Bundle();
        Bundle dataTextOut = new Bundle();
        Bundle dataWrite = new Bundle();
        Bundle dataAlign = new Bundle();
        Bundle dataRightSpace = new Bundle();
        Bundle dataLineHeight = new Bundle();


        dataCP.putInt(Global.INTPARA1, charset);
        dataCP.putInt(Global.INTPARA2, codepage);

        dataAlign.putInt(Global.INTPARA1, 0);
        dataRightSpace.putInt(Global.INTPARA1, 0);
        dataLineHeight.putInt(Global.INTPARA1, 32);

        Log.d("DEBUG", "printing " + texttoPrint);

        dataTextOut.putString(Global.STRPARA1, texttoPrint);
        dataTextOut.putString(Global.STRPARA2, encoding);
        dataTextOut.putInt(Global.INTPARA1, 0);
        dataTextOut.putInt(Global.INTPARA2, 0);
        dataTextOut.putInt(Global.INTPARA3, scale);
        dataTextOut.putInt(Global.INTPARA4, fontsize);
        dataTextOut.putInt(Global.INTPARA5, nFontStyle);

        dataWrite.putByteArray(Global.BYTESPARA1, addBytes);
        dataWrite.putInt(Global.INTPARA1, 0);
        dataWrite.putInt(Global.INTPARA2, addBytes.length);


            /*WorkService.workThread.handleCmd(
                    Global.CMD_POS_SETCHARSETANDCODEPAGE, dataCP);

            WorkService.workThread.handleCmd(Global.CMD_POS_SALIGN,
                    dataAlign);
            WorkService.workThread.handleCmd(Global.CMD_POS_SETRIGHTSPACE,
                    dataRightSpace);
            WorkService.workThread.handleCmd(Global.CMD_POS_SETLINEHEIGHT,
                    dataLineHeight);*/

       /* WorkService.workThread.handleCmd(Global.CMD_POS_STEXTOUT,
                dataTextOut);*/

        //WorkService.workThread.handleCmd(Global.CMD_POS_WRITE,
        //       dataWrite);

        return true;

        /*} else {
            Toast.makeText(getApplicationContext(),
                    "Please connect the printer!", Toast.LENGTH_SHORT).show();

            return false;
        }*/
    }

}
