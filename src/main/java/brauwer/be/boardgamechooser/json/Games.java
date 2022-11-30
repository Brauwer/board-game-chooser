/* Copyright 2022 freecodeformat.com */
package brauwer.be.boardgamechooser.json;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
/* Time: 2022-05-11 14:43:46 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Games {

    private String id;
    private String handle;
    private String url;
    @SerializedName("edit_url")
    private String editUrl;
    private String name;
    private String price;
    @SerializedName("price_ca")
    private String priceCa;
    @SerializedName("price_uk")
    private String priceUk;
    @SerializedName("price_au")
    private String priceAu;
    private String msrp;
    private List<Msrps> msrps;
    private String discount;
    @SerializedName("year_published")
    private int yearPublished;
    @SerializedName("min_players")
    private int minPlayers;
    @SerializedName("max_players")
    private int maxPlayers;
    @SerializedName("min_playtime")
    private int minPlaytime;
    @SerializedName("max_playtime")
    private int maxPlaytime;
    @SerializedName("min_age")
    private int minAge;
    private String description;
    private String commentary;
    private String faq;
    @SerializedName("thumb_url")
    private String thumbUrl;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("matches_specs")
    private String matchesSpecs;
    @JsonIgnore
    private List<Specs> specs;
    private List<Mechanics> mechanics;
    private List<Categories> categories;
    private List<Publishers> publishers;
    private List<Designers> designers;
    @SerializedName("primary_publisher")
    private PrimaryPublisher primaryPublisher;
    @SerializedName("primary_designer")
    private PrimaryDesigner primaryDesigner;
    private List<String> developers;
    @SerializedName("related_to")
    private List<Games> relatedTo;
    @SerializedName("related_as")
    private List<String> relatedAs;
    private List<String> artists;
    private List<String> names;
    @SerializedName("rules_url")
    private String rulesUrl;
    @SerializedName("amazon_rank")
    private int amazonRank;
    @SerializedName("official_url")
    private String officialUrl;
    @SerializedName("comment_count")
    private int commentCount;
    @SerializedName("num_user_ratings")
    private int numUserRatings;
    @SerializedName("average_user_rating")
    private String averageUserRating;
    @SerializedName("weight_amount")
    private String weightAmount;
    @SerializedName("weight_units")
    private String weightUnits;
    @SerializedName("size_height")
    private String sizeHeight;
    @SerializedName("size_depth")
    private String sizeDepth;
    @SerializedName("size_units")
    private String sizeUnits;
    @SerializedName("historical_low_prices")
    private List<HistoricalLowPrices> historicalLowPrices;
    private boolean active;
    @SerializedName("num_user_complexity_votes")
    private int numUserComplexityVotes;
    @SerializedName("average_learning_complexity")
    private String averageLearningComplexity;
    @SerializedName("average_strategy_complexity")
    private String averageStrategyComplexity;
    private int visits;
    private int lists;
    private int mentions;
    private int links;
    private int plays;
    private int rank;
    private String type;
    private String sku;
    private String upc;
    private String isbn;
    @JsonProperty("video_links")
    private List<String> videoLinks;
    @SerializedName("availability_status")
    private String availabilityStatus;
    @SerializedName("num_distributors")
    private int numDistributors;
    @SerializedName("trending_rank")
    private int trendingRank;
    @SerializedName("listing_clicks")
    private int listingClicks;
    @SerializedName("is_historical_low")
    private boolean isHistoricalLow;
    private List<String> skus;
    @SerializedName("sku_objects")
    private List<SkuObjects> skuObjects;
    private String players;
    private String playtime;
    @SerializedName("msrp_text")
    private String msrpText;
    @SerializedName("price_text")
    private String priceText;
    private List<String> tags;
    private Images images;
    @SerializedName("description_preview")
    private String descriptionPreview;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getHandle() {
        return handle;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public String getEditUrl() {
        return editUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPriceCa(String priceCa) {
        this.priceCa = priceCa;
    }

    public String getPriceCa() {
        return priceCa;
    }

    public void setPriceUk(String priceUk) {
        this.priceUk = priceUk;
    }

    public String getPriceUk() {
        return priceUk;
    }

    public void setPriceAu(String priceAu) {
        this.priceAu = priceAu;
    }

    public String getPriceAu() {
        return priceAu;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrps(List<Msrps> msrps) {
        this.msrps = msrps;
    }

    public List<Msrps> getMsrps() {
        return msrps;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMinPlaytime(int minPlaytime) {
        this.minPlaytime = minPlaytime;
    }

    public int getMinPlaytime() {
        return minPlaytime;
    }

    public void setMaxPlaytime(int maxPlaytime) {
        this.maxPlaytime = maxPlaytime;
    }

    public int getMaxPlaytime() {
        return maxPlaytime;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }

    public String getFaq() {
        return faq;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setMatchesSpecs(String matchesSpecs) {
        this.matchesSpecs = matchesSpecs;
    }

    public String getMatchesSpecs() {
        return matchesSpecs;
    }

    public void setSpecs(List<Specs> specs) {
        this.specs = specs;
    }

    public List<Specs> getSpecs() {
        return specs;
    }

    public void setMechanics(List<Mechanics> mechanics) {
        this.mechanics = mechanics;
    }

    public List<Mechanics> getMechanics() {
        return mechanics;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setPublishers(List<Publishers> publishers) {
        this.publishers = publishers;
    }

    public List<Publishers> getPublishers() {
        return publishers;
    }

    public void setDesigners(List<Designers> designers) {
        this.designers = designers;
    }

    public List<Designers> getDesigners() {
        return designers;
    }

    public void setPrimaryPublisher(PrimaryPublisher primaryPublisher) {
        this.primaryPublisher = primaryPublisher;
    }

    public PrimaryPublisher getPrimaryPublisher() {
        return primaryPublisher;
    }

    public void setPrimaryDesigner(PrimaryDesigner primaryDesigner) {
        this.primaryDesigner = primaryDesigner;
    }

    public PrimaryDesigner getPrimaryDesigner() {
        return primaryDesigner;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    public List<String> getDevelopers() {
        return developers;
    }

    public void setRelatedTo(List<Games> relatedTo) {
        this.relatedTo = relatedTo;
    }

    public List<Games> getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedAs(List<String> relatedAs) {
        this.relatedAs = relatedAs;
    }

    public List<String> getRelatedAs() {
        return relatedAs;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setRulesUrl(String rulesUrl) {
        this.rulesUrl = rulesUrl;
    }

    public String getRulesUrl() {
        return rulesUrl;
    }

    public void setAmazonRank(int amazonRank) {
        this.amazonRank = amazonRank;
    }

    public int getAmazonRank() {
        return amazonRank;
    }

    public void setOfficialUrl(String officialUrl) {
        this.officialUrl = officialUrl;
    }

    public String getOfficialUrl() {
        return officialUrl;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setNumUserRatings(int numUserRatings) {
        this.numUserRatings = numUserRatings;
    }

    public int getNumUserRatings() {
        return numUserRatings;
    }

    public void setAverageUserRating(String averageUserRating) {
        this.averageUserRating = averageUserRating;
    }

    public String getAverageUserRating() {
        return averageUserRating;
    }

    public void setWeightAmount(String weightAmount) {
        this.weightAmount = weightAmount;
    }

    public String getWeightAmount() {
        return weightAmount;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setSizeHeight(String sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public String getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeDepth(String sizeDepth) {
        this.sizeDepth = sizeDepth;
    }

    public String getSizeDepth() {
        return sizeDepth;
    }

    public void setSizeUnits(String sizeUnits) {
        this.sizeUnits = sizeUnits;
    }

    public String getSizeUnits() {
        return sizeUnits;
    }

    public void setHistoricalLowPrices(List<HistoricalLowPrices> historicalLowPrices) {
        this.historicalLowPrices = historicalLowPrices;
    }

    public List<HistoricalLowPrices> getHistoricalLowPrices() {
        return historicalLowPrices;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public void setNumUserComplexityVotes(int numUserComplexityVotes) {
        this.numUserComplexityVotes = numUserComplexityVotes;
    }

    public int getNumUserComplexityVotes() {
        return numUserComplexityVotes;
    }

    public void setAverageLearningComplexity(String averageLearningComplexity) {
        this.averageLearningComplexity = averageLearningComplexity;
    }

    public String getAverageLearningComplexity() {
        return averageLearningComplexity;
    }

    public void setAverageStrategyComplexity(String averageStrategyComplexity) {
        this.averageStrategyComplexity = averageStrategyComplexity;
    }

    public String getAverageStrategyComplexity() {
        return averageStrategyComplexity;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getVisits() {
        return visits;
    }

    public void setLists(int lists) {
        this.lists = lists;
    }

    public int getLists() {
        return lists;
    }

    public void setMentions(int mentions) {
        this.mentions = mentions;
    }

    public int getMentions() {
        return mentions;
    }

    public void setLinks(int links) {
        this.links = links;
    }

    public int getLinks() {
        return links;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public int getPlays() {
        return plays;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getUpc() {
        return upc;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setVideoLinks(List<String> videoLinks) {
        this.videoLinks = videoLinks;
    }

    public List<String> getVideoLinks() {
        return videoLinks;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setNumDistributors(int numDistributors) {
        this.numDistributors = numDistributors;
    }

    public int getNumDistributors() {
        return numDistributors;
    }

    public void setTrendingRank(int trendingRank) {
        this.trendingRank = trendingRank;
    }

    public int getTrendingRank() {
        return trendingRank;
    }

    public void setListingClicks(int listingClicks) {
        this.listingClicks = listingClicks;
    }

    public int getListingClicks() {
        return listingClicks;
    }

    public void setIsHistoricalLow(boolean isHistoricalLow) {
        this.isHistoricalLow = isHistoricalLow;
    }

    public boolean getIsHistoricalLow() {
        return isHistoricalLow;
    }

    public void setSkus(List<String> skus) {
        this.skus = skus;
    }

    public List<String> getSkus() {
        return skus;
    }

    public void setSkuObjects(List<SkuObjects> skuObjects) {
        this.skuObjects = skuObjects;
    }

    public List<SkuObjects> getSkuObjects() {
        return skuObjects;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setMsrpText(String msrpText) {
        this.msrpText = msrpText;
    }

    public String getMsrpText() {
        return msrpText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Images getImages() {
        return images;
    }

    public void setDescriptionPreview(String descriptionPreview) {
        this.descriptionPreview = descriptionPreview;
    }

    public String getDescriptionPreview() {
        return descriptionPreview;
    }

}