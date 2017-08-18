package developergroup.android.simplesocket.printer;

public class ESCCmd {
    public static byte[] DES_SETKEY = new byte[]{31, 31, 0, 8, 0, 1, 1, 1, 1, 1, 1, 1, 1};
    public static byte[] DES_ENCRYPT = new byte[]{31, 31, 1};
    public static byte[] DES_ENCRYPT2 = new byte[]{31, 31, 2};
    public static byte[] ERROR = new byte[1];
    public static byte[] ESC_ALT = new byte[]{27, 64};
    public static byte[] ESC_L = new byte[]{27, 76};
    public static byte[] ESC_CAN = new byte[]{24};
    public static byte[] FF = new byte[]{12};
    public static byte[] ESC_FF = new byte[]{27, 12};
    public static byte[] ESC_S = new byte[]{27, 83};
    public static byte[] GS_P_x_y = new byte[]{29, 80, 0, 0};
    public static byte[] ESC_R_n = new byte[]{27, 82, 0};
    public static byte[] ESC_t_n = new byte[]{27, 116, 0};
    public static byte[] LF = new byte[]{10};
    public static byte[] CR = new byte[]{13};
    public static byte[] ESC_3_n = new byte[]{27, 51, 0};
    public static byte[] ESC_SP_n = new byte[]{27, 32, 0};
    public static byte[] DLE_DC4_n_m_t = new byte[]{16, 20, 1, 0, 1};
    public static byte[] GS_V_m = new byte[]{29, 86, 0};
    public static byte[] GS_V_m_n = new byte[]{29, 86, 66, 0};
    public static byte[] GS_W_nL_nH = new byte[]{29, 87, 118, 2};
    public static byte[] ESC_dollors_nL_nH = new byte[]{27, 36, 0, 0};
    public static byte[] ESC_a_n = new byte[]{27, 97, 0};
    public static byte[] GS_exclamationmark_n = new byte[]{29, 33, 0};
    public static byte[] ESC_M_n = new byte[]{27, 77, 0};
    public static byte[] GS_E_n = new byte[]{27, 69, 0};
    public static byte[] ESC_line_n = new byte[]{27, 45, 0};
    public static byte[] ESC_lbracket_n = new byte[]{27, 123, 0};
    public static byte[] GS_B_n = new byte[]{29, 66, 0};
    public static byte[] ESC_V_n = new byte[]{27, 86, 0};
    public static  byte[] GS_backslash_m = new byte[]{29, 47, 0};
    public static byte[] FS_p_n_m = new byte[]{28, 112, 1, 0};
    public static byte[] GS_H_n = new byte[]{29, 72, 0};
    public static byte[] GS_f_n = new byte[]{29, 102, 0};
    public static byte[] GS_h_n = new byte[]{29, 104, -94};
    public static byte[] GS_w_n = new byte[]{29, 119, 3};
    public static byte[] GS_k_m_n_ = new byte[]{29, 107, 65, 12};
    public static byte[] GS_k_m_v_r_nL_nH = new byte[]{29, 107, 97, 0, 2, 0, 0};
    public static byte[] ESC_W_xL_xH_yL_yH_dxL_dxH_dyL_dyH = new byte[]{27, 87, 0, 0, 0, 0, 72, 2, -80, 4};
    public static byte[] ESC_T_n = new byte[]{27, 84, 0};
    public static byte[] GS_dollors_nL_nH = new byte[]{29, 36, 0, 0};
    public static byte[] GS_backslash_nL_nH = new byte[]{29, 92, 0, 0};
    public static byte[] FS_line_n = new byte[]{28, 45, 0};
    public static byte[] GS_leftbracket_k_pL_pH_cn_67_n = new byte[]{29, 40, 107, 3, 0, 49, 67, 3};
    public static byte[] GS_leftbracket_k_pL_pH_cn_69_n = new byte[]{29, 40, 107, 3, 0, 49, 69, 48};
    public static byte[] GS_leftbracket_k_pL_pH_cn_80_m__d1dk = new byte[]{29, 40, 107, 3, 0, 49, 80, 48};
    public static byte[] GS_leftbracket_k_pL_pH_cn_fn_m = new byte[]{29, 40, 107, 3, 0, 49, 81, 48};

    ESCCmd() {
    }
}
