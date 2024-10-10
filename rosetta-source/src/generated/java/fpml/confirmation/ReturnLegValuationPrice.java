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
import fpml.confirmation.AmountReference;
import fpml.confirmation.Commission;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.Price;
import fpml.confirmation.Price.PriceBuilder;
import fpml.confirmation.Price.PriceBuilderImpl;
import fpml.confirmation.Price.PriceImpl;
import fpml.confirmation.PriceSequence;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.ReturnLegValuationPrice;
import fpml.confirmation.ReturnLegValuationPrice.ReturnLegValuationPriceBuilder;
import fpml.confirmation.ReturnLegValuationPrice.ReturnLegValuationPriceBuilderImpl;
import fpml.confirmation.ReturnLegValuationPrice.ReturnLegValuationPriceImpl;
import fpml.confirmation.meta.ReturnLegValuationPriceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnLegValuationPrice", builder=ReturnLegValuationPrice.ReturnLegValuationPriceBuilderImpl.class, version="${project.version}")
public interface ReturnLegValuationPrice extends Price {

	ReturnLegValuationPriceMeta metaData = new ReturnLegValuationPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies valuation.
	 */
	EquityValuation getValuationRules();

	/*********************** Build Methods  ***********************/
	ReturnLegValuationPrice build();
	
	ReturnLegValuationPrice.ReturnLegValuationPriceBuilder toBuilder();
	
	static ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder() {
		return new ReturnLegValuationPrice.ReturnLegValuationPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnLegValuationPrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnLegValuationPrice> getType() {
		return ReturnLegValuationPrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commission"), processor, Commission.class, getCommission());
		processRosetta(path.newSubPath("priceSequence"), processor, PriceSequence.class, getPriceSequence());
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processRosetta(path.newSubPath("equityPriceModel"), processor, EquityPriceModel.class, getEquityPriceModel());
		processor.processBasic(path.newSubPath("cleanNetPrice"), BigDecimal.class, getCleanNetPrice(), this);
		processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.class, getQuotationCharacteristics());
		processRosetta(path.newSubPath("valuationRules"), processor, EquityValuation.class, getValuationRules());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnLegValuationPriceBuilder extends ReturnLegValuationPrice, Price.PriceBuilder {
		EquityValuation.EquityValuationBuilder getOrCreateValuationRules();
		EquityValuation.EquityValuationBuilder getValuationRules();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCommission(Commission commission);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setPriceSequence(PriceSequence priceSequence);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setEquityPriceModel(EquityPriceModel equityPriceModel);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCleanNetPrice(BigDecimal cleanNetPrice);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics);
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setValuationRules(EquityValuation valuationRules);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commission"), processor, Commission.CommissionBuilder.class, getCommission());
			processRosetta(path.newSubPath("priceSequence"), processor, PriceSequence.PriceSequenceBuilder.class, getPriceSequence());
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processRosetta(path.newSubPath("equityPriceModel"), processor, EquityPriceModel.EquityPriceModelBuilder.class, getEquityPriceModel());
			processor.processBasic(path.newSubPath("cleanNetPrice"), BigDecimal.class, getCleanNetPrice(), this);
			processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getQuotationCharacteristics());
			processRosetta(path.newSubPath("valuationRules"), processor, EquityValuation.EquityValuationBuilder.class, getValuationRules());
		}
		

		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnLegValuationPrice  ***********************/
	class ReturnLegValuationPriceImpl extends Price.PriceImpl implements ReturnLegValuationPrice {
		private final EquityValuation valuationRules;
		
		protected ReturnLegValuationPriceImpl(ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder) {
			super(builder);
			this.valuationRules = ofNullable(builder.getValuationRules()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuationRules")
		public EquityValuation getValuationRules() {
			return valuationRules;
		}
		
		@Override
		public ReturnLegValuationPrice build() {
			return this;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder toBuilder() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnLegValuationPrice.ReturnLegValuationPriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValuationRules()).ifPresent(builder::setValuationRules);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLegValuationPrice _that = getType().cast(o);
		
			if (!Objects.equals(valuationRules, _that.getValuationRules())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationRules != null ? valuationRules.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuationPrice {" +
				"valuationRules=" + this.valuationRules +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnLegValuationPrice  ***********************/
	class ReturnLegValuationPriceBuilderImpl extends Price.PriceBuilderImpl  implements ReturnLegValuationPrice.ReturnLegValuationPriceBuilder {
	
		protected EquityValuation.EquityValuationBuilder valuationRules;
	
		public ReturnLegValuationPriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("valuationRules")
		public EquityValuation.EquityValuationBuilder getValuationRules() {
			return valuationRules;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateValuationRules() {
			EquityValuation.EquityValuationBuilder result;
			if (valuationRules!=null) {
				result = valuationRules;
			}
			else {
				result = valuationRules = EquityValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commission")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCommission(Commission commission) {
			this.commission = commission==null?null:commission.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priceSequence")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setPriceSequence(PriceSequence priceSequence) {
			this.priceSequence = priceSequence==null?null:priceSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amountRelativeTo")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setAmountRelativeTo(AmountReference amountRelativeTo) {
			this.amountRelativeTo = amountRelativeTo==null?null:amountRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityPriceModel")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setEquityPriceModel(EquityPriceModel equityPriceModel) {
			this.equityPriceModel = equityPriceModel==null?null:equityPriceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cleanNetPrice")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setCleanNetPrice(BigDecimal cleanNetPrice) {
			this.cleanNetPrice = cleanNetPrice==null?null:cleanNetPrice;
			return this;
		}
		@Override
		@RosettaAttribute("quotationCharacteristics")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics) {
			this.quotationCharacteristics = quotationCharacteristics==null?null:quotationCharacteristics.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationRules")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder setValuationRules(EquityValuation valuationRules) {
			this.valuationRules = valuationRules==null?null:valuationRules.toBuilder();
			return this;
		}
		
		@Override
		public ReturnLegValuationPrice build() {
			return new ReturnLegValuationPrice.ReturnLegValuationPriceImpl(this);
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder prune() {
			super.prune();
			if (valuationRules!=null && !valuationRules.prune().hasData()) valuationRules = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValuationRules()!=null && getValuationRules().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder o = (ReturnLegValuationPrice.ReturnLegValuationPriceBuilder) other;
			
			merger.mergeRosetta(getValuationRules(), o.getValuationRules(), this::setValuationRules);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnLegValuationPrice _that = getType().cast(o);
		
			if (!Objects.equals(valuationRules, _that.getValuationRules())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuationRules != null ? valuationRules.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuationPriceBuilder {" +
				"valuationRules=" + this.valuationRules +
			'}' + " " + super.toString();
		}
	}
}
