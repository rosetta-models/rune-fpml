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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AdmissionToTrading;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.ProductSummary;
import fpml.confirmation.ProductSummary.ProductSummaryBuilder;
import fpml.confirmation.ProductSummary.ProductSummaryBuilderImpl;
import fpml.confirmation.ProductSummary.ProductSummaryImpl;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.meta.ProductSummaryMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Summary information about the product that was traded. This is intended primarily for trade reporting by TRs.
 * @version ${project.version}
 */
@RosettaDataType(value="ProductSummary", builder=ProductSummary.ProductSummaryBuilderImpl.class, version="${project.version}")
public interface ProductSummary extends RosettaModelObject {

	ProductSummaryMeta metaData = new ProductSummaryMeta();

	/*********************** Getter Methods  ***********************/
	Date getFinalSettlementDate();
	SettlementTypeEnum getSettlementType();
	/**
	 * DEPRECATED. Use instead the field within credit products: indexReferenceInformation/seniority (RPTWG decision 2017-09)
	 */
	CreditSeniority getSeniority();
	/**
	 * DEPRECATED. Use instead the field within credit products: indexReferenceInformation/indexFactor (RPTWG decision 2017-09)
	 */
	BigDecimal getIndexFactor();
	AdmissionToTrading getAdmissionToTrading();

	/*********************** Build Methods  ***********************/
	ProductSummary build();
	
	ProductSummary.ProductSummaryBuilder toBuilder();
	
	static ProductSummary.ProductSummaryBuilder builder() {
		return new ProductSummary.ProductSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductSummary> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ProductSummary> getType() {
		return ProductSummary.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("finalSettlementDate"), Date.class, getFinalSettlementDate(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processRosetta(path.newSubPath("admissionToTrading"), processor, AdmissionToTrading.class, getAdmissionToTrading());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductSummaryBuilder extends ProductSummary, RosettaModelObjectBuilder {
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		AdmissionToTrading.AdmissionToTradingBuilder getOrCreateAdmissionToTrading();
		AdmissionToTrading.AdmissionToTradingBuilder getAdmissionToTrading();
		ProductSummary.ProductSummaryBuilder setFinalSettlementDate(Date finalSettlementDate);
		ProductSummary.ProductSummaryBuilder setSettlementType(SettlementTypeEnum settlementType);
		ProductSummary.ProductSummaryBuilder setSeniority(CreditSeniority seniority);
		ProductSummary.ProductSummaryBuilder setIndexFactor(BigDecimal indexFactor);
		ProductSummary.ProductSummaryBuilder setAdmissionToTrading(AdmissionToTrading admissionToTrading);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("finalSettlementDate"), Date.class, getFinalSettlementDate(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processRosetta(path.newSubPath("admissionToTrading"), processor, AdmissionToTrading.AdmissionToTradingBuilder.class, getAdmissionToTrading());
		}
		

		ProductSummary.ProductSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of ProductSummary  ***********************/
	class ProductSummaryImpl implements ProductSummary {
		private final Date finalSettlementDate;
		private final SettlementTypeEnum settlementType;
		private final CreditSeniority seniority;
		private final BigDecimal indexFactor;
		private final AdmissionToTrading admissionToTrading;
		
		protected ProductSummaryImpl(ProductSummary.ProductSummaryBuilder builder) {
			this.finalSettlementDate = builder.getFinalSettlementDate();
			this.settlementType = builder.getSettlementType();
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.indexFactor = builder.getIndexFactor();
			this.admissionToTrading = ofNullable(builder.getAdmissionToTrading()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		public Date getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("admissionToTrading")
		public AdmissionToTrading getAdmissionToTrading() {
			return admissionToTrading;
		}
		
		@Override
		public ProductSummary build() {
			return this;
		}
		
		@Override
		public ProductSummary.ProductSummaryBuilder toBuilder() {
			ProductSummary.ProductSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductSummary.ProductSummaryBuilder builder) {
			ofNullable(getFinalSettlementDate()).ifPresent(builder::setFinalSettlementDate);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getAdmissionToTrading()).ifPresent(builder::setAdmissionToTrading);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductSummary _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(admissionToTrading, _that.getAdmissionToTrading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (admissionToTrading != null ? admissionToTrading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductSummary {" +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"settlementType=" + this.settlementType + ", " +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"admissionToTrading=" + this.admissionToTrading +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductSummary  ***********************/
	class ProductSummaryBuilderImpl implements ProductSummary.ProductSummaryBuilder {
	
		protected Date finalSettlementDate;
		protected SettlementTypeEnum settlementType;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected BigDecimal indexFactor;
		protected AdmissionToTrading.AdmissionToTradingBuilder admissionToTrading;
	
		public ProductSummaryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("finalSettlementDate")
		public Date getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("admissionToTrading")
		public AdmissionToTrading.AdmissionToTradingBuilder getAdmissionToTrading() {
			return admissionToTrading;
		}
		
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder getOrCreateAdmissionToTrading() {
			AdmissionToTrading.AdmissionToTradingBuilder result;
			if (admissionToTrading!=null) {
				result = admissionToTrading;
			}
			else {
				result = admissionToTrading = AdmissionToTrading.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		public ProductSummary.ProductSummaryBuilder setFinalSettlementDate(Date finalSettlementDate) {
			this.finalSettlementDate = finalSettlementDate==null?null:finalSettlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public ProductSummary.ProductSummaryBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		@RosettaAttribute("seniority")
		public ProductSummary.ProductSummaryBuilder setSeniority(CreditSeniority seniority) {
			this.seniority = seniority==null?null:seniority.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexFactor")
		public ProductSummary.ProductSummaryBuilder setIndexFactor(BigDecimal indexFactor) {
			this.indexFactor = indexFactor==null?null:indexFactor;
			return this;
		}
		@Override
		@RosettaAttribute("admissionToTrading")
		public ProductSummary.ProductSummaryBuilder setAdmissionToTrading(AdmissionToTrading admissionToTrading) {
			this.admissionToTrading = admissionToTrading==null?null:admissionToTrading.toBuilder();
			return this;
		}
		
		@Override
		public ProductSummary build() {
			return new ProductSummary.ProductSummaryImpl(this);
		}
		
		@Override
		public ProductSummary.ProductSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductSummary.ProductSummaryBuilder prune() {
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			if (admissionToTrading!=null && !admissionToTrading.prune().hasData()) admissionToTrading = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinalSettlementDate()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getAdmissionToTrading()!=null && getAdmissionToTrading().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductSummary.ProductSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductSummary.ProductSummaryBuilder o = (ProductSummary.ProductSummaryBuilder) other;
			
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getAdmissionToTrading(), o.getAdmissionToTrading(), this::setAdmissionToTrading);
			
			merger.mergeBasic(getFinalSettlementDate(), o.getFinalSettlementDate(), this::setFinalSettlementDate);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductSummary _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(admissionToTrading, _that.getAdmissionToTrading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (admissionToTrading != null ? admissionToTrading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductSummaryBuilder {" +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"settlementType=" + this.settlementType + ", " +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"admissionToTrading=" + this.admissionToTrading +
			'}';
		}
	}
}
