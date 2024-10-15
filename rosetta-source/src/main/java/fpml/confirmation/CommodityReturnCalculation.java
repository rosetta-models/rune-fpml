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
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommodityReturnCalculation;
import fpml.confirmation.CommodityReturnCalculation.CommodityReturnCalculationBuilder;
import fpml.confirmation.CommodityReturnCalculation.CommodityReturnCalculationBuilderImpl;
import fpml.confirmation.CommodityReturnCalculation.CommodityReturnCalculationImpl;
import fpml.confirmation.CommodityReturnCalculationFormulaEnum;
import fpml.confirmation.CommodityValuationDates;
import fpml.confirmation.meta.CommodityReturnCalculationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityReturnCalculation", builder=CommodityReturnCalculation.CommodityReturnCalculationBuilderImpl.class, version="${project.version}")
public interface CommodityReturnCalculation extends RosettaModelObject {

	CommodityReturnCalculationMeta metaData = new CommodityReturnCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the value of the commodity return calculation formula as simple or compound.
	 */
	CommodityReturnCalculationFormulaEnum getFormula();
	/**
	 * Describes which dates are valid dates on which to observe a price or index level
	 */
	CommodityPricingDates getPricingDates();
	/**
	 * Defines when a price or index level will be observed that will figure in the return calculation.
	 */
	CommodityValuationDates getValuationDates();
	/**
	 * If specified in the confirmation, the price or index level at the beginning of the initial Calculation Period. For example, if the return calculation is [(Index End / Index Begin) - 1] and Index Begin is defined as equal to Index End for the immediately preceeding Calculation Period, then the value of Index Begin in the very first Calculation Period is not defined and is usually specified in the confirmation.
	 */
	BigDecimal getInitialPrice();

	/*********************** Build Methods  ***********************/
	CommodityReturnCalculation build();
	
	CommodityReturnCalculation.CommodityReturnCalculationBuilder toBuilder();
	
	static CommodityReturnCalculation.CommodityReturnCalculationBuilder builder() {
		return new CommodityReturnCalculation.CommodityReturnCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityReturnCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityReturnCalculation> getType() {
		return CommodityReturnCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("formula"), CommodityReturnCalculationFormulaEnum.class, getFormula(), this);
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("initialPrice"), BigDecimal.class, getInitialPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityReturnCalculationBuilder extends CommodityReturnCalculation, RosettaModelObjectBuilder {
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityValuationDates.CommodityValuationDatesBuilder getOrCreateValuationDates();
		CommodityValuationDates.CommodityValuationDatesBuilder getValuationDates();
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setFormula(CommodityReturnCalculationFormulaEnum formula);
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setValuationDates(CommodityValuationDates valuationDates);
		CommodityReturnCalculation.CommodityReturnCalculationBuilder setInitialPrice(BigDecimal initialPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("formula"), CommodityReturnCalculationFormulaEnum.class, getFormula(), this);
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.CommodityValuationDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("initialPrice"), BigDecimal.class, getInitialPrice(), this);
		}
		

		CommodityReturnCalculation.CommodityReturnCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityReturnCalculation  ***********************/
	class CommodityReturnCalculationImpl implements CommodityReturnCalculation {
		private final CommodityReturnCalculationFormulaEnum formula;
		private final CommodityPricingDates pricingDates;
		private final CommodityValuationDates valuationDates;
		private final BigDecimal initialPrice;
		
		protected CommodityReturnCalculationImpl(CommodityReturnCalculation.CommodityReturnCalculationBuilder builder) {
			this.formula = builder.getFormula();
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.initialPrice = builder.getInitialPrice();
		}
		
		@Override
		@RosettaAttribute("formula")
		public CommodityReturnCalculationFormulaEnum getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		public CommodityValuationDates getValuationDates() {
			return valuationDates;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		public BigDecimal getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		public CommodityReturnCalculation build() {
			return this;
		}
		
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder toBuilder() {
			CommodityReturnCalculation.CommodityReturnCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityReturnCalculation.CommodityReturnCalculationBuilder builder) {
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getInitialPrice()).ifPresent(builder::setInitialPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReturnCalculation _that = getType().cast(o);
		
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (formula != null ? formula.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnCalculation {" +
				"formula=" + this.formula + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"initialPrice=" + this.initialPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityReturnCalculation  ***********************/
	class CommodityReturnCalculationBuilderImpl implements CommodityReturnCalculation.CommodityReturnCalculationBuilder {
	
		protected CommodityReturnCalculationFormulaEnum formula;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected CommodityValuationDates.CommodityValuationDatesBuilder valuationDates;
		protected BigDecimal initialPrice;
	
		public CommodityReturnCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("formula")
		public CommodityReturnCalculationFormulaEnum getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		public CommodityValuationDates.CommodityValuationDatesBuilder getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public CommodityValuationDates.CommodityValuationDatesBuilder getOrCreateValuationDates() {
			CommodityValuationDates.CommodityValuationDatesBuilder result;
			if (valuationDates!=null) {
				result = valuationDates;
			}
			else {
				result = valuationDates = CommodityValuationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		public BigDecimal getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		@RosettaAttribute("formula")
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setFormula(CommodityReturnCalculationFormulaEnum formula) {
			this.formula = formula==null?null:formula;
			return this;
		}
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDates")
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setValuationDates(CommodityValuationDates valuationDates) {
			this.valuationDates = valuationDates==null?null:valuationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialPrice")
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder setInitialPrice(BigDecimal initialPrice) {
			this.initialPrice = initialPrice==null?null:initialPrice;
			return this;
		}
		
		@Override
		public CommodityReturnCalculation build() {
			return new CommodityReturnCalculation.CommodityReturnCalculationImpl(this);
		}
		
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder prune() {
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFormula()!=null) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getInitialPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReturnCalculation.CommodityReturnCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityReturnCalculation.CommodityReturnCalculationBuilder o = (CommodityReturnCalculation.CommodityReturnCalculationBuilder) other;
			
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			
			merger.mergeBasic(getFormula(), o.getFormula(), this::setFormula);
			merger.mergeBasic(getInitialPrice(), o.getInitialPrice(), this::setInitialPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReturnCalculation _that = getType().cast(o);
		
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (formula != null ? formula.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReturnCalculationBuilder {" +
				"formula=" + this.formula + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"initialPrice=" + this.initialPrice +
			'}';
		}
	}
}
