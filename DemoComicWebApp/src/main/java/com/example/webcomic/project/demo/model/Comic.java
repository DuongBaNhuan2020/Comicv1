package com.example.webcomic.project.demo.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String author;
	private String nation;
	private String category;
	private Calendar date_created;
	private String cover_image;
	private String description;
	@OneToMany(mappedBy = "comic", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Chapter> listChapter;
	@OneToMany(mappedBy = "comic", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Comment> listComment;
	@OneToMany(mappedBy = "comic", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Likes> listLikes;
	
	public Comic() {
		super();
	}

		

	public Comic(long id, String name, String author, String nation, String category, Calendar date_created,
			String cover_image, String description, List<Chapter> listChapter, List<Comment> listComment,
			List<Likes> listLikes) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.nation = nation;
		this.category = category;
		this.date_created = date_created;
		this.cover_image = cover_image;
		this.description = description;
		this.listChapter = listChapter;
		this.listComment = listComment;
		this.listLikes = listLikes;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Calendar getDate_created() {
		return date_created;
	}

	public void setDate_created(Calendar date_created) {
		this.date_created = date_created;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Chapter> getListChapter() {
		return listChapter;
	}

	public void setListChapter(List<Chapter> listChapter) {
		this.listChapter = listChapter;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public List<Likes> getListLikes() {
		return listLikes;
	}

	public void setListLikes(List<Likes> listLikes) {
		this.listLikes = listLikes;
	}
	//chapter
	public void addChapter(Chapter chater) {
		this.listChapter.add(chater);
	}
	public void updateChapter(long id, Chapter chapter) {
		
		for(Chapter c:listChapter) {
			if(c.getId()==id) {
				int index=this.listChapter.indexOf(c);
				this.listChapter.set(index, chapter);
				System.out.println("co vao day");
				System.out.println(c.getContent());
			}
		}
	}
	public void deleteChapter(long id) {
		for(Chapter c:listChapter) {
			if(c.getId()==id) {
				this.listChapter.remove(c);
			}
		}
	}
	//comment
	public void addComment(Comment comment) {
		this.listComment.add(comment);
	}
	public void updateComment(long id, Comment comment) {
		
		for(Comment c:listComment) {
			if(c.getId()==id) {
				int index=this.listComment.indexOf(c);
				this.listComment.set(index, comment);
			}
		}
	}
	public void deleteComment(long id) {
		for(Comment c:listComment) {
			if(c.getId()==id) {
				this.listComment.remove(c);
			}
		}
	}
	//likes
	public void addLikes(Likes likes) {
		this.listLikes.add(likes);
	}
	public void updateLikes(long id, Likes likes) {
		
		for(Likes l:listLikes) {
			if(l.getId()==id) {
				int index=this.listLikes.indexOf(l);
				this.listLikes.set(index, likes);
			}
		}
	}
	public void deleteLikes(long id) {
		for(Likes l:listLikes) {
			if(l.getId()==id) {
				this.listLikes.remove(l);
			}
		}
	}
}
