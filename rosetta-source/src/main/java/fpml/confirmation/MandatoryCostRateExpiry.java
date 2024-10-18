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
import fpml.confirmation.MandatoryCostRateExpiry;
import fpml.confirmation.MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder;
import fpml.confirmation.MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilderImpl;
import fpml.confirmation.MandatoryCostRateExpiry.MandatoryCostRateExpiryImpl;
import fpml.confirmation.meta.MandatoryCostRateExpiryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event representing expiration of the mandatory cost rate applicable in the UK market.
 * @version ${project.version}
 */
@RosettaDataType(value="MandatoryCostRateExpiry", builder=MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilderImpl.class, version="${project.version}")
public interface MandatoryCostRateExpiry extends AbstractFacilityContractEvent {

	MandatoryCostRateExpiryMeta metaData = new MandatoryCostRateExpiryMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MandatoryCostRateExpiry build();
	
	MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder toBuilder();
	
	static MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder() {
		return new MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryCostRateExpiry> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MandatoryCostRateExpiry> getType() {
		return MandatoryCostRateExpiry.class;
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
	interface MandatoryCostRateExpiryBuilder extends MandatoryCostRateExpiry, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setComment(String comment);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEffectiveDate(Date effectiveDate);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setFacilityReference(FacilityReference facilityReference);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);

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
		

		MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryCostRateExpiry  ***********************/
	class MandatoryCostRateExpiryImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements MandatoryCostRateExpiry {
		
		protected MandatoryCostRateExpiryImpl(MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder) {
			super(builder);
		}
		
		@Override
		public MandatoryCostRateExpiry build() {
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder toBuilder() {
			MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder builder) {
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
			return "MandatoryCostRateExpiry {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MandatoryCostRateExpiry  ***********************/
	class MandatoryCostRateExpiryBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl  implements MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder {
	
	
		public MandatoryCostRateExpiryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public MandatoryCostRateExpiry build() {
			return new MandatoryCostRateExpiry.MandatoryCostRateExpiryImpl(this);
		}
		
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder prune() {
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
		public MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder o = (MandatoryCostRateExpiry.MandatoryCostRateExpiryBuilder) other;
			
			
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
			return "MandatoryCostRateExpiryBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
