package developergroup.android.simplesocket;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import developergroup.android.simplesocket.printer.ESCCmd;
import developergroup.android.simplesocket.printer.Global;
import developergroup.android.simplesocket.printer.Pos;
import developergroup.android.simplesocket.printer.PrinterUtils;

class SocketPrinterClientAysn extends AsyncTask<String, Void, String> {
    Context activity;
    IOException ioException;
    String ESC = "\u001B";
    String GS = "\u001D";
    String InitializePrinter = ESC + "@";
    String BoldOn = ESC + "E" + "\u0001";
    String BoldOff = ESC + "E" + "\0";
    String CENTRE_ALIGN = ESC + "a" + "\u0001";
    String LEFT_ALIGN = ESC + "a" + "\u0000";
    String DoubleOn = GS + "!" + "\u0011";  // 2x sized text (double-high + double-wide)
    String DoubleOff = GS + "!" + "\0";
    String FONT_WIDTH = ESC + "W" + "\u0010";
    String FONT_HEIGHT = ESC + "h" + "\u0010";

    String BILL;


    SocketPrinterClientAysn(Context activity) {
        super();
        this.activity = activity;
        this.ioException = null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        BILL = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentdate = df.format(c.getTime());

        BILL = BILL + CENTRE_ALIGN + DoubleOn + "\nALANKAR REFRESHMENTS";
        /*BILL = BILL + "\u001A";
        BILL = BILL + "\u001B";
        */
        BILL = BILL + CENTRE_ALIGN + "\nNagarjuna nagar Colony" + DoubleOff;
        BILL = BILL + "\n------------------------------------------------";
        BILL = BILL + LEFT_ALIGN + "\nOrder#" + System.currentTimeMillis();
        BILL = BILL + "\nName :" + "Abcdef afafk";
        BILL = BILL + "\nReg. Mob No " + "0000000000";
        BILL = BILL + "\nAddress: Worli,worli,Doordarshan (Worli)\n";
        BILL = BILL + "\n" + DoubleOn + "Order Details:" + DoubleOff;
        BILL = BILL + "\nCHINESE DOSA (2)";
        int startlength = "\nCHINESE DOSA (2)".length();
        int length = 48 - "Rs. 100.0".length();
        while (startlength != length) {
            startlength++;
            BILL = BILL + " ";
        }
        BILL = BILL + "Rs. 100.0"+DoubleOff;

        BILL = BILL + "\n------------------------------------------------";
        BILL = BILL   +"\n\r"+ DoubleOn +"SUBTOTAL";
        startlength = "SUBTOTAL".length();
        length = 24 - "Rs. 100.0".length();
        while (startlength != length) {
            BILL = BILL + ' ';
            startlength++;

        }
        BILL = BILL + "Rs. 100.0"+DoubleOff;
        BILL = BILL + "\n                                ";
        BILL = BILL + "\n                                \n\n\n";


    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        Socket socket;
        try {
            socket = new Socket(
                    "192.168.1.88",
                    9100);
            socket.setSoTimeout(10000);
            OutputStream out = socket.getOutputStream();

            //out.write(esdataToSend.getByt());
            Pos pos = new Pos();
            out.flush();
            //out.write(pos.POS_S_TextOut(BILL, "US-ASCII", 0, 2, 2, PrinterUtils.FONTSTYLE_NORMAL, PrinterUtils.FONTSTYLE_NORMAL));
            out.write(BILL.getBytes());
            //out.write(doubleo.getBytes());
            InputStream in = socket.getInputStream();
            byte buf[] = new byte[1024];
            int nbytes;
            while ((nbytes = in.read(buf)) != -1) {
                sb.append(new String(buf, 0, nbytes));
            }
            socket.close();
        } catch (IOException e) {
            this.ioException = e;
            return e.toString();
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        if (this.ioException != null) {
            Log.e("DEBUG", "onPostExecute: success " + result);
        } else {
            Log.d("DEBUG", "onPostExecute: " + result);
        }

    }
}