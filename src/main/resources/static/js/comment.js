$(function () {
    $(".conLi").hide();
    // $(".conLi li").filter(":lt(1)").show();
    let publish = 0;
    //回复别人评论
    $(".reply button").click(function () {
        let li = $(this).parents(".li").has("form").length;

        let photo = $(this).parents("li").children(".postId").val();
        let replyName = $(this).parents("li").children(".userName2").val();//读取发表评论的用户名
        let replyId = $(this).parents("li").children(".userId").val();//读取发表评论的id

        if (publish == 0 && li == 0) {
            var form = ["<form class=\"form\" method=\"post\" action=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"commentId\" value=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"replyId\" value=\"" + replyId + "\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"replyName\" value=\"" + replyName + "\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"photo\" value=\"\">\n" +
            "                        <input class=\"content\" type=\"text\" name=\"content\" value=\"回复&nbsp;&nbsp;" + replyName + ":\">\n" +
            "                        <button name='submit' onclick='conComment(this)' type=\"button\" class=\"submit btn btn-primary\">发表</button>\n" +
            "                    </form>"];
            $(this).parents(".li").append(form);

            publish = 1;
            var scroll = $(this).parents("li").children(".form").offset().top - 120;
            $("body,html").animate({
                scrollTop: scroll //让body的scrollTop等于pos的top，就实现了滚动
            }, 0);
        } else if (li == 0 && publish == 1) {
            var form = ["<form class=\"form\" method=\"post\" action=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"commentId\" value=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"replyId\" value=\"" + replyId + "\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"replyName\" value=\"" + replyName + "\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"photo\" value=\"\">\n" +
            "                        <input class=\"content\" type=\"text\" name=\"content\" value=\"回复&nbsp;&nbsp;" + replyName + ":\">\n" +
            "                        <button name='submit' onclick='conComment(this)' type=\"button\" class=\"submit btn btn-primary\">发表</button>\n" +
            "                    </form>"];

            $(this).parents(".li").append(form);
            publish = 1;
            var scroll = $(this).parents("li").children(".form").offset().top - 100;
            $("body,html").animate({
                scrollTop: scroll //让body的scrollTop等于pos的top，就实现了滚动
            }, 0);
        } else {

            $(this).parents(".li").children("form").remove();
            publish = 0;
        }
    })

    //回复评论
    $(".conComment2 button").click(function () {
        let li = $(this).parents(".li").has("form").length;

        let photo = $(this).parents("li").children(".postId").val();

        if (publish == 0 && li == 0) {
            var form = ["<form class=\"form\" method=\"post\" action=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"commentId\" value=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"photo\" value=\"\">\n" +
            "                        <input class=\"content\" type=\"text\" name=\"content\" value=\"\">\n" +
            "                        <button name='submit' onclick='conComment(this)' type=\"button\" class=\"submit btn btn-primary\">发表</button>\n" +
            "                    </form>"];
            $(this).parents(".li").append(form);

            publish = 1;
            var scroll = $(this).parents("li").children(".form").offset().top - 120;
            $("body,html").animate({
                scrollTop: scroll //让body的scrollTop等于pos的top，就实现了滚动
            }, 0);
        } else if (li == 0 && publish == 1) {
            var form = ["<form class=\"form\" method=\"post\" action=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"commentId\" value=\"\">\n" +
            "                        <input type=\"text\" hidden=\"hidden\" name=\"photo\" value=\"\">\n" +
            "                        <input class=\"content\" type=\"text\" name=\"content\" value=\"\">\n" +
            "                        <button name='submit' onclick='conComment(this)' type=\"button\" class=\"submit btn btn-primary\">发表</button>\n" +
            "                    </form>"];

            $(this).parents(".li").append(form);
            publish = 1;
            var scroll = $(this).parents("li").children(".form").offset().top - 100;
            $("body,html").animate({
                scrollTop: scroll //让body的scrollTop等于pos的top，就实现了滚动
            }, 0);
        } else {

            $(this).parents(".li").children("form").remove();
            publish = 0;
        }
    })

    $(".delete").click(function () {
        let id = $(this).parents(".li").children(".id").val();

        let del=confirm("是否删除评论");
        if (del==true){
            $.ajax({
                url:"deleteComment",
                data:{id:id},
                type:"post",
                success:function (message) {
                    alert(message)
                    window.location.reload();
                },
                error:function (message) {
                    alert(message)
                }
            })
        }
    })

    $(".submit").click(function () {
        alert("ds")
    })
    //发表评论
    $("#submitComment").click(function () {

        let content = $(".comment").val();
        if (content == "") {
            return false;
        }
        $.ajax({
            url: "comment",
            data: {content: content},
            type: "post",
            success: function (comment) {
                if (comment.commentId == "-1") {
                    alert(comment.content)
                } else {
                    alert("评论成功！")
                    window.location.reload();
                    /*var time = transformTime(comment.createDate);

                    $(".commentPage").append(
                        "<li class=\"li\" th:each=\"comment:${commentList}\">\n" +
                        "                    <input type=\"text\" class=\"id\" name=\"id\" value=\"" + comment.id + "\" hidden>\n" +
                        "                    <input type=\"text\" class=\"commentId\" name=\"commentId\" value=\"" + comment.commentId + "\" hidden>\n" +
                        "                    <input type=\"text\" class=\"postId\" name=\"postId\" value=\"" + comment.postId + "\" hidden>\n" +
                        "                    <input type=\"text\" class=\"userId\" name=\"userId\" value=\"" + comment.userId + "\" hidden>\n" +
                        "                    <input type=\"text\" class=\"replyId\" name=\"replyId\" value=\"" + comment.replyId + "\" hidden>\n" +
                        "                    <input type=\"text\" class=\"userName2\" name=\"userName\" value=\"" + comment.userName + "\" hidden>\n" +
                        "                    <input type=\"text\" class=\"commentCon\" name=\"commentCon\" value=\"" + comment.commentCon + "\" hidden>\n" +
                        "                    <img class=\"photo\" src=\"images/" + comment.photo + "\">\n" +
                        "                    <p class=\"userName\"><a href=\"#\">" + comment.userName + "</a><span class=\"createDate\">" + time + "</span></p>\n" +
                        "                    <p class=\"content\" ><span>" + comment.content + "</span><a class=\"commentSize\" href=\"javascript:void(0)\">更多<span class=\"commentSize2\">" + (comment.commentSize - 1) + "</span>条评论</a> </p>\n" +
                        "                    <p class=\"gives\">\n" +
                        "                        <img class=\"star\" src=\"images/star.png\">\n" +
                        "                        <span class=\"star2\" >" + comment.star + "</span>\n" +
                        "                        <input class=\"whetherStar\" type=\"hidden\" value=\"false\" >\n" +
                        "                    </p>\n" +
                        "                    <p class=\"reply\"><button  type=\"button\" class=\"btn btn-info\">回复</button></p>\n" +
                        "                    <ul class=\"conLi\">\n" +
                        "                    </ul>\n" +
                        "                    <div>\n" +
                        "                        <p class=\"conComment2\"><button type=\"button\" class=\"btn btn-info\">我要评论</button></p>\n" +
                        "                    </div>\n" +
                        "\n" +
                        "                </li>");*/

                }
            },
            error: function (message) {
                alert(message)
            }
        })
    })
    //显示/关闭子评论
    $(".commentSize").click(function () {
        if ($(this).parents(".li").children(".conLi").is(":hidden")) {
            $(this).parents(".li").children(".conLi").show();
        } else {
            $(this).parents(".li").children(".conLi").hide();
        }
    })

    //点赞
    $(".star").click(function () {
        let id = $(this).parents(".li").children(".id").val();
        let commentId = $(this).parents("li").children(".commentId").val();
        let commentCon = $(this).parents("li").children(".commentCon").val();
        let star = $(this);
        let whetherStar = star.parent().children(".whetherStar").val();

        $.ajax({
            url: "star",
            data: {id: id, commentId: commentId, commentCon: commentCon, whetherStar: whetherStar},
            type: "post",
            success: function (message) {

                let d = star.next().text();

                if (whetherStar == "false") {
                    star.attr("src", "images/give.png");
                    star.parent().children(".whetherStar").val("true");
                    star.next().text(parseInt(d) + 1);
                } else {
                    star.attr("src", "images/star.png");
                    star.parent().children(".whetherStar").val("false");
                    star.next().text(parseInt(d) - 1);
                }

            },
            error: function (message) {
                alert(message)
            }
        })
    })
})

