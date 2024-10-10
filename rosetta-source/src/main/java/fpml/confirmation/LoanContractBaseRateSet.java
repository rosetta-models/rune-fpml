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
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilder;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.LoanContractBaseRateSet.LoanContractBaseRateSetBuilder;
import fpml.confirmation.LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl;
import fpml.confirmation.LoanContractBaseRateSet.LoanContractBaseRateSetImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.LoanContractBaseRateSetMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing the initial setting of the rate on a single (new) loan contract.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractBaseRateSet", builder=LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl.class, version="${project.version}")
public interface LoanContractBaseRateSet extends AbstractLoanContractEvent {

	LoanContractBaseRateSetMeta metaData = new LoanContractBaseRateSetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the underlying interest rate is fixed. It is an actual (adjusted) date. Note: This should default to the effective date of the loan contract in the case of a PRIME base rate.
	 */
	Date getFixingDate();
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	LoanContractBaseRateSet build();
	
	LoanContractBaseRateSet.LoanContractBaseRateSetBuilder toBuilder();
	
	static LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder() {
		return new LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractBaseRateSet> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractBaseRateSet> getType() {
		return LoanContractBaseRateSet.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractBaseRateSetBuilder extends LoanContractBaseRateSet, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setComment(String comment);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEffectiveDate(Date effectiveDate);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setFixingDate(Date fixingDate);
		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		LoanContractBaseRateSet.LoanContractBaseRateSetBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractBaseRateSet  ***********************/
	class LoanContractBaseRateSetImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanContractBaseRateSet {
		private final Date fixingDate;
		private final BigDecimal rate;
		
		protected LoanContractBaseRateSetImpl(LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder) {
			super(builder);
			this.fixingDate = builder.getFixingDate();
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public LoanContractBaseRateSet build() {
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder toBuilder() {
			LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractBaseRateSet.LoanContractBaseRateSetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractBaseRateSet _that = getType().cast(o);
		
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractBaseRateSet {" +
				"fixingDate=" + this.fixingDate + ", " +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractBaseRateSet  ***********************/
	class LoanContractBaseRateSetBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements LoanContractBaseRateSet.LoanContractBaseRateSetBuilder {
	
		protected Date fixingDate;
		protected BigDecimal rate;
	
		public LoanContractBaseRateSetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixingDate")
		public Date getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setFixingDate(Date fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public LoanContractBaseRateSet build() {
			return new LoanContractBaseRateSet.LoanContractBaseRateSetImpl(this);
		}
		
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractBaseRateSet.LoanContractBaseRateSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContractBaseRateSet.LoanContractBaseRateSetBuilder o = (LoanContractBaseRateSet.LoanContractBaseRateSetBuilder) other;
			
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractBaseRateSet _that = getType().cast(o);
		
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractBaseRateSetBuilder {" +
				"fixingDate=" + this.fixingDate + ", " +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
