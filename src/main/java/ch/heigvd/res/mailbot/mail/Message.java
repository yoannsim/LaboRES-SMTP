/**
 * Sources :
 * https://www.youtube.com/watch?v=OrSdRCt_6YQ&list=PLfKkysTy70Qa1IYbV9Xndojc7L-T4keF-&index=22
 */
package ch.heigvd.res.mailbot.mail;

public class Message {
    private String from;
    private String[] to = new String[0];
    private String subject;
    private String data;

    public String getFrom(){
        return from;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public String[] getTo(){
        return to;
    }

    public void setTo(String[] to){
        this.to = to;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }
}
