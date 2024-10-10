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
import fpml.confirmation.CommodityValuationDates;
import fpml.confirmation.CommodityVarianceCalculation;
import fpml.confirmation.CommodityVarianceCalculation.CommodityVarianceCalculationBuilder;
import fpml.confirmation.CommodityVarianceCalculation.CommodityVarianceCalculationBuilderImpl;
import fpml.confirmation.CommodityVarianceCalculation.CommodityVarianceCalculationImpl;
import fpml.confirmation.meta.CommodityVarianceCalculationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityVarianceCalculation", builder=CommodityVarianceCalculation.CommodityVarianceCalculationBuilderImpl.class, version="${project.version}")
public interface CommodityVarianceCalculation extends RosettaModelObject {

	CommodityVarianceCalculationMeta metaData = new CommodityVarianceCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes which dates are valid dates on which to observe a price or index level.
	 */
	CommodityPricingDates getPricingDates();
	/**
	 * Defines when a price or index level will be observed that will figure in the return calculation.
	 */
	CommodityValuationDates getValuationDates();
	/**
	 * This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
	 */
	BigDecimal getAnnualizationFactor();
	/**
	 * Specifies whether denominator of the annualization factor is N (&quot;false&quot;) or N - 1 (&quot;true&quot;).
	 */
	Boolean getNAdjustment();

	/*********************** Build Methods  ***********************/
	CommodityVarianceCalculation build();
	
	CommodityVarianceCalculation.CommodityVarianceCalculationBuilder toBuilder();
	
	static CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder() {
		return new CommodityVarianceCalculation.CommodityVarianceCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityVarianceCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityVarianceCalculation> getType() {
		return CommodityVarianceCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
		processor.processBasic(path.newSubPath("nAdjustment"), Boolean.class, getNAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityVarianceCalculationBuilder extends CommodityVarianceCalculation, RosettaModelObjectBuilder {
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityValuationDates.CommodityValuationDatesBuilder getOrCreateValuationDates();
		CommodityValuationDates.CommodityValuationDatesBuilder getValuationDates();
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setValuationDates(CommodityValuationDates valuationDates);
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setNAdjustment(Boolean nAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processRosetta(path.newSubPath("valuationDates"), processor, CommodityValuationDates.CommodityValuationDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
			processor.processBasic(path.newSubPath("nAdjustment"), Boolean.class, getNAdjustment(), this);
		}
		

		CommodityVarianceCalculation.CommodityVarianceCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityVarianceCalculation  ***********************/
	class CommodityVarianceCalculationImpl implements CommodityVarianceCalculation {
		private final CommodityPricingDates pricingDates;
		private final CommodityValuationDates valuationDates;
		private final BigDecimal annualizationFactor;
		private final Boolean nAdjustment;
		
		protected CommodityVarianceCalculationImpl(CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder) {
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.annualizationFactor = builder.getAnnualizationFactor();
			this.nAdjustment = builder.getNAdjustment();
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
		@RosettaAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("nAdjustment")
		public Boolean getNAdjustment() {
			return nAdjustment;
		}
		
		@Override
		public CommodityVarianceCalculation build() {
			return this;
		}
		
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder toBuilder() {
			CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityVarianceCalculation.CommodityVarianceCalculationBuilder builder) {
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getAnnualizationFactor()).ifPresent(builder::setAnnualizationFactor);
			ofNullable(getNAdjustment()).ifPresent(builder::setNAdjustment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityVarianceCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(nAdjustment, _that.getNAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (nAdjustment != null ? nAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityVarianceCalculation {" +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"nAdjustment=" + this.nAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityVarianceCalculation  ***********************/
	class CommodityVarianceCalculationBuilderImpl implements CommodityVarianceCalculation.CommodityVarianceCalculationBuilder {
	
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected CommodityValuationDates.CommodityValuationDatesBuilder valuationDates;
		protected BigDecimal annualizationFactor;
		protected Boolean nAdjustment;
	
		public CommodityVarianceCalculationBuilderImpl() {
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
		@RosettaAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("nAdjustment")
		public Boolean getNAdjustment() {
			return nAdjustment;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuationDates")
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setValuationDates(CommodityValuationDates valuationDates) {
			this.valuationDates = valuationDates==null?null:valuationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("annualizationFactor")
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setAnnualizationFactor(BigDecimal annualizationFactor) {
			this.annualizationFactor = annualizationFactor==null?null:annualizationFactor;
			return this;
		}
		@Override
		@RosettaAttribute("nAdjustment")
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder setNAdjustment(Boolean nAdjustment) {
			this.nAdjustment = nAdjustment==null?null:nAdjustment;
			return this;
		}
		
		@Override
		public CommodityVarianceCalculation build() {
			return new CommodityVarianceCalculation.CommodityVarianceCalculationImpl(this);
		}
		
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder prune() {
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getAnnualizationFactor()!=null) return true;
			if (getNAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityVarianceCalculation.CommodityVarianceCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityVarianceCalculation.CommodityVarianceCalculationBuilder o = (CommodityVarianceCalculation.CommodityVarianceCalculationBuilder) other;
			
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			
			merger.mergeBasic(getAnnualizationFactor(), o.getAnnualizationFactor(), this::setAnnualizationFactor);
			merger.mergeBasic(getNAdjustment(), o.getNAdjustment(), this::setNAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityVarianceCalculation _that = getType().cast(o);
		
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(nAdjustment, _that.getNAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (nAdjustment != null ? nAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityVarianceCalculationBuilder {" +
				"pricingDates=" + this.pricingDates + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"nAdjustment=" + this.nAdjustment +
			'}';
		}
	}
}
