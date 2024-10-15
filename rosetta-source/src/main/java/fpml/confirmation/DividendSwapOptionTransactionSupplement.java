package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DividendSwapOptionTransactionSupplement;
import fpml.confirmation.DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder;
import fpml.confirmation.DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilderImpl;
import fpml.confirmation.DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementImpl;
import fpml.confirmation.DividendSwapTransactionSupplement;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.OptionBase;
import fpml.confirmation.OptionBase.OptionBaseBuilder;
import fpml.confirmation.OptionBase.OptionBaseBuilderImpl;
import fpml.confirmation.OptionBase.OptionBaseImpl;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SwaptionPhysicalSettlement;
import fpml.confirmation.meta.DividendSwapOptionTransactionSupplementMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of the dividend swap transaction supplement.
 * @version ${project.version}
 */
@RosettaDataType(value="DividendSwapOptionTransactionSupplement", builder=DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilderImpl.class, version="${project.version}")
public interface DividendSwapOptionTransactionSupplement extends OptionBase {

	DividendSwapOptionTransactionSupplementMeta metaData = new DividendSwapOptionTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The variance option premium payable by the buyer to the seller.
	 */
	EquityPremium getEquityPremium();
	/**
	 * The parameters for defining how the equity option can be exercised, how it is valued and how it is settled.
	 */
	EquityExerciseValuationSettlement getEquityExercise();
	/**
	 * For a share option transaction, a flag used to indicate whether the transaction is to be treated as an &#39;exchange look-alike&#39;. This designation has significance for how share adjustments (arising from corporate actions) will be determined for the transaction. For an &#39;exchange look-alike&#39; transaction the relevant share adjustments will follow that for a corresponding designated contract listed on the related exchange (referred to as Options Exchange Adjustment (ISDA defined term), otherwise the share adjustments will be determined by the calculation agent (referred to as Calculation Agent Adjustment (ISDA defined term)).
	 */
	Boolean getExchangeLookAlike();
	/**
	 * Defines how adjustments will be made to the contract should one or more of the extraordinary events occur.
	 */
	MethodOfAdjustmentEnum getMethodOfAdjustment();
	/**
	 * The number of shares per option comprised in the option transaction supplement.
	 */
	BigDecimal getOptionEntitlement();
	/**
	 * Specifies the contract multiplier that can be associated with an index option.
	 */
	BigDecimal getMultiplier();
	/**
	 * Specifies any instructions on how the physical settlement is to be effected when the option is exercised.
	 */
	SwaptionPhysicalSettlement getClearingInstructions();
	/**
	 * The variance swap details.
	 */
	DividendSwapTransactionSupplement getDividendSwapTransactionSupplement();

	/*********************** Build Methods  ***********************/
	DividendSwapOptionTransactionSupplement build();
	
	DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder toBuilder();
	
