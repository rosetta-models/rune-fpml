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
import fpml.confirmation.CommodityBasketModel;
import fpml.confirmation.CommodityBasketOption;
import fpml.confirmation.CommodityBasketOption.CommodityBasketOptionBuilder;
import fpml.confirmation.CommodityBasketOption.CommodityBasketOptionBuilderImpl;
import fpml.confirmation.CommodityBasketOption.CommodityBasketOptionImpl;
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityExerciseBasket;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityStrikePriceModel;
import fpml.confirmation.Option;
import fpml.confirmation.Option.OptionBuilder;
import fpml.confirmation.Option.OptionBuilderImpl;
import fpml.confirmation.Option.OptionImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.StrikePriceBasketReference;
import fpml.confirmation.StrikePriceUnderlyingReference;
import fpml.confirmation.meta.CommodityBasketOptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity basket option product.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasketOption", builder=CommodityBasketOption.CommodityBasketOptionBuilderImpl.class, version="${project.version}")
public interface CommodityBasketOption extends Option {

	CommodityBasketOptionMeta metaData = new CommodityBasketOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of option transaction.
	 */
	PutCallEnum getOptionType();
	CommodityBasketOptionFeaturesModel getCommodityBasketOptionFeaturesModel();
	CommodityBasketModel getCommodityBasketModel();
	StrikePriceUnderlyingReference getStrikePriceUnderlyingReference();
	StrikePriceBasketReference getStrikePriceBasketReference();
	CommodityStrikePriceModel getCommodityStrikePriceModel();
	CommodityFloatingStrikePriceModel getCommodityFloatingStrikePriceModel();
	/**
	 * The parameters for defining how the commodity option can be exercised and how it is settled.
	 */
	CommodityExerciseBasket getExercise();
	/**
	 * The option premium payable by the buyer to the seller.
	 */
	List<? extends CommodityPremium> getPremium();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommodityBasketOption build();
	
	CommodityBasketOption.CommodityBasketOptionBuilder toBuilder();
	
