/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.jona.instalikeviewer;

public final class R {
    public static final class attr {
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int border=0x7f010000;
        /** <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int border_color=0x7f010002;
        /** <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int border_width=0x7f010001;
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int circularImageViewStyle=0x7f010004;
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int shadow=0x7f010003;
    }
    public static final class color {
        public static final int Black=0x7f040002;
        public static final int Blue=0x7f040000;
        public static final int Gray=0x7f040003;
        public static final int GrayHot=0x7f040005;
        public static final int GrayLight=0x7f040004;
        public static final int White=0x7f040001;
    }
    public static final class dimen {
        /**  Default screen margins, per the Android Design guidelines. 

         Example customization of dimensions originally defined in res/values/dimens.xml
         (such as screen margins) for screens with more than 820dp of available width. This
         would include 7" and 10" devices in landscape (~960dp and ~1280dp respectively).
    
         */
        public static final int activity_horizontal_margin=0x7f050000;
        public static final int activity_vertical_margin=0x7f050001;
    }
    public static final class drawable {
        public static final int ic_image_loading=0x7f020000;
        public static final int ic_launcher=0x7f020001;
        public static final int image_placeholder=0x7f020002;
    }
    public static final class id {
        public static final int action_settings=0x7f090009;
        public static final int imgPhoto=0x7f090002;
        public static final int imgProfile=0x7f090003;
        public static final int lvPhotos=0x7f090001;
        public static final int swipeContainer=0x7f090000;
        public static final int tVComments=0x7f090006;
        public static final int tvCaption=0x7f090004;
        public static final int tvLikes=0x7f090008;
        public static final int tvTimeCreated=0x7f090007;
        public static final int tvUsername=0x7f090005;
    }
    public static final class layout {
        public static final int activity_photos=0x7f030000;
        public static final int item_photo=0x7f030001;
    }
    public static final class menu {
        public static final int photos=0x7f080000;
    }
    public static final class string {
        public static final int action_settings=0x7f060001;
        public static final int app_name=0x7f060000;
        public static final int caption_default_text=0x7f060003;
        public static final int label_comments=0x7f060006;
        public static final int label_created=0x7f060005;
        public static final int label_likes=0x7f060004;
        public static final int label_location=0x7f060008;
        public static final int label_username=0x7f060007;
        public static final int popular_photos_caption=0x7f060002;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.
    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f070000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f070001;
    }
    public static final class styleable {
        /** Attributes that can be used with a CircularImageView.
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #CircularImageView_border com.jona.instalikeviewer:border}</code></td><td></td></tr>
           <tr><td><code>{@link #CircularImageView_border_color com.jona.instalikeviewer:border_color}</code></td><td></td></tr>
           <tr><td><code>{@link #CircularImageView_border_width com.jona.instalikeviewer:border_width}</code></td><td></td></tr>
           <tr><td><code>{@link #CircularImageView_shadow com.jona.instalikeviewer:shadow}</code></td><td></td></tr>
           </table>
           @see #CircularImageView_border
           @see #CircularImageView_border_color
           @see #CircularImageView_border_width
           @see #CircularImageView_shadow
         */
        public static final int[] CircularImageView = {
            0x7f010000, 0x7f010001, 0x7f010002, 0x7f010003
        };
        /**
          <p>This symbol is the offset where the {@link com.jona.instalikeviewer.R.attr#border}
          attribute's value can be found in the {@link #CircularImageView} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.jona.instalikeviewer:border
        */
        public static final int CircularImageView_border = 0;
        /**
          <p>This symbol is the offset where the {@link com.jona.instalikeviewer.R.attr#border_color}
          attribute's value can be found in the {@link #CircularImageView} array.


          <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.jona.instalikeviewer:border_color
        */
        public static final int CircularImageView_border_color = 2;
        /**
          <p>This symbol is the offset where the {@link com.jona.instalikeviewer.R.attr#border_width}
          attribute's value can be found in the {@link #CircularImageView} array.


          <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.jona.instalikeviewer:border_width
        */
        public static final int CircularImageView_border_width = 1;
        /**
          <p>This symbol is the offset where the {@link com.jona.instalikeviewer.R.attr#shadow}
          attribute's value can be found in the {@link #CircularImageView} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.jona.instalikeviewer:shadow
        */
        public static final int CircularImageView_shadow = 3;
        /** Attributes that can be used with a Theme.
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #Theme_circularImageViewStyle com.jona.instalikeviewer:circularImageViewStyle}</code></td><td></td></tr>
           </table>
           @see #Theme_circularImageViewStyle
         */
        public static final int[] Theme = {
            0x7f010004
        };
        /**
          <p>This symbol is the offset where the {@link com.jona.instalikeviewer.R.attr#circularImageViewStyle}
          attribute's value can be found in the {@link #Theme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name com.jona.instalikeviewer:circularImageViewStyle
        */
        public static final int Theme_circularImageViewStyle = 0;
    };
}
