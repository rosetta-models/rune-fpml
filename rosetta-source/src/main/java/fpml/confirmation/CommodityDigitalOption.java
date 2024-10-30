package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityDigitalExercise;
import fpml.confirmation.CommodityDigitalOption;
import fpml.confirmation.CommodityDigitalOption.CommodityDigitalOptionBuilder;
import fpml.confirmation.CommodityDigitalOption.CommodityDigitalOptionBuilderImpl;
import fpml.confirmation.CommodityDigitalOption.CommodityDigitalOptionImpl;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel;
import fpml.confirmation.CommodityDigitalOptionSequence;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.meta.CommodityDigitalOptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity digital option product. Defines the digital commodity option product type. Digital options exercise when a barrier is breached and are financially settled. The &#39;commodityDigitalOption&#39; type is an extension of the &#39;commodityOption&#39; product.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityDigitalOption", builder=CommodityDigitalOption.CommodityDigitalOptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityDigitalOption extends Option {

	CommodityDigitalOptionMeta metaData = new CommodityDigitalOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of option transaction.
	 */
	PutCallEnum getOptionType();
	/**
	 * Specifies the underlying instrument. Usual content is an ISDA Commodity Reference Price Name. The &#39;commodity&#39; underlyer component is specified using a reference to the &#39;commodity&#39; asset (see description above at the Commodity Underlyer section).
	 */
	Commodity getCommodity();
	CommodityDigitalOptionFeaturesModel getCommodityDigitalOptionFeaturesModel();
	/**
	 * Volume contracted when volume is specified as a currency-denominated amount.
	 */
	NotionalAmount getNotionalAmount();
	CommodityDigitalOptionSequence getCommodityDigitalOptionSequence();
	/**
	 * The parameters for defining how the commodity option can be exercised and how it is settled.
	 */
	CommodityDigitalExercise getExercise();
	/**
	 * The option premium payable by the buyer to the seller.
	 */
	List<? extends CommodityPremium> getPremium();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommodityDigitalOption build();
	
	CommodityDigitalOption.CommodityDigitalOptionBuilder toBuilder();
	
	static CommodityDigitalOption.CommodityDigitalOptionBuilder builder() {
		return new CommodityDigitalOption.CommodityDigitalOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigitalOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDigitalOption> getType() {
		return CommodityDigitalOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("commodityDigitalOptionFeaturesModel"), processor, CommodityDigitalOptionFeaturesModel.class, getCommodityDigitalOptionFeaturesModel());
		processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.class, getNotionalAmount());
		processRosetta(path.newSubPath("commodityDigitalOptionSequence"), processor, CommodityDigitalOptionSequence.class, getCommodityDigitalOptionSequence());
		processRosetta(path.newSubPath("exercise"), processor, CommodityDigitalExercise.class, getExercise());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalOptionBuilder extends CommodityDigitalOption, Option.OptionBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder getOrCreateCommodityDigitalOptionFeaturesModel();
		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder getCommodityDigitalOptionFeaturesModel();
		NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount();
		NotionalAmount.NotionalAmountBuilder getNotionalAmount();
		CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder getOrCreateCommodityDigitalOptionSequence();
		CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder getCommodityDigitalOptionSequence();
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder getOrCreateExercise();
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder getExercise();
		CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int _index);
		List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommodityDigitalOption.CommodityDigitalOptionBuilder setProductModel(ProductModel productModel);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setId(String id);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setOptionType(PutCallEnum optionType);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodity(Commodity commodity);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodityDigitalOptionFeaturesModel(CommodityDigitalOptionFeaturesModel commodityDigitalOptionFeaturesModel);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setNotionalAmount(NotionalAmount notionalAmount);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodityDigitalOptionSequence(CommodityDigitalOptionSequence commodityDigitalOptionSequence);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setExercise(CommodityDigitalExercise exercise);
		CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium premium0);
		CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium premium1, int _idx);
		CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(List<? extends CommodityPremium> premium2);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setPremium(List<? extends CommodityPremium> premium3);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("commodityDigitalOptionFeaturesModel"), processor, CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder.class, getCommodityDigitalOptionFeaturesModel());
			processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.NotionalAmountBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("commodityDigitalOptionSequence"), processor, CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder.class, getCommodityDigitalOptionSequence());
			processRosetta(path.newSubPath("exercise"), processor, CommodityDigitalExercise.CommodityDigitalExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommodityDigitalOption.CommodityDigitalOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigitalOption  ***********************/
	class CommodityDigitalOptionImpl extends Option.OptionImpl implements CommodityDigitalOption {
		private final PutCallEnum optionType;
		private final Commodity commodity;
		private final CommodityDigitalOptionFeaturesModel commodityDigitalOptionFeaturesModel;
		private final NotionalAmount notionalAmount;
		private final CommodityDigitalOptionSequence commodityDigitalOptionSequence;
		private final CommodityDigitalExercise exercise;
		private final List<? extends CommodityPremium> premium;
		private final CommodityContentModel commodityContentModel;
		
		protected CommodityDigitalOptionImpl(CommodityDigitalOption.CommodityDigitalOptionBuilder builder) {
			super(builder);
			this.optionType = builder.getOptionType();
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.commodityDigitalOptionFeaturesModel = ofNullable(builder.getCommodityDigitalOptionFeaturesModel()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.commodityDigitalOptionSequence = ofNullable(builder.getCommodityDigitalOptionSequence()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityContentModel = ofNullable(builder.getCommodityContentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("commodityDigitalOptionFeaturesModel")
		public CommodityDigitalOptionFeaturesModel getCommodityDigitalOptionFeaturesModel() {
			return commodityDigitalOptionFeaturesModel;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("commodityDigitalOptionSequence")
		public CommodityDigitalOptionSequence getCommodityDigitalOptionSequence() {
			return commodityDigitalOptionSequence;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public CommodityDigitalExercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends CommodityPremium> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityDigitalOption build() {
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder toBuilder() {
			CommodityDigitalOption.CommodityDigitalOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigitalOption.CommodityDigitalOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getCommodityDigitalOptionFeaturesModel()).ifPresent(builder::setCommodityDigitalOptionFeaturesModel);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCommodityDigitalOptionSequence()).ifPresent(builder::setCommodityDigitalOptionSequence);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityDigitalOptionFeaturesModel, _that.getCommodityDigitalOptionFeaturesModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(commodityDigitalOptionSequence, _that.getCommodityDigitalOptionSequence())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityDigitalOptionFeaturesModel != null ? commodityDigitalOptionFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (commodityDigitalOptionSequence != null ? commodityDigitalOptionSequence.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOption {" +
				"optionType=" + this.optionType + ", " +
				"commodity=" + this.commodity + ", " +
				"commodityDigitalOptionFeaturesModel=" + this.commodityDigitalOptionFeaturesModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"commodityDigitalOptionSequence=" + this.commodityDigitalOptionSequence + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityDigitalOption  ***********************/
	class CommodityDigitalOptionBuilderImpl extends Option.OptionBuilderImpl  implements CommodityDigitalOption.CommodityDigitalOptionBuilder {
	
		protected PutCallEnum optionType;
		protected Commodity.CommodityBuilder commodity;
		protected CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder commodityDigitalOptionFeaturesModel;
		protected NotionalAmount.NotionalAmountBuilder notionalAmount;
		protected CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder commodityDigitalOptionSequence;
		protected CommodityDigitalExercise.CommodityDigitalExerciseBuilder exercise;
		protected List<CommodityPremium.CommodityPremiumBuilder> premium = new ArrayList<>();
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommodityDigitalOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDigitalOptionFeaturesModel")
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder getCommodityDigitalOptionFeaturesModel() {
			return commodityDigitalOptionFeaturesModel;
		}
		
		@Override
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder getOrCreateCommodityDigitalOptionFeaturesModel() {
			CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder result;
			if (commodityDigitalOptionFeaturesModel!=null) {
				result = commodityDigitalOptionFeaturesModel;
			}
			else {
				result = commodityDigitalOptionFeaturesModel = CommodityDigitalOptionFeaturesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NotionalAmount.NotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount() {
			NotionalAmount.NotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDigitalOptionSequence")
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder getCommodityDigitalOptionSequence() {
			return commodityDigitalOptionSequence;
		}
		
		@Override
		public CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder getOrCreateCommodityDigitalOptionSequence() {
			CommodityDigitalOptionSequence.CommodityDigitalOptionSequenceBuilder result;
			if (commodityDigitalOptionSequence!=null) {
				result = commodityDigitalOptionSequence;
			}
			else {
				result = commodityDigitalOptionSequence = CommodityDigitalOptionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder getOrCreateExercise() {
			CommodityDigitalExercise.CommodityDigitalExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityDigitalExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			CommodityPremium.CommodityPremiumBuilder result;
			return getIndex(premium, _index, () -> {
						CommodityPremium.CommodityPremiumBuilder newPremium = CommodityPremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel() {
			CommodityContentModel.CommodityContentModelBuilder result;
			if (commodityContentModel!=null) {
				result = commodityContentModel;
			}
			else {
				result = commodityContentModel = CommodityContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityDigitalOptionFeaturesModel")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodityDigitalOptionFeaturesModel(CommodityDigitalOptionFeaturesModel commodityDigitalOptionFeaturesModel) {
			this.commodityDigitalOptionFeaturesModel = commodityDigitalOptionFeaturesModel==null?null:commodityDigitalOptionFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setNotionalAmount(NotionalAmount notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityDigitalOptionSequence")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodityDigitalOptionSequence(CommodityDigitalOptionSequence commodityDigitalOptionSequence) {
			this.commodityDigitalOptionSequence = commodityDigitalOptionSequence==null?null:commodityDigitalOptionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setExercise(CommodityDigitalExercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(List<? extends CommodityPremium> premiums) {
			if (premiums != null) {
				for (CommodityPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setPremium(List<? extends CommodityPremium> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDigitalOption build() {
			return new CommodityDigitalOption.CommodityDigitalOptionImpl(this);
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder prune() {
			super.prune();
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (commodityDigitalOptionFeaturesModel!=null && !commodityDigitalOptionFeaturesModel.prune().hasData()) commodityDigitalOptionFeaturesModel = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (commodityDigitalOptionSequence!=null && !commodityDigitalOptionSequence.prune().hasData()) commodityDigitalOptionSequence = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			premium = premium.stream().filter(b->b!=null).<CommodityPremium.CommodityPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getCommodityDigitalOptionFeaturesModel()!=null && getCommodityDigitalOptionFeaturesModel().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCommodityDigitalOptionSequence()!=null && getCommodityDigitalOptionSequence().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityDigitalOption.CommodityDigitalOptionBuilder o = (CommodityDigitalOption.CommodityDigitalOptionBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getCommodityDigitalOptionFeaturesModel(), o.getCommodityDigitalOptionFeaturesModel(), this::setCommodityDigitalOptionFeaturesModel);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCommodityDigitalOptionSequence(), o.getCommodityDigitalOptionSequence(), this::setCommodityDigitalOptionSequence);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getCommodityContentModel(), o.getCommodityContentModel(), this::setCommodityContentModel);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityDigitalOptionFeaturesModel, _that.getCommodityDigitalOptionFeaturesModel())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(commodityDigitalOptionSequence, _that.getCommodityDigitalOptionSequence())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityDigitalOptionFeaturesModel != null ? commodityDigitalOptionFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (commodityDigitalOptionSequence != null ? commodityDigitalOptionSequence.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOptionBuilder {" +
				"optionType=" + this.optionType + ", " +
				"commodity=" + this.commodity + ", " +
				"commodityDigitalOptionFeaturesModel=" + this.commodityDigitalOptionFeaturesModel + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"commodityDigitalOptionSequence=" + this.commodityDigitalOptionSequence + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}
}
