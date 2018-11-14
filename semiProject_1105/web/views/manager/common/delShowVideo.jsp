<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<div class="showDiv">
	<table border=1>
		<thead>
			<tr>
				<th>영화명</th>
				<th>{{mCode}}</th>
			</tr>
			<tr>
				<th colspan="2">
					<iframe src="http://www.youtube.com/embed/{{videoId}}" frameborder="0"></iframe>
				</th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td>리뷰어명</td>
				<td>{{rvrCode}}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>
					업로드 일자
				</td>
				<td>
					{{uploadDate}}
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="삭제하기" onclick="delReview(this);">
					<input type="hidden" value="{{videoId}}">
				</td>
			</tr>
		</tfoot>
	</table>
</div>