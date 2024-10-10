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
import fpml.confirmation.FacilityRateChangeEvent;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilder;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MandatoryCostRateChange;
import fpml.confirmation.MandatoryCostRateChange.MandatoryCostRateChangeBuilder;
import fpml.confirmation.MandatoryCostRateChange.MandatoryCostRateChangeBuilderImpl;
import fpml.confirmation.MandatoryCostRateChange.MandatoryCostRateChangeImpl;
import fpml.confirmation.PeriodRate;
import fpml.confirmation.meta.MandatoryCostRateChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event representing a change in the mandatory cost rate, applicable to certain outstanding loans in the UK market.
 * @version ${project.version}
 */
@RosettaDataType(value="MandatoryCostRateChange", builder=MandatoryCostRateChange.MandatoryCostRateChangeBuilderImpl.class, version="${project.version}")
public interface MandatoryCostRateChange extends FacilityRateChangeEvent {

	MandatoryCostRateChangeMeta metaData = new MandatoryCostRateChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MandatoryCostRateChange build();
	
	MandatoryCostRateChange.MandatoryCostRateChangeBuilder toBuilder();
	
	static MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder() {
		return new MandatoryCostRateChange.MandatoryCostRateChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryCostRateChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MandatoryCostRateChange> getType() {
		return MandatoryCostRateChange.class;
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
	interface MandatoryCostRateChangeBuilder extends MandatoryCostRateChange, FacilityRateChangeEvent.FacilityRateChangeEventBuilder {
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setComment(String comment);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEffectiveDate(Date effectiveDate);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setFacilityReference(FacilityReference facilityReference);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		MandatoryCostRateChange.MandatoryCostRateChangeBuilder setRate(PeriodRate rate);

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
		

		MandatoryCostRateChange.MandatoryCostRateChangeBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryCostRateChange  ***********************/
	class MandatoryCostRateChangeImpl extends FacilityRateChangeEvent.FacilityRateChangeEventImpl implements MandatoryCostRateChange {
		
		protected MandatoryCostRateChangeImpl(MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public MandatoryCostRateChange build() {
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder toBuilder() {
			MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryCostRateChange.MandatoryCostRateChangeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "MandatoryCostRateChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MandatoryCostRateChange  ***********************/
	class MandatoryCostRateChangeBuilderImpl extends FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl  implements MandatoryCostRateChange.MandatoryCostRateChangeBuilder {
	
	
		public MandatoryCostRateChangeBuilderImpl() {
		}
	
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder setRate(PeriodRate rate) {
			this.rate = rate==null?null:rate.toBuilder();
			return this;
		}
		
		@Override
		public MandatoryCostRateChange build() {
			return new MandatoryCostRateChange.MandatoryCostRateChangeImpl(this);
		}
		
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder prune() {
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
		public MandatoryCostRateChange.MandatoryCostRateChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MandatoryCostRateChange.MandatoryCostRateChangeBuilder o = (MandatoryCostRateChange.MandatoryCostRateChangeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "MandatoryCostRateChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
