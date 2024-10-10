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
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MiscFeePayment;
import fpml.confirmation.MiscFeePayment.MiscFeePaymentBuilder;
import fpml.confirmation.MiscFeePayment.MiscFeePaymentBuilderImpl;
import fpml.confirmation.MiscFeePayment.MiscFeePaymentImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilder;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl;
import fpml.confirmation.NonRecurringFeePayment.NonRecurringFeePaymentImpl;
import fpml.confirmation.NonRecurringMiscFeeType;
import fpml.confirmation.meta.MiscFeePaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing a non-recurring fee being paid at either the loan contract or facility level.
 * @version ${project.version}
 */
@RosettaDataType(value="MiscFeePayment", builder=MiscFeePayment.MiscFeePaymentBuilderImpl.class, version="${project.version}")
public interface MiscFeePayment extends NonRecurringFeePayment {

	MiscFeePaymentMeta metaData = new MiscFeePaymentMeta();

	/*********************** Getter Methods  ***********************/
	NonRecurringMiscFeeType getType();

	/*********************** Build Methods  ***********************/
	MiscFeePayment build();
	
	MiscFeePayment.MiscFeePaymentBuilder toBuilder();
	
	static MiscFeePayment.MiscFeePaymentBuilder builder() {
		return new MiscFeePayment.MiscFeePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MiscFeePayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MiscFeePayment> getType() {
		return MiscFeePayment.class;
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
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processRosetta(path.newSubPath("type"), processor, NonRecurringMiscFeeType.class, getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MiscFeePaymentBuilder extends MiscFeePayment, NonRecurringFeePayment.NonRecurringFeePaymentBuilder {
		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getOrCreateType();
		NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getType();
		MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		MiscFeePayment.MiscFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		MiscFeePayment.MiscFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		MiscFeePayment.MiscFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		MiscFeePayment.MiscFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		MiscFeePayment.MiscFeePaymentBuilder setComment(String comment);
		MiscFeePayment.MiscFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		MiscFeePayment.MiscFeePaymentBuilder setEffectiveDate(Date effectiveDate);
		MiscFeePayment.MiscFeePaymentBuilder setFacilityReference(FacilityReference facilityReference);
		MiscFeePayment.MiscFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		MiscFeePayment.MiscFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		MiscFeePayment.MiscFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		MiscFeePayment.MiscFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		MiscFeePayment.MiscFeePaymentBuilder setAmount(MoneyWithParticipantShare amount);
		MiscFeePayment.MiscFeePaymentBuilder setType(NonRecurringMiscFeeType type);

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
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processRosetta(path.newSubPath("type"), processor, NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder.class, getType());
		}
		

		MiscFeePayment.MiscFeePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of MiscFeePayment  ***********************/
	class MiscFeePaymentImpl extends NonRecurringFeePayment.NonRecurringFeePaymentImpl implements MiscFeePayment {
		private final NonRecurringMiscFeeType type;
		
		protected MiscFeePaymentImpl(MiscFeePayment.MiscFeePaymentBuilder builder) {
			super(builder);
			this.type = ofNullable(builder.getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public NonRecurringMiscFeeType getType() {
			return type;
		}
		
		@Override
		public MiscFeePayment build() {
			return this;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder toBuilder() {
			MiscFeePayment.MiscFeePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MiscFeePayment.MiscFeePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MiscFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MiscFeePayment {" +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MiscFeePayment  ***********************/
	class MiscFeePaymentBuilderImpl extends NonRecurringFeePayment.NonRecurringFeePaymentBuilderImpl  implements MiscFeePayment.MiscFeePaymentBuilder {
	
		protected NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder type;
	
		public MiscFeePaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getType() {
			return type;
		}
		
		@Override
		public NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder getOrCreateType() {
			NonRecurringMiscFeeType.NonRecurringMiscFeeTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = NonRecurringMiscFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public MiscFeePayment.MiscFeePaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public MiscFeePayment.MiscFeePaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public MiscFeePayment.MiscFeePaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public MiscFeePayment.MiscFeePaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public MiscFeePayment.MiscFeePaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public MiscFeePayment.MiscFeePaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public MiscFeePayment.MiscFeePaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public MiscFeePayment.MiscFeePaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public MiscFeePayment.MiscFeePaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public MiscFeePayment.MiscFeePaymentBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public MiscFeePayment.MiscFeePaymentBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		@RosettaAttribute("amount")
		public MiscFeePayment.MiscFeePaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("type")
		public MiscFeePayment.MiscFeePaymentBuilder setType(NonRecurringMiscFeeType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		
		@Override
		public MiscFeePayment build() {
			return new MiscFeePayment.MiscFeePaymentImpl(this);
		}
		
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getType()!=null && getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MiscFeePayment.MiscFeePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MiscFeePayment.MiscFeePaymentBuilder o = (MiscFeePayment.MiscFeePaymentBuilder) other;
			
			merger.mergeRosetta(getType(), o.getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MiscFeePayment _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MiscFeePaymentBuilder {" +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}
}
