<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<div>
	<table>
		<thead>
			<tr>
				<th colspan="2">
					<label>{{title}}</label>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="2">
					<iframe src="http://www.youtube.com/embed/{{videoId}}" frameborder="0"></iframe>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>
					업로드 일자
				</td>
				<td>
					{{pDate}}
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="추가하기" onclick="addReview(this);">
					<input type="hidden" value="{{title}}">
					<input type="hidden" value="{{videoId}}">
					<input type="hidden" value="{{pDate}}">
				</td>
			</tr>
		</tfoot>
	</table>
</div>