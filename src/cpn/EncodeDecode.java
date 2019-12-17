package cpn;

import comp.FlowTable;
import comp.ForwardDevice;
import comp.NetDevice;

import javax.swing.*;
import java.io.*;

/** Class of static methods to convert objects to ByteStream compatible
 * representations and back again
 * @author Guy Gallasch
 * @version 0.6
 */

public class EncodeDecode
{
/** Method to convert a string to a ByteArrayInputStream
 * @param toConvert The string to convert
 * @return A ByteArrayInputStream representing the string
 */
    public static ByteArrayInputStream encodeString(String toConvert)
    {
        return new ByteArrayInputStream(toConvert.getBytes());
    }

    public static  ByteArrayInputStream encodeInteger(Integer toConvert) {
        return new ByteArrayInputStream(toConvert.toString().getBytes());

    }

/** Method to convert a ByteArrayOutputStream to a string
 * @param toConvert A ByteArrayOutputStream to convert to string
 * @return String decoded from the ByteArrayOutputStream
 */
    public static String decodeString(ByteArrayOutputStream toConvert)
    {
        return toConvert.toString();
    }
/** Method to convert a ByteArrayOutputStream to an integer
 * @param toConvert A ByteArrayOutputStream to convert to integer
 * @return Integer decoded from the ByteArrayOutputStream
 */
    public static Integer decodeInteger(ByteArrayOutputStream toConvert) { return Integer.parseInt(toConvert.toString()); }

    public static NetDevice decodeNetDevice(ByteArrayOutputStream toConvert) {
        String[] arrayTemp = toConvert.toString().split(",");
        return new NetDevice(arrayTemp[0], arrayTemp[1], arrayTemp[2], arrayTemp[3]);
    }

    public static ForwardDevice decodeForwardDevice(ByteArrayOutputStream toConvert) {
        String[] arrayTemp = toConvert.toString().split("@", 2);
        Integer intTemp = Integer.parseInt(arrayTemp[0]);
        String[] rightArrayTemp = arrayTemp[1].split("#");
        FlowTable toFlowTable = new FlowTable();
        for(String strTmp : rightArrayTemp)
            toFlowTable.insert(strTmp);
        return new ForwardDevice(intTemp, toFlowTable);
    }
}