function transformTime(timestamp = +new Date()) {
    if (timestamp) {
        var time = new Date(timestamp);
        var y = time.getFullYear(); //getFullYear方法以四位数字返回年份
        var M = time.getMonth() + 1; // getMonth方法从 Date 对象返回月份 (0 ~ 11)，返回结果需要手动加一

        var d = time.getDate(); // getDate方法从 Date 对象返回一个月中的某一天 (1 ~ 31)
        var h = time.getHours(); // getHours方法返回 Date 对象的小时 (0 ~ 23)
        var m = time.getMinutes(); // getMinutes方法返回 Date 对象的分钟 (0 ~ 59)
        var s = time.getSeconds(); // getSeconds方法返回 Date 对象的秒数 (0 ~ 59)
        return y + '-' + M + '-' + d + ' ' + h + ':' + m + ':' + s;
    } else {
        return '';
    }
}

// 回复评论
function conComment(event) {
    let id = $(event).parents(".li").children(".id").val();
    let replyName = $(event).parents(".form").children("input[name='replyName']").val();
    let replyId = $(event).parents(".form").children("input[name='replyId']").val();
    let content = $(event).parents(".form").children("input[name='content']").val();
    let conComment = $(event).parents(".li").children(".conLi");

    if (content.length == 0 || content == null || content == undefined) {
        return false;
    }
    $.ajax({
        url: "conComment",
        data: {id: id, replyName: replyName, replyId: replyId, content: content},
        type: "post",
        success: function (comment) {

            var time = transformTime(comment.createDate);

            if (comment.commentId == "-1") {
                alert(comment.content)
            } else {
                alert("评论成功！")
                window.location.reload();
            }
        },
        error: function (message) {
            alert(message)
        }
    })

}