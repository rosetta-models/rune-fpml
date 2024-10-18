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
import fpml.confirmation.FacilityRateChangeGroup;
import fpml.confirmation.FacilityRateChangeGroup.FacilityRateChangeGroupBuilder;
import fpml.confirmation.FacilityRateChangeGroup.FacilityRateChangeGroupBuilderImpl;
import fpml.confirmation.FacilityRateChangeGroup.FacilityRateChangeGroupImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.FacilityRateChangeGroupMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Head of the substitution group for all facility rate update events.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityRateChangeGroup", builder=FacilityRateChangeGroup.FacilityRateChangeGroupBuilderImpl.class, version="${project.version}")
public interface FacilityRateChangeGroup extends AbstractFacilityContractEvent {

	FacilityRateChangeGroupMeta metaData = new FacilityRateChangeGroupMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityRateChangeGroup build();
	
	FacilityRateChangeGroup.FacilityRateChangeGroupBuilder toBuilder();
	
	static FacilityRateChangeGroup.FacilityRateChangeGroupBuilder builder() {
		return new FacilityRateChangeGroup.FacilityRateChangeGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityRateChangeGroup> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityRateChangeGroup> getType() {
		return FacilityRateChangeGroup.class;
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
	interface FacilityRateChangeGroupBuilder extends FacilityRateChangeGroup, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setComment(String comment);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setEffectiveDate(Date effectiveDate);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);

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
		

		FacilityRateChangeGroup.FacilityRateChangeGroupBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityRateChangeGroup  ***********************/
	class FacilityRateChangeGroupImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements FacilityRateChangeGroup {
		
		protected FacilityRateChangeGroupImpl(FacilityRateChangeGroup.FacilityRateChangeGroupBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityRateChangeGroup build() {
			return this;
		}
		
		@Override
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder toBuilder() {
			FacilityRateChangeGroup.FacilityRateChangeGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityRateChangeGroup.FacilityRateChangeGroupBuilder builder) {
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
			return "FacilityRateChangeGroup {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityRateChangeGroup  ***********************/
	class FacilityRateChangeGroupBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl  implements FacilityRateChangeGroup.FacilityRateChangeGroupBuilder {
	
	
		public FacilityRateChangeGroupBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public FacilityRateChangeGroup build() {
			return new FacilityRateChangeGroup.FacilityRateChangeGroupImpl(this);
		}
		
		@Override
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder prune() {
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
		public FacilityRateChangeGroup.FacilityRateChangeGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityRateChangeGroup.FacilityRateChangeGroupBuilder o = (FacilityRateChangeGroup.FacilityRateChangeGroupBuilder) other;
			
			
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
			return "FacilityRateChangeGroupBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