	static CommodityBasketOption.CommodityBasketOptionBuilder builder() {
		return new CommodityBasketOption.CommodityBasketOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketOption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketOption> getType() {
		return CommodityBasketOption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("commodityBasketOptionFeaturesModel"), processor, CommodityBasketOptionFeaturesModel.class, getCommodityBasketOptionFeaturesModel());
		processRosetta(path.newSubPath("commodityBasketModel"), processor, CommodityBasketModel.class, getCommodityBasketModel());
		processRosetta(path.newSubPath("strikePriceUnderlyingReference"), processor, StrikePriceUnderlyingReference.class, getStrikePriceUnderlyingReference());
		processRosetta(path.newSubPath("strikePriceBasketReference"), processor, StrikePriceBasketReference.class, getStrikePriceBasketReference());
		processRosetta(path.newSubPath("commodityStrikePriceModel"), processor, CommodityStrikePriceModel.class, getCommodityStrikePriceModel());
		processRosetta(path.newSubPath("commodityFloatingStrikePriceModel"), processor, CommodityFloatingStrikePriceModel.class, getCommodityFloatingStrikePriceModel());
		processRosetta(path.newSubPath("exercise"), processor, CommodityExerciseBasket.class, getExercise());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketOptionBuilder extends CommodityBasketOption, Option.OptionBuilder {
		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder getOrCreateCommodityBasketOptionFeaturesModel();
		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder getCommodityBasketOptionFeaturesModel();
		CommodityBasketModel.CommodityBasketModelBuilder getOrCreateCommodityBasketModel();
		CommodityBasketModel.CommodityBasketModelBuilder getCommodityBasketModel();
		StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getOrCreateStrikePriceUnderlyingReference();
		StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getStrikePriceUnderlyingReference();
		StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getOrCreateStrikePriceBasketReference();
		StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getStrikePriceBasketReference();
		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getOrCreateCommodityStrikePriceModel();
		CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getCommodityStrikePriceModel();
		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getOrCreateCommodityFloatingStrikePriceModel();
		CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getCommodityFloatingStrikePriceModel();
		CommodityExerciseBasket.CommodityExerciseBasketBuilder getOrCreateExercise();
		CommodityExerciseBasket.CommodityExerciseBasketBuilder getExercise();
		CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int _index);
		List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommodityBasketOption.CommodityBasketOptionBuilder setProductModel(ProductModel productModel);
		CommodityBasketOption.CommodityBasketOptionBuilder setId(String id);
		CommodityBasketOption.CommodityBasketOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		CommodityBasketOption.CommodityBasketOptionBuilder setOptionType(PutCallEnum optionType);
		CommodityBasketOption.CommodityBasketOptionBuilder setCommodityBasketOptionFeaturesModel(CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel);
		CommodityBasketOption.CommodityBasketOptionBuilder setCommodityBasketModel(CommodityBasketModel commodityBasketModel);
		CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceUnderlyingReference(StrikePriceUnderlyingReference strikePriceUnderlyingReference);
		CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceBasketReference(StrikePriceBasketReference strikePriceBasketReference);
		CommodityBasketOption.CommodityBasketOptionBuilder setCommodityStrikePriceModel(CommodityStrikePriceModel commodityStrikePriceModel);
		CommodityBasketOption.CommodityBasketOptionBuilder setCommodityFloatingStrikePriceModel(CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel);
		CommodityBasketOption.CommodityBasketOptionBuilder setExercise(CommodityExerciseBasket exercise);
		CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium premium0);
		CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium premium1, int _idx);
		CommodityBasketOption.CommodityBasketOptionBuilder addPremium(List<? extends CommodityPremium> premium2);
		CommodityBasketOption.CommodityBasketOptionBuilder setPremium(List<? extends CommodityPremium> premium3);
		CommodityBasketOption.CommodityBasketOptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("commodityBasketOptionFeaturesModel"), processor, CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder.class, getCommodityBasketOptionFeaturesModel());
			processRosetta(path.newSubPath("commodityBasketModel"), processor, CommodityBasketModel.CommodityBasketModelBuilder.class, getCommodityBasketModel());
			processRosetta(path.newSubPath("strikePriceUnderlyingReference"), processor, StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder.class, getStrikePriceUnderlyingReference());
			processRosetta(path.newSubPath("strikePriceBasketReference"), processor, StrikePriceBasketReference.StrikePriceBasketReferenceBuilder.class, getStrikePriceBasketReference());
			processRosetta(path.newSubPath("commodityStrikePriceModel"), processor, CommodityStrikePriceModel.CommodityStrikePriceModelBuilder.class, getCommodityStrikePriceModel());
			processRosetta(path.newSubPath("commodityFloatingStrikePriceModel"), processor, CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder.class, getCommodityFloatingStrikePriceModel());
			processRosetta(path.newSubPath("exercise"), processor, CommodityExerciseBasket.CommodityExerciseBasketBuilder.class, getExercise());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommodityBasketOption.CommodityBasketOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketOption  ***********************/
	class CommodityBasketOptionImpl extends Option.OptionImpl implements CommodityBasketOption {
		private final PutCallEnum optionType;
		private final CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel;
		private final CommodityBasketModel commodityBasketModel;
		private final StrikePriceUnderlyingReference strikePriceUnderlyingReference;
		private final StrikePriceBasketReference strikePriceBasketReference;
		private final CommodityStrikePriceModel commodityStrikePriceModel;
		private final CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel;
		private final CommodityExerciseBasket exercise;
		private final List<? extends CommodityPremium> premium;
		private final CommodityContentModel commodityContentModel;
		
		protected CommodityBasketOptionImpl(CommodityBasketOption.CommodityBasketOptionBuilder builder) {
			super(builder);
			this.optionType = builder.getOptionType();
			this.commodityBasketOptionFeaturesModel = ofNullable(builder.getCommodityBasketOptionFeaturesModel()).map(f->f.build()).orElse(null);
			this.commodityBasketModel = ofNullable(builder.getCommodityBasketModel()).map(f->f.build()).orElse(null);
			this.strikePriceUnderlyingReference = ofNullable(builder.getStrikePriceUnderlyingReference()).map(f->f.build()).orElse(null);
			this.strikePriceBasketReference = ofNullable(builder.getStrikePriceBasketReference()).map(f->f.build()).orElse(null);
			this.commodityStrikePriceModel = ofNullable(builder.getCommodityStrikePriceModel()).map(f->f.build()).orElse(null);
			this.commodityFloatingStrikePriceModel = ofNullable(builder.getCommodityFloatingStrikePriceModel()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("commodityBasketOptionFeaturesModel")
		public CommodityBasketOptionFeaturesModel getCommodityBasketOptionFeaturesModel() {
			return commodityBasketOptionFeaturesModel;
		}
		
		@Override
		@RosettaAttribute("commodityBasketModel")
		public CommodityBasketModel getCommodityBasketModel() {
			return commodityBasketModel;
		}
		
		@Override
		@RosettaAttribute("strikePriceUnderlyingReference")
		public StrikePriceUnderlyingReference getStrikePriceUnderlyingReference() {
			return strikePriceUnderlyingReference;
		}
		
		@Override
		@RosettaAttribute("strikePriceBasketReference")
		public StrikePriceBasketReference getStrikePriceBasketReference() {
			return strikePriceBasketReference;
		}
		
		@Override
		@RosettaAttribute("commodityStrikePriceModel")
		public CommodityStrikePriceModel getCommodityStrikePriceModel() {
			return commodityStrikePriceModel;
		}
		
		@Override
		@RosettaAttribute("commodityFloatingStrikePriceModel")
		public CommodityFloatingStrikePriceModel getCommodityFloatingStrikePriceModel() {
			return commodityFloatingStrikePriceModel;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public CommodityExerciseBasket getExercise() {
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
		public CommodityBasketOption build() {
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder toBuilder() {
			CommodityBasketOption.CommodityBasketOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketOption.CommodityBasketOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommodityBasketOptionFeaturesModel()).ifPresent(builder::setCommodityBasketOptionFeaturesModel);
			ofNullable(getCommodityBasketModel()).ifPresent(builder::setCommodityBasketModel);
			ofNullable(getStrikePriceUnderlyingReference()).ifPresent(builder::setStrikePriceUnderlyingReference);
			ofNullable(getStrikePriceBasketReference()).ifPresent(builder::setStrikePriceBasketReference);
			ofNullable(getCommodityStrikePriceModel()).ifPresent(builder::setCommodityStrikePriceModel);
			ofNullable(getCommodityFloatingStrikePriceModel()).ifPresent(builder::setCommodityFloatingStrikePriceModel);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodityBasketOptionFeaturesModel, _that.getCommodityBasketOptionFeaturesModel())) return false;
			if (!Objects.equals(commodityBasketModel, _that.getCommodityBasketModel())) return false;
			if (!Objects.equals(strikePriceUnderlyingReference, _that.getStrikePriceUnderlyingReference())) return false;
			if (!Objects.equals(strikePriceBasketReference, _that.getStrikePriceBasketReference())) return false;
			if (!Objects.equals(commodityStrikePriceModel, _that.getCommodityStrikePriceModel())) return false;
			if (!Objects.equals(commodityFloatingStrikePriceModel, _that.getCommodityFloatingStrikePriceModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityBasketOptionFeaturesModel != null ? commodityBasketOptionFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (commodityBasketModel != null ? commodityBasketModel.hashCode() : 0);
			_result = 31 * _result + (strikePriceUnderlyingReference != null ? strikePriceUnderlyingReference.hashCode() : 0);
			_result = 31 * _result + (strikePriceBasketReference != null ? strikePriceBasketReference.hashCode() : 0);
			_result = 31 * _result + (commodityStrikePriceModel != null ? commodityStrikePriceModel.hashCode() : 0);
			_result = 31 * _result + (commodityFloatingStrikePriceModel != null ? commodityFloatingStrikePriceModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketOption {" +
				"optionType=" + this.optionType + ", " +
				"commodityBasketOptionFeaturesModel=" + this.commodityBasketOptionFeaturesModel + ", " +
				"commodityBasketModel=" + this.commodityBasketModel + ", " +
				"strikePriceUnderlyingReference=" + this.strikePriceUnderlyingReference + ", " +
				"strikePriceBasketReference=" + this.strikePriceBasketReference + ", " +
				"commodityStrikePriceModel=" + this.commodityStrikePriceModel + ", " +
				"commodityFloatingStrikePriceModel=" + this.commodityFloatingStrikePriceModel + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketOption  ***********************/
	class CommodityBasketOptionBuilderImpl extends Option.OptionBuilderImpl  implements CommodityBasketOption.CommodityBasketOptionBuilder {
	
		protected PutCallEnum optionType;
		protected CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder commodityBasketOptionFeaturesModel;
		protected CommodityBasketModel.CommodityBasketModelBuilder commodityBasketModel;
		protected StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder strikePriceUnderlyingReference;
		protected StrikePriceBasketReference.StrikePriceBasketReferenceBuilder strikePriceBasketReference;
		protected CommodityStrikePriceModel.CommodityStrikePriceModelBuilder commodityStrikePriceModel;
		protected CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder commodityFloatingStrikePriceModel;
		protected CommodityExerciseBasket.CommodityExerciseBasketBuilder exercise;
		protected List<CommodityPremium.CommodityPremiumBuilder> premium = new ArrayList<>();
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommodityBasketOptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commodityBasketOptionFeaturesModel")
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder getCommodityBasketOptionFeaturesModel() {
			return commodityBasketOptionFeaturesModel;
		}
		
		@Override
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder getOrCreateCommodityBasketOptionFeaturesModel() {
			CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder result;
			if (commodityBasketOptionFeaturesModel!=null) {
				result = commodityBasketOptionFeaturesModel;
			}
			else {
				result = commodityBasketOptionFeaturesModel = CommodityBasketOptionFeaturesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityBasketModel")
		public CommodityBasketModel.CommodityBasketModelBuilder getCommodityBasketModel() {
			return commodityBasketModel;
		}
		
		@Override
		public CommodityBasketModel.CommodityBasketModelBuilder getOrCreateCommodityBasketModel() {
			CommodityBasketModel.CommodityBasketModelBuilder result;
			if (commodityBasketModel!=null) {
				result = commodityBasketModel;
			}
			else {
				result = commodityBasketModel = CommodityBasketModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceUnderlyingReference")
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getStrikePriceUnderlyingReference() {
			return strikePriceUnderlyingReference;
		}
		
		@Override
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getOrCreateStrikePriceUnderlyingReference() {
			StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder result;
			if (strikePriceUnderlyingReference!=null) {
				result = strikePriceUnderlyingReference;
			}
			else {
				result = strikePriceUnderlyingReference = StrikePriceUnderlyingReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceBasketReference")
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getStrikePriceBasketReference() {
			return strikePriceBasketReference;
		}
		
		@Override
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getOrCreateStrikePriceBasketReference() {
			StrikePriceBasketReference.StrikePriceBasketReferenceBuilder result;
			if (strikePriceBasketReference!=null) {
				result = strikePriceBasketReference;
			}
			else {
				result = strikePriceBasketReference = StrikePriceBasketReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityStrikePriceModel")
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getCommodityStrikePriceModel() {
			return commodityStrikePriceModel;
		}
		
		@Override
		public CommodityStrikePriceModel.CommodityStrikePriceModelBuilder getOrCreateCommodityStrikePriceModel() {
			CommodityStrikePriceModel.CommodityStrikePriceModelBuilder result;
			if (commodityStrikePriceModel!=null) {
				result = commodityStrikePriceModel;
			}
			else {
				result = commodityStrikePriceModel = CommodityStrikePriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFloatingStrikePriceModel")
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getCommodityFloatingStrikePriceModel() {
			return commodityFloatingStrikePriceModel;
		}
		
		@Override
		public CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder getOrCreateCommodityFloatingStrikePriceModel() {
			CommodityFloatingStrikePriceModel.CommodityFloatingStrikePriceModelBuilder result;
			if (commodityFloatingStrikePriceModel!=null) {
				result = commodityFloatingStrikePriceModel;
			}
			else {
				result = commodityFloatingStrikePriceModel = CommodityFloatingStrikePriceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder getOrCreateExercise() {
			CommodityExerciseBasket.CommodityExerciseBasketBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityExerciseBasket.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium() {
			return premium;
		}
		
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityBasketOption.CommodityBasketOptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public CommodityBasketOption.CommodityBasketOptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public CommodityBasketOption.CommodityBasketOptionBuilder setOptionType(PutCallEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("commodityBasketOptionFeaturesModel")
		public CommodityBasketOption.CommodityBasketOptionBuilder setCommodityBasketOptionFeaturesModel(CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel) {
			this.commodityBasketOptionFeaturesModel = commodityBasketOptionFeaturesModel==null?null:commodityBasketOptionFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityBasketModel")
		public CommodityBasketOption.CommodityBasketOptionBuilder setCommodityBasketModel(CommodityBasketModel commodityBasketModel) {
			this.commodityBasketModel = commodityBasketModel==null?null:commodityBasketModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikePriceUnderlyingReference")
		public CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceUnderlyingReference(StrikePriceUnderlyingReference strikePriceUnderlyingReference) {
			this.strikePriceUnderlyingReference = strikePriceUnderlyingReference==null?null:strikePriceUnderlyingReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikePriceBasketReference")
		public CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceBasketReference(StrikePriceBasketReference strikePriceBasketReference) {
			this.strikePriceBasketReference = strikePriceBasketReference==null?null:strikePriceBasketReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityStrikePriceModel")
		public CommodityBasketOption.CommodityBasketOptionBuilder setCommodityStrikePriceModel(CommodityStrikePriceModel commodityStrikePriceModel) {
			this.commodityStrikePriceModel = commodityStrikePriceModel==null?null:commodityStrikePriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFloatingStrikePriceModel")
		public CommodityBasketOption.CommodityBasketOptionBuilder setCommodityFloatingStrikePriceModel(CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel) {
			this.commodityFloatingStrikePriceModel = commodityFloatingStrikePriceModel==null?null:commodityFloatingStrikePriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exercise")
		public CommodityBasketOption.CommodityBasketOptionBuilder setExercise(CommodityExerciseBasket exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public CommodityBasketOption.CommodityBasketOptionBuilder addPremium(List<? extends CommodityPremium> premiums) {
			if (premiums != null) {
				for (CommodityPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("premium")
		public CommodityBasketOption.CommodityBasketOptionBuilder setPremium(List<? extends CommodityPremium> premiums) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketOption build() {
			return new CommodityBasketOption.CommodityBasketOptionImpl(this);
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder prune() {
			super.prune();
			if (commodityBasketOptionFeaturesModel!=null && !commodityBasketOptionFeaturesModel.prune().hasData()) commodityBasketOptionFeaturesModel = null;
			if (commodityBasketModel!=null && !commodityBasketModel.prune().hasData()) commodityBasketModel = null;
			if (strikePriceUnderlyingReference!=null && !strikePriceUnderlyingReference.prune().hasData()) strikePriceUnderlyingReference = null;
			if (strikePriceBasketReference!=null && !strikePriceBasketReference.prune().hasData()) strikePriceBasketReference = null;
			if (commodityStrikePriceModel!=null && !commodityStrikePriceModel.prune().hasData()) commodityStrikePriceModel = null;
			if (commodityFloatingStrikePriceModel!=null && !commodityFloatingStrikePriceModel.prune().hasData()) commodityFloatingStrikePriceModel = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			premium = premium.stream().filter(b->b!=null).<CommodityPremium.CommodityPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommodityBasketOptionFeaturesModel()!=null && getCommodityBasketOptionFeaturesModel().hasData()) return true;
			if (getCommodityBasketModel()!=null && getCommodityBasketModel().hasData()) return true;
			if (getStrikePriceUnderlyingReference()!=null && getStrikePriceUnderlyingReference().hasData()) return true;
			if (getStrikePriceBasketReference()!=null && getStrikePriceBasketReference().hasData()) return true;
			if (getCommodityStrikePriceModel()!=null && getCommodityStrikePriceModel().hasData()) return true;
			if (getCommodityFloatingStrikePriceModel()!=null && getCommodityFloatingStrikePriceModel().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityBasketOption.CommodityBasketOptionBuilder o = (CommodityBasketOption.CommodityBasketOptionBuilder) other;
			
			merger.mergeRosetta(getCommodityBasketOptionFeaturesModel(), o.getCommodityBasketOptionFeaturesModel(), this::setCommodityBasketOptionFeaturesModel);
			merger.mergeRosetta(getCommodityBasketModel(), o.getCommodityBasketModel(), this::setCommodityBasketModel);
			merger.mergeRosetta(getStrikePriceUnderlyingReference(), o.getStrikePriceUnderlyingReference(), this::setStrikePriceUnderlyingReference);
			merger.mergeRosetta(getStrikePriceBasketReference(), o.getStrikePriceBasketReference(), this::setStrikePriceBasketReference);
			merger.mergeRosetta(getCommodityStrikePriceModel(), o.getCommodityStrikePriceModel(), this::setCommodityStrikePriceModel);
			merger.mergeRosetta(getCommodityFloatingStrikePriceModel(), o.getCommodityFloatingStrikePriceModel(), this::setCommodityFloatingStrikePriceModel);
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
		
			CommodityBasketOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodityBasketOptionFeaturesModel, _that.getCommodityBasketOptionFeaturesModel())) return false;
			if (!Objects.equals(commodityBasketModel, _that.getCommodityBasketModel())) return false;
			if (!Objects.equals(strikePriceUnderlyingReference, _that.getStrikePriceUnderlyingReference())) return false;
			if (!Objects.equals(strikePriceBasketReference, _that.getStrikePriceBasketReference())) return false;
			if (!Objects.equals(commodityStrikePriceModel, _that.getCommodityStrikePriceModel())) return false;
			if (!Objects.equals(commodityFloatingStrikePriceModel, _that.getCommodityFloatingStrikePriceModel())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityBasketOptionFeaturesModel != null ? commodityBasketOptionFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (commodityBasketModel != null ? commodityBasketModel.hashCode() : 0);
			_result = 31 * _result + (strikePriceUnderlyingReference != null ? strikePriceUnderlyingReference.hashCode() : 0);
			_result = 31 * _result + (strikePriceBasketReference != null ? strikePriceBasketReference.hashCode() : 0);
			_result = 31 * _result + (commodityStrikePriceModel != null ? commodityStrikePriceModel.hashCode() : 0);
			_result = 31 * _result + (commodityFloatingStrikePriceModel != null ? commodityFloatingStrikePriceModel.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketOptionBuilder {" +
				"optionType=" + this.optionType + ", " +
				"commodityBasketOptionFeaturesModel=" + this.commodityBasketOptionFeaturesModel + ", " +
				"commodityBasketModel=" + this.commodityBasketModel + ", " +
				"strikePriceUnderlyingReference=" + this.strikePriceUnderlyingReference + ", " +
				"strikePriceBasketReference=" + this.strikePriceBasketReference + ", " +
				"commodityStrikePriceModel=" + this.commodityStrikePriceModel + ", " +
				"commodityFloatingStrikePriceModel=" + this.commodityFloatingStrikePriceModel + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}
}
