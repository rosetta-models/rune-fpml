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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.DefaultRateChange;
import fpml.confirmation.DefaultRateChange.DefaultRateChangeBuilder;
import fpml.confirmation.DefaultRateChange.DefaultRateChangeBuilderImpl;
import fpml.confirmation.DefaultRateChange.DefaultRateChangeImpl;
import fpml.confirmation.FacilityRateChangeEvent;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilder;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.PeriodRate;
import fpml.confirmation.meta.DefaultRateChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event representing a change in the default rate, applicable to outstanding loans in the event that the borrower is declared to be in default.
 * @version ${project.version}
 */
@RosettaDataType(value="DefaultRateChange", builder=DefaultRateChange.DefaultRateChangeBuilderImpl.class, version="${project.version}")
public interface DefaultRateChange extends FacilityRateChangeEvent {

	DefaultRateChangeMeta metaData = new DefaultRateChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DefaultRateChange build();
	
	DefaultRateChange.DefaultRateChangeBuilder toBuilder();
	
	static DefaultRateChange.DefaultRateChangeBuilder builder() {
		return new DefaultRateChange.DefaultRateChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DefaultRateChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DefaultRateChange> getType() {
		return DefaultRateChange.class;
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
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("rate"), processor, PeriodRate.class, getRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DefaultRateChangeBuilder extends DefaultRateChange, FacilityRateChangeEvent.FacilityRateChangeEventBuilder {
		DefaultRateChange.DefaultRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		DefaultRateChange.DefaultRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		DefaultRateChange.DefaultRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		DefaultRateChange.DefaultRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		DefaultRateChange.DefaultRateChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		DefaultRateChange.DefaultRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		DefaultRateChange.DefaultRateChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		DefaultRateChange.DefaultRateChangeBuilder setComment(String comment);
		DefaultRateChange.DefaultRateChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		DefaultRateChange.DefaultRateChangeBuilder setEffectiveDate(Date effectiveDate);
		DefaultRateChange.DefaultRateChangeBuilder setFacilityReference(FacilityReference facilityReference);
		DefaultRateChange.DefaultRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		DefaultRateChange.DefaultRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		DefaultRateChange.DefaultRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		DefaultRateChange.DefaultRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		DefaultRateChange.DefaultRateChangeBuilder setRate(PeriodRate rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("rate"), processor, PeriodRate.PeriodRateBuilder.class, getRate());
		}
		

		DefaultRateChange.DefaultRateChangeBuilder prune();
	}

	/*********************** Immutable Implementation of DefaultRateChange  ***********************/
	class DefaultRateChangeImpl extends FacilityRateChangeEvent.FacilityRateChangeEventImpl implements DefaultRateChange {
		
		protected DefaultRateChangeImpl(DefaultRateChange.DefaultRateChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public DefaultRateChange build() {
			return this;
		}
		
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder toBuilder() {
			DefaultRateChange.DefaultRateChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DefaultRateChange.DefaultRateChangeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DefaultRateChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DefaultRateChange  ***********************/
	class DefaultRateChangeBuilderImpl extends FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl  implements DefaultRateChange.DefaultRateChangeBuilder {
	
	
		public DefaultRateChangeBuilderImpl() {
		}
	
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DefaultRateChange.DefaultRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public DefaultRateChange.DefaultRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public DefaultRateChange.DefaultRateChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public DefaultRateChange.DefaultRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public DefaultRateChange.DefaultRateChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public DefaultRateChange.DefaultRateChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public DefaultRateChange.DefaultRateChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public DefaultRateChange.DefaultRateChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public DefaultRateChange.DefaultRateChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public DefaultRateChange.DefaultRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public DefaultRateChange.DefaultRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null)  {
				this.loanContractReference = new ArrayList<>();
			}
			else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("rate")
		public DefaultRateChange.DefaultRateChangeBuilder setRate(PeriodRate rate) {
			this.rate = rate==null?null:rate.toBuilder();
			return this;
		}
		
		@Override
		public DefaultRateChange build() {
			return new DefaultRateChange.DefaultRateChangeImpl(this);
		}
		
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultRateChange.DefaultRateChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DefaultRateChange.DefaultRateChangeBuilder o = (DefaultRateChange.DefaultRateChangeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DefaultRateChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
