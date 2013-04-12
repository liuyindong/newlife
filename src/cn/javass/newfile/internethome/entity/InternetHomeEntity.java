package cn.javass.newfile.internethome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.javass.common.model.AbstractModel;

@Entity
@Table(name = "tbl_internet_home")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class InternetHomeEntity extends AbstractModel
{
	private static final long serialVersionUID = -2860355276260691322L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "new_recommend")
	private int newRecommend;     //推荐的新闻
	
	@Column(name = "movie_recommend")
	private int movieRecommend;   //推荐的视频
	
	@Column(name = "image_recommend")
	private int imgRecommend;	  //推荐的图片
	
	@Column(name = "music_recommend")
	private int musicRecommend;   //推荐的音乐
	
	@Column(name = "home_four_img")
	private int homeFourImg;      //首页轮播图片
	
	@Column(name = "important_new")
	private int importantNew;     //重要的新闻
	
	@Column(name = "buttion_scrll")
	private int buttonScorll;  //底部图片
	
	@JoinColumn(name = "recommend_time")
	private String recommendTime;   //推荐日期

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getNewRecommend()
	{
		return newRecommend;
	}

	public void setNewRecommend(int newRecommend)
	{
		this.newRecommend = newRecommend;
	}

	public int getMovieRecommend()
	{
		return movieRecommend;
	}

	public void setMovieRecommend(int movieRecommend)
	{
		this.movieRecommend = movieRecommend;
	}

	public int getImgRecommend()
	{
		return imgRecommend;
	}

	public void setImgRecommend(int imgRecommend)
	{
		this.imgRecommend = imgRecommend;
	}

	public int getMusicRecommend()
	{
		return musicRecommend;
	}

	public void setMusicRecommend(int musicRecommend)
	{
		this.musicRecommend = musicRecommend;
	}

	public int getHomeFourImg()
	{
		return homeFourImg;
	}

	public void setHomeFourImg(int homeFourImg)
	{
		this.homeFourImg = homeFourImg;
	}

	public int getImportantNew()
	{
		return importantNew;
	}

	public void setImportantNew(int importantNew)
	{
		this.importantNew = importantNew;
	}

	public int getButtonScorll()
	{
		return buttonScorll;
	}

	public void setButtonScorll(int buttonScorll)
	{
		this.buttonScorll = buttonScorll;
	}

	public String getRecommendTime()
	{
		return recommendTime;
	}

	public void setRecommendTime(String recommendTime)
	{
		this.recommendTime = recommendTime;
	}

}
