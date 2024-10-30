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
import fpml.confirmation.VarianceOptionTransactionSupplement;
import fpml.confirmation.VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder;
import fpml.confirmation.VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilderImpl;
import fpml.confirmation.VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementImpl;
import fpml.confirmation.VarianceSwapTransactionSupplement;
import fpml.confirmation.meta.VarianceOptionTransactionSupplementMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of a variance option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="VarianceOptionTransactionSupplement", builder=VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface VarianceOptionTransactionSupplement extends OptionBase {

	VarianceOptionTransactionSupplementMeta metaData = new VarianceOptionTransactionSupplementMeta();

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
	VarianceSwapTransactionSupplement getVarianceSwapTransactionSupplement();

	/*********************** Build Methods  ***********************/
	VarianceOptionTransactionSupplement build();
	
	VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder toBuilder();
	
	static VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder() {
		return new VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceOptionTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VarianceOptionTransactionSupplement> getType() {
		return VarianceOptionTransactionSupplement.class;
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
		processRosetta(path.newSubPath("varianceSwapTransactionSupplement"), processor, VarianceSwapTransactionSupplement.class, getVarianceSwapTransactionSupplement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceOptionTransactionSupplementBuilder extends VarianceOptionTransactionSupplement, OptionBase.OptionBaseBuilder {
		EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium();
		EquityPremium.EquityPremiumBuilder getEquityPremium();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions();
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getOrCreateVarianceSwapTransactionSupplement();
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getVarianceSwapTransactionSupplement();
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setProductModel(ProductModel productModel);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setId(String id);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionType(OptionTypeEnum optionType);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setVarianceSwapTransactionSupplement(VarianceSwapTransactionSupplement varianceSwapTransactionSupplement);

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
			processRosetta(path.newSubPath("varianceSwapTransactionSupplement"), processor, VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder.class, getVarianceSwapTransactionSupplement());
		}
		

		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceOptionTransactionSupplement  ***********************/
	class VarianceOptionTransactionSupplementImpl extends OptionBase.OptionBaseImpl implements VarianceOptionTransactionSupplement {
		private final EquityPremium equityPremium;
		private final EquityExerciseValuationSettlement equityExercise;
		private final Boolean exchangeLookAlike;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final BigDecimal optionEntitlement;
		private final BigDecimal multiplier;
		private final SwaptionPhysicalSettlement clearingInstructions;
		private final VarianceSwapTransactionSupplement varianceSwapTransactionSupplement;
		
		protected VarianceOptionTransactionSupplementImpl(VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder) {
			super(builder);
			this.equityPremium = ofNullable(builder.getEquityPremium()).map(f->f.build()).orElse(null);
			this.equityExercise = ofNullable(builder.getEquityExercise()).map(f->f.build()).orElse(null);
			this.exchangeLookAlike = builder.getExchangeLookAlike();
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.optionEntitlement = builder.getOptionEntitlement();
			this.multiplier = builder.getMultiplier();
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.varianceSwapTransactionSupplement = ofNullable(builder.getVarianceSwapTransactionSupplement()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("varianceSwapTransactionSupplement")
		public VarianceSwapTransactionSupplement getVarianceSwapTransactionSupplement() {
			return varianceSwapTransactionSupplement;
		}
		
		@Override
		public VarianceOptionTransactionSupplement build() {
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder toBuilder() {
			VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEquityPremium()).ifPresent(builder::setEquityPremium);
			ofNullable(getEquityExercise()).ifPresent(builder::setEquityExercise);
			ofNullable(getExchangeLookAlike()).ifPresent(builder::setExchangeLookAlike);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
			ofNullable(getVarianceSwapTransactionSupplement()).ifPresent(builder::setVarianceSwapTransactionSupplement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(varianceSwapTransactionSupplement, _that.getVarianceSwapTransactionSupplement())) return false;
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
			_result = 31 * _result + (varianceSwapTransactionSupplement != null ? varianceSwapTransactionSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceOptionTransactionSupplement {" +
				"equityPremium=" + this.equityPremium + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"varianceSwapTransactionSupplement=" + this.varianceSwapTransactionSupplement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceOptionTransactionSupplement  ***********************/
	class VarianceOptionTransactionSupplementBuilderImpl extends OptionBase.OptionBaseBuilderImpl  implements VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder {
	
		protected EquityPremium.EquityPremiumBuilder equityPremium;
		protected EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder equityExercise;
		protected Boolean exchangeLookAlike;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected BigDecimal optionEntitlement;
		protected BigDecimal multiplier;
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder clearingInstructions;
		protected VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder varianceSwapTransactionSupplement;
	
		public VarianceOptionTransactionSupplementBuilderImpl() {
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
		@RosettaAttribute("varianceSwapTransactionSupplement")
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getVarianceSwapTransactionSupplement() {
			return varianceSwapTransactionSupplement;
		}
		
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getOrCreateVarianceSwapTransactionSupplement() {
			VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder result;
			if (varianceSwapTransactionSupplement!=null) {
				result = varianceSwapTransactionSupplement;
			}
			else {
				result = varianceSwapTransactionSupplement = VarianceSwapTransactionSupplement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionType")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionType(OptionTypeEnum optionType) {
			this.optionType = optionType==null?null:optionType;
			return this;
		}
		@Override
		@RosettaAttribute("equityPremium")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium) {
			this.equityPremium = equityPremium==null?null:equityPremium.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityExercise")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise) {
			this.equityExercise = equityExercise==null?null:equityExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeLookAlike")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike) {
			this.exchangeLookAlike = exchangeLookAlike==null?null:exchangeLookAlike;
			return this;
		}
		@Override
		@RosettaAttribute("methodOfAdjustment")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment) {
			this.methodOfAdjustment = methodOfAdjustment==null?null:methodOfAdjustment;
			return this;
		}
		@Override
		@RosettaAttribute("optionEntitlement")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement) {
			this.optionEntitlement = optionEntitlement==null?null:optionEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("clearingInstructions")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions) {
			this.clearingInstructions = clearingInstructions==null?null:clearingInstructions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("varianceSwapTransactionSupplement")
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setVarianceSwapTransactionSupplement(VarianceSwapTransactionSupplement varianceSwapTransactionSupplement) {
			this.varianceSwapTransactionSupplement = varianceSwapTransactionSupplement==null?null:varianceSwapTransactionSupplement.toBuilder();
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement build() {
			return new VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementImpl(this);
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder prune() {
			super.prune();
			if (equityPremium!=null && !equityPremium.prune().hasData()) equityPremium = null;
			if (equityExercise!=null && !equityExercise.prune().hasData()) equityExercise = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			if (varianceSwapTransactionSupplement!=null && !varianceSwapTransactionSupplement.prune().hasData()) varianceSwapTransactionSupplement = null;
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
			if (getVarianceSwapTransactionSupplement()!=null && getVarianceSwapTransactionSupplement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder o = (VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getEquityPremium(), o.getEquityPremium(), this::setEquityPremium);
			merger.mergeRosetta(getEquityExercise(), o.getEquityExercise(), this::setEquityExercise);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			merger.mergeRosetta(getVarianceSwapTransactionSupplement(), o.getVarianceSwapTransactionSupplement(), this::setVarianceSwapTransactionSupplement);
			
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
		
			VarianceOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(varianceSwapTransactionSupplement, _that.getVarianceSwapTransactionSupplement())) return false;
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
			_result = 31 * _result + (varianceSwapTransactionSupplement != null ? varianceSwapTransactionSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceOptionTransactionSupplementBuilder {" +
				"equityPremium=" + this.equityPremium + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"varianceSwapTransactionSupplement=" + this.varianceSwapTransactionSupplement +
			'}' + " " + super.toString();
		}
	}
}