	static DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder builder() {
		return new DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendSwapOptionTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendSwapOptionTransactionSupplement> getType() {
		return DividendSwapOptionTransactionSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.class, getEquityPremium());
		processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.class, getEquityExercise());
		processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
		processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.class, getClearingInstructions());
		processRosetta(path.newSubPath("dividendSwapTransactionSupplement"), processor, DividendSwapTransactionSupplement.class, getDividendSwapTransactionSupplement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendSwapOptionTransactionSupplementBuilder extends DividendSwapOptionTransactionSupplement, OptionBase.OptionBaseBuilder {
		EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium();
		EquityPremium.EquityPremiumBuilder getEquityPremium();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions();
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder getOrCreateDividendSwapTransactionSupplement();
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder getDividendSwapTransactionSupplement();
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setProductModel(ProductModel productModel);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setId(String id);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setOptionType(OptionTypeEnum optionType);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions);
		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setDividendSwapTransactionSupplement(DividendSwapTransactionSupplement dividendSwapTransactionSupplement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.EquityPremiumBuilder.class, getEquityPremium());
			processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder.class, getEquityExercise());
			processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
			processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getClearingInstructions());
			processRosetta(path.newSubPath("dividendSwapTransactionSupplement"), processor, DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder.class, getDividendSwapTransactionSupplement());
		}
		

		DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of DividendSwapOptionTransactionSupplement  ***********************/
	class DividendSwapOptionTransactionSupplementImpl extends OptionBase.OptionBaseImpl implements DividendSwapOptionTransactionSupplement {
		private final EquityPremium equityPremium;
		private final EquityExerciseValuationSettlement equityExercise;
		private final Boolean exchangeLookAlike;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final BigDecimal optionEntitlement;
		private final BigDecimal multiplier;
		private final SwaptionPhysicalSettlement clearingInstructions;
		private final DividendSwapTransactionSupplement dividendSwapTransactionSupplement;
		
		protected DividendSwapOptionTransactionSupplementImpl(DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder builder) {
			super(builder);
			this.equityPremium = ofNullable(builder.getEquityPremium()).map(f->f.build()).orElse(null);
			this.equityExercise = ofNullable(builder.getEquityExercise()).map(f->f.build()).orElse(null);
			this.exchangeLookAlike = builder.getExchangeLookAlike();
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.optionEntitlement = builder.getOptionEntitlement();
			this.multiplier = builder.getMultiplier();
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.dividendSwapTransactionSupplement = ofNullable(builder.getDividendSwapTransactionSupplement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		public EquityPremium getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		public EquityExerciseValuationSettlement getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		@RosettaAttribute("dividendSwapTransactionSupplement")
		public DividendSwapTransactionSupplement getDividendSwapTransactionSupplement() {
			return dividendSwapTransactionSupplement;
		}
		
		@Override
		public DividendSwapOptionTransactionSupplement build() {
			return this;
		}
		
		@Override
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder toBuilder() {
			DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEquityPremium()).ifPresent(builder::setEquityPremium);
			ofNullable(getEquityExercise()).ifPresent(builder::setEquityExercise);
			ofNullable(getExchangeLookAlike()).ifPresent(builder::setExchangeLookAlike);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
			ofNullable(getDividendSwapTransactionSupplement()).ifPresent(builder::setDividendSwapTransactionSupplement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendSwapOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(dividendSwapTransactionSupplement, _that.getDividendSwapTransactionSupplement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (dividendSwapTransactionSupplement != null ? dividendSwapTransactionSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendSwapOptionTransactionSupplement {" +
				"equityPremium=" + this.equityPremium + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"dividendSwapTransactionSupplement=" + this.dividendSwapTransactionSupplement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendSwapOptionTransactionSupplement  ***********************/
	class DividendSwapOptionTransactionSupplementBuilderImpl extends OptionBase.OptionBaseBuilderImpl  implements DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder {
	
		protected EquityPremium.EquityPremiumBuilder equityPremium;
		protected EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder equityExercise;
		protected Boolean exchangeLookAlike;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected BigDecimal optionEntitlement;
		protected BigDecimal multiplier;
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder clearingInstructions;
		protected DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder dividendSwapTransactionSupplement;
	
		public DividendSwapOptionTransactionSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("equityPremium")
		public EquityPremium.EquityPremiumBuilder getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium() {
			EquityPremium.EquityPremiumBuilder result;
			if (equityPremium!=null) {
				result = equityPremium;
			}
			else {
				result = equityPremium = EquityPremium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise() {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder result;
			if (equityExercise!=null) {
				result = equityExercise;
			}
			else {
				result = equityExercise = EquityExerciseValuationSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = SwaptionPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendSwapTransactionSupplement")
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder getDividendSwapTransactionSupplement() {
			return dividendSwapTransactionSupplement;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder getOrCreateDividendSwapTransactionSupplement() {
			DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder result;
			if (dividendSwapTransactionSupplement!=null) {
				result = dividendSwapTransactionSupplement;
			}
			else {
				result = dividendSwapTransactionSupplement = DividendSwapTransactionSupplement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityPremium")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium) {
			this.equityPremium = equityPremium==null?null:equityPremium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike) {
			this.exchangeLookAlike = exchangeLookAlike==null?null:exchangeLookAlike;
			return this;
		}
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment) {
			this.methodOfAdjustment = methodOfAdjustment==null?null:methodOfAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("optionEntitlement")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement) {
			this.optionEntitlement = optionEntitlement==null?null:optionEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("clearingInstructions")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions) {
			this.clearingInstructions = clearingInstructions==null?null:clearingInstructions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendSwapTransactionSupplement")
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder setDividendSwapTransactionSupplement(DividendSwapTransactionSupplement dividendSwapTransactionSupplement) {
			this.dividendSwapTransactionSupplement = dividendSwapTransactionSupplement==null?null:dividendSwapTransactionSupplement.toBuilder();
			return this;
		}
		
		@Override
		public DividendSwapOptionTransactionSupplement build() {
			return new DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementImpl(this);
		}
		
		@Override
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder prune() {
			super.prune();
			if (equityPremium!=null && !equityPremium.prune().hasData()) equityPremium = null;
			if (equityExercise!=null && !equityExercise.prune().hasData()) equityExercise = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			if (dividendSwapTransactionSupplement!=null && !dividendSwapTransactionSupplement.prune().hasData()) dividendSwapTransactionSupplement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEquityPremium()!=null && getEquityPremium().hasData()) return true;
			if (getEquityExercise()!=null && getEquityExercise().hasData()) return true;
			if (getExchangeLookAlike()!=null) return true;
			if (getMethodOfAdjustment()!=null) return true;
			if (getOptionEntitlement()!=null) return true;
			if (getMultiplier()!=null) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			if (getDividendSwapTransactionSupplement()!=null && getDividendSwapTransactionSupplement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder o = (DividendSwapOptionTransactionSupplement.DividendSwapOptionTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getEquityPremium(), o.getEquityPremium(), this::setEquityPremium);
			merger.mergeRosetta(getEquityExercise(), o.getEquityExercise(), this::setEquityExercise);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			merger.mergeRosetta(getDividendSwapTransactionSupplement(), o.getDividendSwapTransactionSupplement(), this::setDividendSwapTransactionSupplement);
			
			merger.mergeBasic(getExchangeLookAlike(), o.getExchangeLookAlike(), this::setExchangeLookAlike);
			merger.mergeBasic(getMethodOfAdjustment(), o.getMethodOfAdjustment(), this::setMethodOfAdjustment);
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendSwapOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(dividendSwapTransactionSupplement, _that.getDividendSwapTransactionSupplement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (dividendSwapTransactionSupplement != null ? dividendSwapTransactionSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendSwapOptionTransactionSupplementBuilder {" +
				"equityPremium=" + this.equityPremium + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"dividendSwapTransactionSupplement=" + this.dividendSwapTransactionSupplement +
			'}' + " " + super.toString();
		}
	}
}
