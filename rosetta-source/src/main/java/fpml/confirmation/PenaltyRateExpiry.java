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
import fpml.confirmation.AbstractFacilityContractEvent;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.PenaltyRateExpiry;
import fpml.confirmation.PenaltyRateExpiry.PenaltyRateExpiryBuilder;
import fpml.confirmation.PenaltyRateExpiry.PenaltyRateExpiryBuilderImpl;
import fpml.confirmation.PenaltyRateExpiry.PenaltyRateExpiryImpl;
import fpml.confirmation.meta.PenaltyRateExpiryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event representing expiration of the penalty rate.
 * @version ${project.version}
 */
@RosettaDataType(value="PenaltyRateExpiry", builder=PenaltyRateExpiry.PenaltyRateExpiryBuilderImpl.class, version="${project.version}")
public interface PenaltyRateExpiry extends AbstractFacilityContractEvent {

	PenaltyRateExpiryMeta metaData = new PenaltyRateExpiryMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PenaltyRateExpiry build();
	
	PenaltyRateExpiry.PenaltyRateExpiryBuilder toBuilder();
	
	static PenaltyRateExpiry.PenaltyRateExpiryBuilder builder() {
		return new PenaltyRateExpiry.PenaltyRateExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PenaltyRateExpiry> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PenaltyRateExpiry> getType() {
		return PenaltyRateExpiry.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface PenaltyRateExpiryBuilder extends PenaltyRateExpiry, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		PenaltyRateExpiry.PenaltyRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setComment(String comment);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setEffectiveDate(Date effectiveDate);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setFacilityReference(FacilityReference facilityReference);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		PenaltyRateExpiry.PenaltyRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);

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
		}
		

		PenaltyRateExpiry.PenaltyRateExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of PenaltyRateExpiry  ***********************/
	class PenaltyRateExpiryImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements PenaltyRateExpiry {
		
		protected PenaltyRateExpiryImpl(PenaltyRateExpiry.PenaltyRateExpiryBuilder builder) {
			super(builder);
		}
		
		@Override
		public PenaltyRateExpiry build() {
			return this;
		}
		
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder toBuilder() {
			PenaltyRateExpiry.PenaltyRateExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PenaltyRateExpiry.PenaltyRateExpiryBuilder builder) {
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
			return "PenaltyRateExpiry {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PenaltyRateExpiry  ***********************/
	class PenaltyRateExpiryBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl  implements PenaltyRateExpiry.PenaltyRateExpiryBuilder {
	
	
		public PenaltyRateExpiryBuilderImpl() {
		}
	
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public PenaltyRateExpiry build() {
			return new PenaltyRateExpiry.PenaltyRateExpiryImpl(this);
		}
		
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder prune() {
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
		public PenaltyRateExpiry.PenaltyRateExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PenaltyRateExpiry.PenaltyRateExpiryBuilder o = (PenaltyRateExpiry.PenaltyRateExpiryBuilder) other;
			
			
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
			return "PenaltyRateExpiryBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
