package com.softtanck.qqzone.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softtanck.qqzone.R;
import com.softtanck.qqzone.bean.NormalMsg;
import com.softtanck.qqzone.bean.ZoneBaseMsg;
import com.softtanck.qqzone.link.ClickLink;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 10/27/2015
 */
public class ZoneAdapter extends BaseAdapter {

    private static final int NormalMsg = 1;
    private static final int VoiceMsg = 2;
    private static final int VideoMsg = 3;
    private static final int ImgMsg = 4;

    private List<ZoneBaseMsg> msgs;

    private Context context;

    public ZoneAdapter(List<ZoneBaseMsg> msgs, Context context) {
        this.msgs = msgs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public ZoneBaseMsg getItem(int position) {
        return msgs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int type = msgs.get(position).getMsgType();
        switch (type) {
            case ZoneBaseMsg.NOR_MSG://普通说说
                return NormalMsg;
            case ZoneBaseMsg.IMG_MSG://图片说说
                return ImgMsg;
            case ZoneBaseMsg.VIDEO_MSG://视频说说
                return VideoMsg;
            case ZoneBaseMsg.VOICE_MSG://语音说说
                return VoiceMsg;
            default:
                return -1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;//暂时四种说说,可能还有广告说说
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item, null);
            try {
                holder.circleImageView = (CircleImageView) convertView.findViewById(R.id.iv_head);
                holder.nameView = (TextView) convertView.findViewById(R.id.tv_nick);
                holder.sendTime = (TextView) convertView.findViewById(R.id.tv_time);
                holder.summaryView = (TextView) convertView.findViewById(R.id.tv_summary);
                holder.contentView = (TextView) convertView.findViewById(R.id.tv_content);
                holder.phoneView = (ImageView) convertView.findViewById(R.id.iv_phone);
                holder.phoneName = (TextView) convertView.findViewById(R.id.tv_phone);
                holder.forward = (ImageView) convertView.findViewById(R.id.iv_forward);
                holder.support = (ImageView) convertView.findViewById(R.id.iv_support);
                holder.comment = (ImageView) convertView.findViewById(R.id.iv_comment);
                holder.supportPeople = (ImageView) convertView.findViewById(R.id.iv_support_people);
                holder.supportName = (TextView) convertView.findViewById(R.id.tv_supports);
                holder.readTimes = (ImageView) convertView.findViewById(R.id.iv_readtimes);
                holder.readTimesView = (TextView) convertView.findViewById(R.id.tv_readtimes);
                holder.comments = (TextView) convertView.findViewById(R.id.tv_comments);
            } catch (Exception e) {
                e.printStackTrace();
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int type = getItemViewType(position);
        switch (type) {
            case NormalMsg://普通
                SpannableString spStr = new SpannableString("光辉");
                ClickableSpan clickSpan = new ClickLink("光辉"); //设置超链接
                spStr.setSpan(clickSpan, 0, "光辉".length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                holder.supportName.append(spStr);
                holder.supportName.setMovementMethod(LinkMovementMethod.getInstance());
                break;
            case ImgMsg: // 图片
                break;
            case VoiceMsg: // 语音
                break;
            case VideoMsg://视频
                break;
        }

        return convertView;
    }

    private class ViewHolder {

        CircleImageView circleImageView;//头像
        TextView nameView;//名字
        ImageView vipView;//黄钻
        TextView sendTime;//发送时间
        TextView summaryView;//摘要
        TextView contentView;//说说内容
        ImageView imgView;//图片说说
        ImageView phoneView;//手机
        TextView phoneName;//手机名字
        ImageView forward;//转发
        ImageView support;//赞
        ImageView comment;//评论
        ImageView supportPeople;//赞
        TextView supportName;//赞的名字
        ImageView readTimes;//阅读
        TextView readTimesView;//阅读次数
        TextView comments;//评论内容及回复
    }
}
