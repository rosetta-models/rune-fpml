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
import fpml.confirmation.DefaultRateExpiry;
import fpml.confirmation.DefaultRateExpiry.DefaultRateExpiryBuilder;
import fpml.confirmation.DefaultRateExpiry.DefaultRateExpiryBuilderImpl;
import fpml.confirmation.DefaultRateExpiry.DefaultRateExpiryImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.DefaultRateExpiryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event representing expiration of the default rate applicable to borrowers in default.
 * @version ${project.version}
 */
@RosettaDataType(value="DefaultRateExpiry", builder=DefaultRateExpiry.DefaultRateExpiryBuilderImpl.class, version="${project.version}")
public interface DefaultRateExpiry extends AbstractFacilityContractEvent {

	DefaultRateExpiryMeta metaData = new DefaultRateExpiryMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DefaultRateExpiry build();
	
	DefaultRateExpiry.DefaultRateExpiryBuilder toBuilder();
	
	static DefaultRateExpiry.DefaultRateExpiryBuilder builder() {
		return new DefaultRateExpiry.DefaultRateExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DefaultRateExpiry> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DefaultRateExpiry> getType() {
		return DefaultRateExpiry.class;
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
	interface DefaultRateExpiryBuilder extends DefaultRateExpiry, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		DefaultRateExpiry.DefaultRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		DefaultRateExpiry.DefaultRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		DefaultRateExpiry.DefaultRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		DefaultRateExpiry.DefaultRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		DefaultRateExpiry.DefaultRateExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		DefaultRateExpiry.DefaultRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		DefaultRateExpiry.DefaultRateExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		DefaultRateExpiry.DefaultRateExpiryBuilder setComment(String comment);
		DefaultRateExpiry.DefaultRateExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		DefaultRateExpiry.DefaultRateExpiryBuilder setEffectiveDate(Date effectiveDate);
		DefaultRateExpiry.DefaultRateExpiryBuilder setFacilityReference(FacilityReference facilityReference);
		DefaultRateExpiry.DefaultRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		DefaultRateExpiry.DefaultRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		DefaultRateExpiry.DefaultRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		DefaultRateExpiry.DefaultRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);

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
		

		DefaultRateExpiry.DefaultRateExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of DefaultRateExpiry  ***********************/
	class DefaultRateExpiryImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements DefaultRateExpiry {
		
		protected DefaultRateExpiryImpl(DefaultRateExpiry.DefaultRateExpiryBuilder builder) {
			super(builder);
		}
		
		@Override
		public DefaultRateExpiry build() {
			return this;
		}
		
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder toBuilder() {
			DefaultRateExpiry.DefaultRateExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DefaultRateExpiry.DefaultRateExpiryBuilder builder) {
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
			return "DefaultRateExpiry {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DefaultRateExpiry  ***********************/
	class DefaultRateExpiryBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl  implements DefaultRateExpiry.DefaultRateExpiryBuilder {
	
	
		public DefaultRateExpiryBuilderImpl() {
		}
	
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DefaultRateExpiry.DefaultRateExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public DefaultRateExpiry.DefaultRateExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public DefaultRateExpiry.DefaultRateExpiryBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public DefaultRateExpiry.DefaultRateExpiryBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public DefaultRateExpiry build() {
			return new DefaultRateExpiry.DefaultRateExpiryImpl(this);
		}
		
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultRateExpiry.DefaultRateExpiryBuilder prune() {
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
		public DefaultRateExpiry.DefaultRateExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DefaultRateExpiry.DefaultRateExpiryBuilder o = (DefaultRateExpiry.DefaultRateExpiryBuilder) other;
			
			
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
			return "DefaultRateExpiryBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
